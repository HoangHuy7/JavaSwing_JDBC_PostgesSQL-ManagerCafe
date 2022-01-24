/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.service.imp;

import com.managercafe.dao.IUserDAO;
import com.managercafe.dao.imp.UserDAO;
import com.managercafe.model.userModel;
import com.managercafe.service.IUserService;
import com.managercafe.view.frmLogin;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author huy
 */
public class UserService implements IUserService {

    private final IUserDAO userDao = new UserDAO();
    private final userModel userAccess = frmLogin.userAccess;

    @Override
    public List<userModel> findAll() {
        return userDao.FindAll();
    }

    @Override
    public List<userModel> findStatusOn() {

        return userDao.findStatusOn();
    }

    @Override
    public List<userModel> findStatusOff() {
        return userDao.findStatusOff();
    }

    @Override
    public List<userModel> findOneById(Long id) {
        return userDao.findOneById(id);
    }

    @Override
    public boolean insertUser(userModel usr) {
        List<userModel> allUser = userDao.FindAll();
        for (userModel model : allUser) {
            if (model.getUserName().equals(usr.getUserName())) {
                return false;
            }
        }
        usr.setCreatedby(String.valueOf(userAccess.getId()));
        usr.setCreateddate(new Timestamp(System.currentTimeMillis()));
        return userDao.insertUser(usr);
    }

    @Override
    public boolean setStatus(Long id, int status) {
        return userDao.setStatus(id, status);
    }

    @Override
    public boolean repair(userModel usr) {
        if ("Admin".equals(usr.getUserName())) {
            if (usr.getStatus() == 0 || usr.getRoleid() != 1) {
                return false;
            }
        }
        userModel oldUser = userDao.findOneById(usr.getId()).get(0);
        usr.setCreatedby(oldUser.getCreatedby());
        usr.setCreateddate(oldUser.getCreateddate());
        usr.setModifiedby(String.valueOf(userAccess.getId()));
        usr.setModifieddate(new Timestamp(System.currentTimeMillis()));
        return userDao.repair(usr);
    }

    @Override
    public List<userModel> checkLogin(String userName, String password) {
        return userDao.checkLogin(userName, password);
    }

}
