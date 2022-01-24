/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.service.imp;

import com.managercafe.dao.IBillDAO;
import com.managercafe.dao.IDetailBillDAO;
import com.managercafe.dao.imp.BillDAO;
import com.managercafe.dao.imp.DetailBillDao;
import com.managercafe.model.billModel;
import com.managercafe.model.detailBillModel;
import com.managercafe.model.productModel;
import com.managercafe.model.userModel;
import com.managercafe.service.IBillService;
import com.managercafe.view.frmLogin;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author huy
 */
public class BillService implements IBillService {

    private final IBillDAO billDao = new BillDAO();
    private final IDetailBillDAO detailDAO = new DetailBillDao();
    private final userModel userAccess = frmLogin.userAccess;
    
    
    
    @Override
    public boolean insertBill(billModel bill, List<productModel> listProduct,Long total) {
        bill.setUserId(userAccess.getId());
        bill.setTotal(total);
        bill.setCreatedby(String.valueOf(userAccess.getId()));
        bill.setCreateddate(new Timestamp(System.currentTimeMillis()));
        Long id = billDao.insert(bill);
        if (id == null) {
            return false;
        } else {
            for (productModel model : listProduct) {
                detailBillModel detail = new detailBillModel();
                detail.setIdBill(id);
                detail.setIdProduct(model.getId());
                detail.setQuantity(model.getQuantity());
                detail.setPrice(model.getPrice() * model.getQuantity());
                detail.setCreatedby(String.valueOf(userAccess.getId()));
                detail.setCreateddate(new Timestamp(System.currentTimeMillis()));
                if (!detailDAO.insert(detail) ) {
                    return false;
                }
            }

            return true;
        }

    }

    @Override
    public Long total(List<productModel> listProduct) {
        Long total = 0L;
        for (productModel model : listProduct) {
            total += model.getPrice() * model.getQuantity();
        }
        return total;
    }

    @Override
    public List<billModel> findAll() {
        return billDao.findAll();
    }

}
