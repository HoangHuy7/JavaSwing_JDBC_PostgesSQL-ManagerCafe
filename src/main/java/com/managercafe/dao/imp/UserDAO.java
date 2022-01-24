/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.dao.imp;

import com.managercafe.dao.IUserDAO;
import com.managercafe.mapper.MapperUser;
import com.managercafe.model.userModel;
import java.util.List;

/**
 *
 * @author huy
 */
public class UserDAO extends AbstractDAO<userModel> implements IUserDAO {

    @Override
    public List<userModel> FindAll() {
        String sql = "Select * From users ORDER by users.id asc ";
        return query(sql, new MapperUser());
    }

    @Override
    public List<userModel> findStatusOn() {
        String sql = "Select * From users where users.status = 1 ORDER by users.id asc ";
        return query(sql, new MapperUser());
    }

    @Override
    public List<userModel> findStatusOff() {
        String sql = "Select * From users where users.status = 0 ORDER by users.id asc ";
        return query(sql, new MapperUser());
    }

    @Override
    public List<userModel> findOneById(Long id) {
        String sql = "Select * From users where users.id = ?";
        return query(sql, new MapperUser(), id);
    }

    @Override
    public boolean insertUser(userModel usr) {
        String sql = "Insert into users(username,password,fullname,roleid,status,createddate,createdby) values(?,?,?,?,?,?,?);";
        return update(sql, usr.getUserName(), usr.getPassword(), usr.getFullname(), usr.getRoleid(), usr.getStatus(), usr.getCreateddate(), usr.getCreatedby());
    }

    @Override
    public boolean setStatus(Long id, int status) {
        String sql = "update users set status = ? where users.id = ? and users.id != 'Admin';";
        return update(sql, status,id);
    }

    @Override
    public boolean repair(userModel usr) {
        StringBuilder sql = new StringBuilder( "update users set password = ?, fullname = ?, roleid = ?, status = ?, ");
        sql.append("createddate = ?, createdby = ?,modifieddate = ? , modifiedby = ? where id = ?;");
        return update(sql.toString() , usr.getPassword(), usr.getFullname(), usr.getRoleid(), usr.getStatus(),
                usr.getCreateddate(), usr.getCreatedby(),usr.getModifieddate(),usr.getModifiedby(),usr.getId());
    }

    @Override
    public List<userModel> checkLogin(String userName,String password) {
        String sql = "Select * From users where users.username = ? and users.password = ? ";
        return query(sql, new MapperUser(), userName,password);
    }


}
