/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest.vo.exchange;

/**
 *
 * @author Anas
 */
public class StockVo {

    private String reference;
    private String referenceReception;
    private String referenceProduit;
    private String referenceCommande;
    private int qte;
    private int qteDeffectueuse;
    private int seuilAlert;
    private MagasinVo magasinVo;

    public StockVo() {
    }

    public StockVo(String reference, String referenceReception, String referenceProduit, int qte, int qteDeffectueuse, int seuilAlert, MagasinVo magasinVo) {
        this.reference = reference;
        this.referenceReception = referenceReception;
        this.referenceProduit = referenceProduit;
        this.qte = qte;
        this.qteDeffectueuse = qteDeffectueuse;
        this.seuilAlert = seuilAlert;
        this.magasinVo = magasinVo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferenceReception() {
        return referenceReception;
    }

    public void setReferenceReception(String referenceReception) {
        this.referenceReception = referenceReception;
    }

    public String getReferenceCommande() {
        return referenceCommande;
    }

    public void setReferenceCommande(String referenceCommande) {
        this.referenceCommande = referenceCommande;
    }

    public String getReferenceProduit() {
        return referenceProduit;
    }

    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getQteDeffectueuse() {
        return qteDeffectueuse;
    }

    public void setQteDeffectueuse(int qteDeffectueuse) {
        this.qteDeffectueuse = qteDeffectueuse;
    }

    public int getSeuilAlert() {
        return seuilAlert;
    }

    public void setSeuilAlert(int seuilAlert) {
        this.seuilAlert = seuilAlert;
    }

    public MagasinVo getMagasinVo() {
        return magasinVo;
    }

    public void setMagasinVo(MagasinVo magasinVo) {
        this.magasinVo = magasinVo;
    }

    @Override
    public String toString() {
        return "StockVo{" + "reference=" + reference + ", referenceReception=" + referenceReception + ", referenceProduit=" + referenceProduit + ", referenceCommande=" + referenceCommande + ", qte=" + qte + ", qteDeffectueuse=" + qteDeffectueuse + ", seuilAlert=" + seuilAlert + ", magasinVo=" + magasinVo + '}';
    }

  

}
