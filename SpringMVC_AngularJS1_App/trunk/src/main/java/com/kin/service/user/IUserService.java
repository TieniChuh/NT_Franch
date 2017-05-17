/*
 * Creation : Mar 13, 2017
 */
package com.kin.service.user;

import java.util.List;

import com.kin.model.user.AcctUser;

public interface IUserService {

    AcctUser load(String id);

    AcctUser get(String id);

    List<AcctUser> findAll();

    void persist(AcctUser entity);

    String save(AcctUser entity);

    void saveOrUpdate(AcctUser entity);

    void delete(String id);

    void flush();

}
