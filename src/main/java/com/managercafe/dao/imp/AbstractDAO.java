/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.dao.imp;

import com.managercafe.dao.IGenericDAO;
import com.managercafe.mapper.IRowMapper;
import com.managercafe.util.connectDatabaseUTIL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huy
 * @param <T>
 */
public class AbstractDAO<T> implements IGenericDAO<T> {

    connectDatabaseUTIL connect = new connectDatabaseUTIL();

    @Override
    public <T> List<T> query(String sql, IRowMapper mapper, Object... parameters) {
        Connection cnt = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<T> list;
        try {
            cnt = connect.getConnectDatabase();
            pstm = cnt.prepareStatement(sql);
            setparameters(pstm,parameters);
            rs = pstm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {

                list.add((T) mapper.mapRow(rs));
            }
            return list;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;

        } finally {
            try {
                if (cnt != null) {
                    cnt.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }

        }
    }

    private void setparameters(PreparedStatement pstm, Object... parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            int index = i +1;
            Object parameter = parameters[i];
            if (parameter instanceof  Long) {
                pstm.setLong(index, (long) parameter);
            }else  if (parameter instanceof  String) {
                pstm.setString(index, (String) parameter);
            } else  if (parameter instanceof  Integer) {
                pstm.setInt(index, (Integer) parameter);
            } else  if (parameter instanceof  Timestamp) {
                pstm.setTimestamp(index, (Timestamp) parameter);
            }
        }
    }

    @Override
    public boolean update(String sql, Object... parameters) {
        Connection cnt = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        try {
            cnt = connect.getConnectDatabase();
            cnt.setAutoCommit(false);
            pstm = cnt.prepareStatement(sql);
            setparameters(pstm,parameters);
            pstm.executeUpdate();
            cnt.commit();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                cnt.rollback();
                return false;
            } catch (SQLException ex1) {
                System.out.println(ex1.toString());
            }

        } finally {
            try {
                if (cnt != null) {
                    cnt.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }

        }
        return false;
    }

    @Override
    public Long getUpdate(String sql, Object... parameters) {
        Connection cnt = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        try {
            Long id = null;
            cnt = connect.getConnectDatabase();
            cnt.setAutoCommit(false);
            pstm = cnt.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            setparameters(pstm,parameters);
            pstm.executeUpdate();
            rs = pstm.getGeneratedKeys();
            while (rs.next()) {                
                id = rs.getLong(1);
            }
            cnt.commit();
            return id;
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                cnt.rollback();
                return null;
            } catch (SQLException ex1) {
                System.out.println(ex1.toString());
            }

        } finally {
            try {
                if (cnt != null) {
                    cnt.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }

        }
        return null;
    }

}
