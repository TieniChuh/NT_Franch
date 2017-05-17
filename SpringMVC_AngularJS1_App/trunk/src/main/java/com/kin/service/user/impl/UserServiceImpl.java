/*
 * Creation : Mar 13, 2017
 */
package com.kin.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kin.dao.user.IUserDao;
import com.kin.model.user.AcctUser;
import com.kin.service.user.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    public AcctUser load(String id) {
        return userDao.load(id);
    }

    public AcctUser get(String id) {
        return userDao.get(id);
    }

    public List<AcctUser> findAll() {
        return userDao.findAll();
    }

    public void persist(AcctUser entity) {
        userDao.persist(entity);
    }

    public String save(AcctUser entity) {
        return userDao.save(entity);
    }

    public void saveOrUpdate(AcctUser entity) {
        userDao.saveOrUpdate(entity);
    }

    public void delete(String id) {
        userDao.delete(id);
    }

    public void flush() {
        userDao.flush();
    }

}
