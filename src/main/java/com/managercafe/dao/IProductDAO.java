/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.dao;

import com.managercafe.model.productModel;
import java.util.List;

/**
 *
 * @author huy
 */
public interface IProductDAO extends IGenericDAO<productModel> {

    List<productModel> FindAll();

    List<productModel> findOneById(Long id);

    productModel findOneByNameAndSize(String name, int size);

    boolean insert(productModel product);

    boolean update(productModel product);

    boolean delete(Long id);
}
