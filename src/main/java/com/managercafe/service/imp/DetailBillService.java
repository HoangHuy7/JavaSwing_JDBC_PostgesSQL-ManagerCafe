/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.service.imp;

import com.managercafe.dao.IDetailBillDAO;
import com.managercafe.dao.imp.DetailBillDao;
import com.managercafe.model.detailBillModel;
import com.managercafe.service.IDetailBillService;

/**
 *
 * @author huy
 */
public class DetailBillService implements IDetailBillService{

    private final IDetailBillDAO detailDao = new DetailBillDao();

    @Override
    public boolean insert(detailBillModel detail) {
        return detailDao.insert(detail);
    }
    
    
    
}
