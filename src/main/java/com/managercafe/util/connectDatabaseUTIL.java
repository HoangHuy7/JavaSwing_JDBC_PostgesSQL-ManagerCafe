/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author huy
 */
public class connectDatabaseUTIL {

    String url = "jdbc:postgresql://localhost/ManagerCafe3";
    String username = "postgres";
    String password = "root";
    public connectDatabaseUTIL()
    {
        
    }
    public Connection getConnectDatabase() throws ClassNotFoundException {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, username, password);
            System.out.println(10 % 3);
            return con;
        } catch (ClassNotFoundException | SQLException ex1) {
            System.out.println("ngu");
            return con;
        }
        
    }
    
}