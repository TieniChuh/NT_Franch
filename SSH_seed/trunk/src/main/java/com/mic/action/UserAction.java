/*
 * Creation : Feb 4, 2017
 */
package com.mic.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.mic.service.IUserService;

@ParentPackage("basePackage")
@Action(value = "strust2Test")
// 使用convention-plugin插件提供的@Action注解将一个普通java类标注为一个可以处理用户请求的Action，Action的名字为struts2Test
@Namespace("/")
// 使用convention-plugin插件提供的@Namespace注解为这个Action指定一个命名空间
public class UserAction {
    /**
     * 注入userService
     */
    @Autowired
    private IUserService userService;

    /**
     * http://http://localhost:8080/Web_Creation/strust2Test!test.action MethodName: test Description:
     */
    public void test() {
        System.out.println("进入TestAction");
        userService.test();
    }
}
