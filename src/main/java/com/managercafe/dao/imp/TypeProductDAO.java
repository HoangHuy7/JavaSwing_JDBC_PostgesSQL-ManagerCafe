/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.dao.imp;

import com.managercafe.dao.ITypeProductDAO;
import com.managercafe.mapper.MapperTypeProduct;
import com.managercafe.model.typeProductModel;
import java.util.List;

/**
 *
 * @author huy
 */
public class TypeProductDAO extends AbstractDAO<typeProductModel> implements ITypeProductDAO{

    @Override
    public List<typeProductModel> findAll() {
        String sql = "select * from typeproduct";
        return query(sql, new MapperTypeProduct());
    }

    @Override
    public boolean insert(typeProductModel type) {
        String sql = "insert into typeproduct (name,createddate,createdby) values(?, ?, ?)";
        return update(sql, type.getName(),type.getCreateddate(),type.getCreatedby());
    }
    
}
