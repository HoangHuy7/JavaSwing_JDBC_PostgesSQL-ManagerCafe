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
public class typeProductModel {

    private String name;
    private Timestamp createddate;
    private Timestamp modifieddate;
    private String createdby;
    private String modifiedby;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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

}
