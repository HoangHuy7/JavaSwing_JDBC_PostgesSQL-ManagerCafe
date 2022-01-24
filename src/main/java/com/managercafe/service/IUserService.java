package com.managercafe.service;

import com.managercafe.model.userModel;
import java.util.List;

/**
 *
 * @author huy
 */
public interface IUserService {

    List<userModel> findAll();

    List<userModel> findStatusOn();

    List<userModel> findStatusOff();

    List<userModel> findOneById(Long id);
    
    List<userModel> checkLogin(String userName,String password);
    
    boolean insertUser(userModel usr);
    
    boolean setStatus(Long id,int status);
    
    boolean repair(userModel usr);
}

