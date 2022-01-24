/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.dao;

import com.managercafe.model.typeProductModel;
import java.util.List;

/**
 *
 * @author huy
 */
public interface ITypeProductDAO extends IGenericDAO<typeProductModel>{
    List<typeProductModel> findAll();
    
    boolean insert(typeProductModel type);
}
