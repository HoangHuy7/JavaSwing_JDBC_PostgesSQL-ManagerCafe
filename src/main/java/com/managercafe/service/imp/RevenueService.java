/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.service.imp;

import com.managercafe.dao.IRevenueDAO;
import com.managercafe.dao.imp.RevenueDAO;
import com.managercafe.model.revenueModel;
import com.managercafe.service.IRevenueService;
import java.util.List;

/**
 *
 * @author huy
 */
public class RevenueService implements  IRevenueService{

    private final IRevenueDAO revenueDao = new RevenueDAO();
    
    @Override
    public List<revenueModel> findAll(Long idBill) {
        return revenueDao.findAll(idBill);
    }
    
}
