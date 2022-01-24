/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.dao.imp;

import com.managercafe.dao.IDetailBillDAO;
import com.managercafe.model.detailBillModel;

/**
 *
 * @author huy
 */
public class DetailBillDao extends AbstractDAO<detailBillModel> implements IDetailBillDAO{

    @Override
    public boolean insert(detailBillModel detail) {
        String sql = "insert into detailbill(idbill,productid,quantity,price,createddate,createdby) VALUES(?,?,?,?,?,?);";
        return update(sql,detail.getIdBill(),detail.getIdProduct(),detail.getQuantity(),detail.getPrice(),detail.getCreateddate(),detail.getCreatedby());
    }
    
}
