/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.service;

import com.managercafe.model.billModel;
import com.managercafe.model.productModel;
import java.util.List;

/**
 *
 * @author huy
 */
public interface IBillService {

    boolean insertBill(billModel bill, List<productModel> listProduct, Long total);

    Long total(List<productModel> listProduct);

    List<billModel> findAll();
}
