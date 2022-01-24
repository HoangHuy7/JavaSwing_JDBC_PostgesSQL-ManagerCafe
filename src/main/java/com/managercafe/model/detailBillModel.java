/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.model;

import java.sql.Timestamp;

/**
 *
 * @author huy
 */
public class detailBillModel {

    private long idBill;
    private Long idProduct;
    private int quantity;
    private Long price;
    private Long discount;
    private Timestamp createddate;
    private Timestamp modifieddate;
    private String createdby;
    private String modifiedby;

    /**
     * @return the idBill
     */
    public long getIdBill() {
        return idBill;
    }

    /**
     * @param idBill the idBill to set
     */
    public void setIdBill(long idBill) {
        this.idBill = idBill;
    }

    /**
     * @return the idProduct
     */
    public Long getIdProduct() {
        return idProduct;
    }

    /**
     * @param idProduct the idProduct to set
     */
    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    

    /**
     * @return the discount
     */
    public Long getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    /**
     * @return the createddate
     */
    public Timestamp getCreateddate() {
        return createddate;
    }

    /**
     * @param createddate the createddate to set
     */
    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    /**
     * @return the modifieddate
     */
    public Timestamp getModifieddate() {
        return modifieddate;
    }

    /**
     * @param modifieddate the modifieddate to set
     */
    public void setModifieddate(Timestamp modifieddate) {
        this.modifieddate = modifieddate;
    }

    /**
     * @return the createdby
     */
    public String getCreatedby() {
        return createdby;
    }

    /**
     * @param createdby the createdby to set
     */
    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    /**
     * @return the modifiedby
     */
    public String getModifiedby() {
        return modifiedby;
    }

    /**
     * @param modifiedby the modifiedby to set
     */
    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    public void setDiscount(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
