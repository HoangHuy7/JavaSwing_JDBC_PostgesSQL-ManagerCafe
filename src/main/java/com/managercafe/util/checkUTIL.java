/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.util;

/**
 *
 * @author huy
 */
public class checkUTIL {

    public boolean checkAll(String[] parameters) {
        for (String parameter : parameters) {
            if ("".equals(parameter)) {
                return false;
            }
        }
        return true;
    }

    public String covertPrice(String price) {
        StringBuilder stringCovert = new StringBuilder("");
         
        int len = price.length();
        int index = 0;
        int value = len % 3;
        for (int i = 0; i < len; i++) {
            if (index == 3 || value == i && i != 0) {
                stringCovert.append(",");
                index = 0;
            }
            stringCovert.append(price.charAt(i));
            index++;
        }
        return stringCovert.toString();
    }

    public String covertPriceTable(String priceTable) {
        StringBuilder stringCovert = new StringBuilder("");
        int len = priceTable.length();
       
        for (int i = 0; i < len; i++) {
            if (priceTable.charAt(i) == ',') {
                continue;
            }
            stringCovert.append(priceTable.charAt(i));
        }
        return stringCovert.toString();
    }

    public String checkRole(String id) {
        String role = "non";
        switch (id) {
            case "1":
                role = "Admin";
                break;
            case "2":
                role = "Manager";
                break;
            case "3":
                role = "Staff";
                break;
        }
        return role;
    }

    public String checkStatus(int id) {
        String status = "non";
        if (id == 1) {
            status = "Work";
        } else if (id == 0) {
            status = "Leave";
        }
        return status;
    }
}
