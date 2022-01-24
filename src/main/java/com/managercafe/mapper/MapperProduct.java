/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.mapper;

import com.managercafe.model.productModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author huy
 */
public class MapperProduct implements IRowMapper<productModel>{

    @Override
    public productModel mapRow(ResultSet rs) {
        
        try {
            productModel product = new productModel();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getLong("price"));
            product.setSize(rs.getInt("size"));
            product.setType(rs.getString("type"));
            product.setCreatedby(rs.getString("createdby"));
            product.setCreateddate(rs.getTimestamp("createddate"));
            
            Timestamp modifiedDate = rs.getTimestamp("modifieddate");
            if (modifiedDate != null ) {
                product.setModifieddate(modifiedDate);
            }
            String modifiedBy = rs.getString("modifiedby");
            if (modifiedBy != null ) {
                product.setModifiedby(modifiedBy);
            }
            return product;
        } catch (SQLException ex) {
          return null;
        }
    }
    
}
