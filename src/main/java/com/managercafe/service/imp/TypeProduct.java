/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.service.imp;

import com.managercafe.dao.ITypeProductDAO;
import com.managercafe.dao.imp.TypeProductDAO;
import com.managercafe.model.typeProductModel;
import com.managercafe.service.ITypeProductService;
import com.managercafe.view.frmLogin;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author huy
 */
public class TypeProduct implements ITypeProductService{

    private final ITypeProductDAO typeDao = new TypeProductDAO();
    private final Long userAccess = frmLogin.userAccess.getId();
    @Override
    public List<typeProductModel> findAll() {
        return typeDao.findAll();
    }

    @Override
    public boolean insert(typeProductModel type) {
        for (typeProductModel productModel : typeDao.findAll()) {
            if (productModel.getName().equals(type.getName())) {
                return false;
            }
        }
        type.setCreatedby(String.valueOf(userAccess));
        type.setCreateddate(new Timestamp(System.currentTimeMillis()));
        return typeDao.insert(type);
    }
    
}
