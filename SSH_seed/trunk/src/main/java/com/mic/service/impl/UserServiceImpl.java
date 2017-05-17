/*
 * Creation : Feb 4, 2017
 */
package com.mic.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.dao.IUserDao;
import com.mic.model.User;
import com.mic.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
    /**
     * 注入userDao
     */
    @Autowired
    private IUserDao userDao;

    public void test() {
        System.out.println("Hello World!");
    }

    public Serializable save(User user) {
        return userDao.save(user);
    }
}
