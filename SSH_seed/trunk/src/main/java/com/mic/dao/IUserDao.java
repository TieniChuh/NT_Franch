/*
 * Creation : Feb 4, 2017
 */
package com.mic.dao;

import java.io.Serializable;

import com.mic.model.User;

public interface IUserDao {

    /**
     * 保存用户
     * 
     * @param user
     * @return
     */
    Serializable save(User user);
}