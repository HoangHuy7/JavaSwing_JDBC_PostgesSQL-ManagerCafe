/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.dao.imp;

import com.managercafe.dao.IRevenueDAO;
import com.managercafe.mapper.MapperRevenue;
import com.managercafe.model.revenueModel;
import java.util.List;

/**
 *
 * @author huy
 */
public class RevenueDAO extends AbstractDAO<revenueModel> implements IRevenueDAO{

    @Override
    public List<revenueModel> findAll(Long idBill) {
        StringBuilder sql = new StringBuilder("select  bill.id as idbill, bill.userid, users.fullname ,bill.total, detailbill.productid, ");
        sql.append("product.name as nameproduct,detailbill.quantity, detailbill.price as totalproduct, ");
        sql.append("product.price,product.size,product.type,bill.createddate ");
        sql.append("from bill inner join detailbill ON detailbill.idbill = bill.id ");
        sql.append("INNER join product ON product.id = detailbill.productid ");
        sql.append("INNER join users ON users.id = bill.userid ");
        sql.append("where bill.id = ?;");
        return query(sql.toString(), new MapperRevenue(), idBill);
    }
    
}
