/*
 * Creation : Feb 4, 2017
 */
package com.mic.service;

import java.io.Serializable;

import com.mic.model.User;

public interface IUserService {
    void test();

    /**
     * 保存用户
     * 
     * @param user
     * @return
     */
    Serializable save(User user);
}
