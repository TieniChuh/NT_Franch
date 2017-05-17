/*
 * Creation : Mar 13, 2017
 */
package com.kin.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kin.dto.AcctUserDto;
import com.kin.model.user.AcctUser;
import com.kin.service.user.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping("/showInfo/{userId}")
    public String showUserInfo(ModelMap modelMap, @PathVariable String userId) {
        LOGGER.info("查询用户：" + userId);
        AcctUser userInfo = userService.load(userId);
        System.out.println("userInfo:" + userInfo.getNickName());

        modelMap.addAttribute("userInfo", userInfo);
        modelMap.addAttribute("nickName", "Nic001");
        return "/user/showInfo";
    }

    @RequestMapping("/showInfos")
    public @ResponseBody
    List<AcctUser> showUserInfos() {
        LOGGER.info("查询用户全部用户");
        List<AcctUser> userInfos = userService.findAll();
        return userInfos;
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public @ResponseBody
    String createUsers(@RequestBody AcctUserDto angularUser) {
        LOGGER.info("新增用户：" + angularUser.getNickName());
        AcctUser userInfo = new AcctUser();
        // UUID(Universally Unique Identifier)全局唯一标识符
        userInfo.setId(UUID.randomUUID().toString());
        userInfo.setNickName(angularUser.getNickName());
        userInfo.setTelephone(angularUser.getTelePhone());
        userInfo.setRegisterTime(new Date());

        String result = userService.save(userInfo);
        System.out.println("create result:" + result);

        return "/index111";
    }
}
