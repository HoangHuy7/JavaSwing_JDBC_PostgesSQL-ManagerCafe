/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.dao;

import com.managercafe.model.userModel;
import java.util.List;

/**
 *
 * @author huy
 */
public interface IUserDAO extends IGenericDAO<userModel> {

    List<userModel> FindAll();

    List<userModel> findStatusOn();

    List<userModel> findStatusOff();

    List<userModel> findOneById(Long id);

    List<userModel> checkLogin(String userName, String password);

    boolean insertUser(userModel usr);

    boolean setStatus(Long id, int status);

    boolean repair(userModel usr);
}
