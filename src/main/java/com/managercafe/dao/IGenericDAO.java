/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.dao;

import com.managercafe.mapper.IRowMapper;
import java.util.List;

/**
 *
 * @author huy
 * @param <T>
 */
public interface IGenericDAO<T> {
    <T> List<T> query(String sql,IRowMapper mapper,Object... parameters);
    boolean update(String sql,Object... parameters);
    Long getUpdate(String sql,Object... parameters);
}
