/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.mapper;

import com.managercafe.model.typeProductModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author huy
 */
public class MapperTypeProduct implements IRowMapper<typeProductModel> {

    @Override
    public typeProductModel mapRow(ResultSet rs) {
        try {
            typeProductModel type = new typeProductModel();
            type.setName(rs.getString("name"));
            type.setCreatedby(rs.getString("createdby"));
            type.setCreateddate(rs.getTimestamp("createddate"));
            
            Timestamp modifiedDate = rs.getTimestamp("modifieddate");
            if (modifiedDate != null) {
                type.setModifieddate(modifiedDate);
            }
            String modifiedBy = rs.getString("modifiedby");
            if (modifiedBy != null) {
                type.setModifiedby(modifiedBy);
            }
            return type;
        } catch (SQLException ex) {
           return null;
        }
    }

}
