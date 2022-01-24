/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.dao;

import com.managercafe.model.detailBillModel;

/**
 *
 * @author huy
 */
public interface IDetailBillDAO extends IGenericDAO<detailBillModel>{
    boolean insert(detailBillModel detail);
}
