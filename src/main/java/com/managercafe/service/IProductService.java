/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.service;

import com.managercafe.model.productModel;
import java.util.List;

/**
 *
 * @author huy
 */
public interface IProductService {

    List<productModel> findAll();

    List<productModel> findOneById(Long id);

    productModel findOneByNameAndSize(String name,int size);

    boolean insert(productModel product);

    boolean delete(Long id);

    boolean update(productModel product);
}
