/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest.vo.exchange;

import java.util.List;

/**
 *
 * @author Anas
 */
public class CommandeItemVo {

    private String referenceProduit;
    private String qteReception;
    private String referenceCommande;
    private CommandeVo commandeVo;

    public String getReferenceProduit() {
        return referenceProduit;
    }

    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }

    public String getQteReception() {
        return qteReception;
    }

    public void setQteReception(String qteReception) {
        this.qteReception = qteReception;
    }

    public String getReferenceCommande() {
        return referenceCommande;
    }

    public void setReferenceCommande(String referenceCommande) {
        this.referenceCommande = referenceCommande;
    }

    public CommandeVo getCommandeVo() {
        return commandeVo;
    }

    public void setCommandeVo(CommandeVo commandeVo) {
        this.commandeVo = commandeVo;
    }


   
}
