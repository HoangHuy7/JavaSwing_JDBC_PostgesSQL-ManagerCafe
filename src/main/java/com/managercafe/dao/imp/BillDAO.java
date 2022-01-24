/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.dao.imp;

import com.managercafe.dao.IBillDAO;
import com.managercafe.mapper.MapperBill;
import com.managercafe.model.billModel;
import java.util.List;

/**
 *
 * @author huy
 */
public class BillDAO extends AbstractDAO<billModel> implements IBillDAO {

    @Override
    public Long insert(billModel info) {
        String sql = "INSERT into bill(userid,total,createdby,createddate) VALUES(?,?,?,?);";
        return getUpdate(sql, info.getUserId(), info.getTotal(), info.getCreatedby(), info.getCreateddate());
    }

    @Override
    public billModel findOne(Long id) {
        String sql = "Select* from bill where id = ?;";
        return (billModel) query(sql, new MapperBill(), id).get(0);

    }

    @Override
    public List<billModel> findAll() {
        String sql = "Select* from bill;";
        return query(sql, new MapperBill());
    }

}
