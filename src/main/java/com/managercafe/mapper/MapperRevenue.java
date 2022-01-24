/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.mapper;

import com.managercafe.model.revenueModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huy
 */
public class MapperRevenue implements IRowMapper<revenueModel>{

    @Override
    public revenueModel mapRow(ResultSet rs) {
        revenueModel revenue = new revenueModel();
        try {
            revenue.setId(rs.getLong("idbill"));
            revenue.setUserId(rs.getLong("userid"));
            revenue.setFullname(rs.getString("fullname"));
            revenue.setTotal(rs.getLong("total"));
            revenue.setProductId(rs.getLong("productid"));
            revenue.setNameProduct(rs.getString("nameproduct"));
            revenue.setQuantity(rs.getInt("quantity"));
            revenue.setTotalProduct(rs.getLong("totalproduct"));
            revenue.setPrice(rs.getLong("price"));
            revenue.setSize(rs.getInt("size"));
            revenue.setType(rs.getString("type"));
            revenue.setCreateddate(rs.getTimestamp("createddate"));
            return revenue;
            
        } catch (SQLException ex) {
            return null;
        }
        
        
    }
    
}
