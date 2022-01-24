/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.mapper;

import com.managercafe.model.userModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author huy
 */
public class MapperUser implements IRowMapper<userModel>{

    @Override
    public userModel mapRow(ResultSet rs) {
        userModel usr = new userModel();
        try {
            usr.setId(rs.getLong("id"));
            usr.setUserName(rs.getString("username"));
            usr.setPassword(rs.getString("password"));
            usr.setFullname(rs.getString("fullname"));
            usr.setRoleid(rs.getLong("roleid"));
            usr.setStatus(rs.getInt("status"));
            Timestamp createdDate =rs.getTimestamp("createddate"); 
            if (createdDate != null) {
                usr.setCreateddate(createdDate);
            }
            String createdBy = rs.getString("createdby");
            if (createdBy != null) {
                usr.setCreatedby(createdBy);
            }
            
            Timestamp modifiedDate = rs.getTimestamp("modifieddate");
            if (modifiedDate != null ) {
                usr.setModifieddate(modifiedDate);
            }
            String modifiedBy = rs.getString("modifiedby");
            if (modifiedBy != null ) {
                usr.setModifiedby(modifiedBy);
            }
            return usr;
        } catch (SQLException ex) {
           return null;
        } 
    }
    
}
