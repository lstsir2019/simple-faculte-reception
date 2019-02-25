/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest.vo;

/**
 *
 * @author Anas
 */
public class ReceptionItemVo {

    private String referenceCategorie;
    private String referenceProduit;
    private String referenceMagasin;
    private String qte;
    private ReceptionVo receptionVo; 

    public String getReferenceCategorie() {
        return referenceCategorie;
    }

    public void setReferenceCategorie(String referenceCategorie) {
        this.referenceCategorie = referenceCategorie;
    }

    public String getReferenceProduit() {
        return referenceProduit;
    }

    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }

    public String getReferenceMagasin() {
        return referenceMagasin;
    }

    public void setReferenceMagasin(String referenceMagasin) {
        this.referenceMagasin = referenceMagasin;
    }

    public String getQte() {
        return qte;
    }

    public void setQte(String qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "ReceptionItemVo{" + "referenceCategorie=" + referenceCategorie + ", referenceProduit=" + referenceProduit + ", referenceMagasin=" + referenceMagasin + ", qte=" + qte + '}';
    }

}
