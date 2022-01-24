/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.mapper;

import com.managercafe.model.billModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author huy
 */
public class MapperBillModel implements IRowMapper<billModel>{

    @Override
    public billModel mapRow(ResultSet rs) {
        billModel bill = new billModel();
        try {
            bill.setId(rs.getLong("id"));
            bill.setUserId(rs.getLong("userid"));
            bill.setCreatedby(rs.getString("createdby"));
            bill.setCreateddate(rs.getTimestamp("createddate"));
            return bill;
        } catch (SQLException ex) {
            System.out.println("Loi");
        }
        return null;

    }
    
}
