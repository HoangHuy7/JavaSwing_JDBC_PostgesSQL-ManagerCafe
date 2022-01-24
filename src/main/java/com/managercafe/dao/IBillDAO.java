/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.dao;

import com.managercafe.model.billModel;
import java.util.List;

/**
 *
 * @author huy
 */
public interface IBillDAO extends IGenericDAO<billModel>{
    
    Long insert(billModel info);
    billModel findOne(Long id);
    List<billModel> findAll();
}
