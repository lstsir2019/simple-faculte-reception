/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.rest.vo;

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

    public List<ReceptionItemVo> getReceptionItems() {
        return receptionItems;
    }
    @JsonSetter
    public void setReceptionItems(List<ReceptionItemVo> receptionItems) {
        this.receptionItems = receptionItems;
    }

    
    @Override
    public String toString() {
        return "ReceptionVo{" + "reference=" + reference + ", referenceCommande=" + referenceCommande + ", dateReception=" + dateReception + ", total=" + total + ", receptionItems=" + receptionItems + '}';
    }


    
}
