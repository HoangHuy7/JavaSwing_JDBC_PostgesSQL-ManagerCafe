/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.service.imp;

import com.managercafe.dao.IProductDAO;
import com.managercafe.dao.imp.ProductDAO;
import com.managercafe.model.productModel;
import com.managercafe.model.userModel;
import com.managercafe.service.IProductService;
import com.managercafe.view.frmLogin;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author huy
 */
public class ProductService implements IProductService{

    private final IProductDAO productDao = new ProductDAO();
    private final userModel userAccess = frmLogin.userAccess;
    
    private boolean checkProduct(productModel product){
        List<productModel> allProduct = productDao.FindAll();
        for (productModel model : allProduct) {
            if (model.getName().equals(product.getName()) && model.getSize() == product.getSize() && model.getType().equals(product.getType())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public List<productModel> findAll() {
        return productDao.FindAll();
    }

    @Override
    public List<productModel> findOneById(Long id) {
        return productDao.findOneById(id);
    }

    @Override
    public boolean insert(productModel product) {
        if (checkProduct(product)) {
            return false;
        }
        product.setCreatedby(String.valueOf(userAccess.getId()));
        product.setCreateddate(new Timestamp(System.currentTimeMillis()));
        return productDao.insert(product);
    }

    @Override
    public boolean delete(Long id) {
        return productDao.delete(id);
    }

    @Override
    public boolean update(productModel product) {
        if (checkProduct(product)) {
            return false;
        }
        productModel productOld = productDao.findOneById(product.getId()).get(0);
        product.setCreatedby(productOld.getCreatedby());
        product.setCreateddate(productOld.getCreateddate());
        product.setModifiedby(String.valueOf( userAccess.getId()));
        product.setModifieddate(new Timestamp(System.currentTimeMillis()));
        return productDao.update(product);
    }

    @Override
    public productModel findOneByNameAndSize(String name, int size) {
        return productDao.findOneByNameAndSize(name, size);
    }
    
}
