/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anas
 */
public class ReceptionVo {

    private String reference;
    private String referenceCommande;
    private String dateReception;
    private String dateMin;
    private String dateMax;
    private String total;
    private List<ReceptionItemVo> receptionItems = new ArrayList<>();

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferenceCommande() {
        return referenceCommande;
    }

    public void setReferenceCommande(String referenceCommande) {
        this.referenceCommande = referenceCommande;
    }

   
    public String getDateReception() {
        return dateReception;
    }

    public void setDateReception(String dateReception) {
        this.dateReception = dateReception;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @JsonIgnore
    public List<ReceptionItemVo> getReceptionItems() {
        return receptionItems;
    }
    @JsonSetter
    public void setReceptionItems(List<ReceptionItemVo> receptionItems) {
        this.receptionItems = receptionItems;
    }

    public String getDateMin() {
        return dateMin;
    }

    public void setDateMin(String dateMin) {
        this.dateMin = dateMin;
    }

    public String getDateMax() {
        return dateMax;
    }

    public void setDateMax(String dateMax) {
        this.dateMax = dateMax;
    }

    
    @Override
    public String toString() {
        return "ReceptionVo{" + "reference=" + reference + ", referenceCommande=" + referenceCommande + ", dateReception=" + dateReception + ", total=" + total + ", receptionItems=" + receptionItems + '}';
    }


    
}
