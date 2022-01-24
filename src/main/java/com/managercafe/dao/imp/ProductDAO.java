/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.dao.imp;

import com.managercafe.dao.IProductDAO;
import com.managercafe.mapper.MapperProduct;
import com.managercafe.model.productModel;
import java.util.List;

/**
 *
 * @author huy
 */
public class ProductDAO extends AbstractDAO<productModel> implements IProductDAO {

    @Override
    public List<productModel> FindAll() {
        String sql = "select* from product";
        return query(sql, new MapperProduct());
    }

    @Override
    public List<productModel> findOneById(Long id) {
        String sql = "select* from product where id = ?";
        return query(sql, new MapperProduct(), id);
    }

    @Override
    public boolean insert(productModel product) {
        String sql = "Insert into product(name,price,size,type,createddate,createdby) values(?,?,?,?,?,?);";
        return update(sql, product.getName(), product.getPrice(), product.getSize(), product.getType(), product.getCreateddate(), product.getCreatedby());
    }

    @Override
    public productModel findOneByNameAndSize(String name, int size) {
        String sql = "select* from product where product.name = ? and product.size = ?";
        return (productModel) (query(sql, new MapperProduct(), name, size)).get(0);
    }

    @Override
    public boolean delete(Long id) {
        String sql = "delete from product where product.id = ? ";
        return update(sql, id);
    }

    @Override
    public boolean update(productModel product) {
        StringBuilder sql = new StringBuilder("UPDATE product SET name = ?, price = ?, size = ?, type = ?,  ");
        sql.append("createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? where id = ?;");
        return update(sql.toString(), product.getName(), product.getPrice(), product.getSize(), product.getType(),
                 product.getCreateddate(), product.getCreatedby(), product.getModifieddate(), product.getModifiedby(),product.getId());
    }

}
