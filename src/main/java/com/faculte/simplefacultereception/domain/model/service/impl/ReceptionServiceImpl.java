/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.model.service.impl;

import com.faculte.simplefacultereception.domain.bean.Reception;
import com.faculte.simplefacultereception.domain.model.dao.ReceptionDao;
import com.faculte.simplefacultereception.domain.model.dao.ReceptionSearch;
import com.faculte.simplefacultereception.domain.model.service.ReceptionItemService;
import com.faculte.simplefacultereception.domain.model.service.ReceptionService;
import com.faculte.simplefacultereception.domain.rest.proxy.StockProxy;
import com.faculte.simplefacultereception.domain.rest.vo.converter.ReceptionStock;
import java.time.Year;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anas
 */
@Service
public class ReceptionServiceImpl implements ReceptionService {

    @Autowired
    private ReceptionDao receptionDao;
    @Autowired
    private ReceptionSearch receptionSearch;
    @Autowired
    private ReceptionItemService receptionItemService;
    @Autowired
    private ReceptionStock receptionStock;
    @Autowired
    private StockProxy stockProxy;

    @Override
    public int createReception(Reception reception) {
        /*  1) On sauvegarder Reception BD
        *   2) On sauvegarder Les ReceptionItems
        *   3) on sauvegarder Stock v  (receptionItem==Stock)    
        *   Si methode return res < 0 Alors reception ne peut pas etre sauvegardé
         */
        int res = saveReception(reception);
        if (res < 0) {
            return res;
        }
        //  Methode qui permet de enregistre les ReceptionItems
        int i = receptionItemService.saveReceptionItems(reception, reception.getReceptionItems());
        if (i < 0) {
            receptionDao.delete(reception);
            return -5;
        }
        // On sauvegarde  Stock ReceptionItem == Stock
        Boolean resStock = receptionStock.saveStock(reception.getReceptionItems());
        if (!resStock) {
            receptionDao.delete(reception);
            stockProxy.deleteByReferenceCommandeAndReception(reception.getReferenceCommande(), reception.getReference());
            return -6;
        }
        // lets increment 
        receptionItemService.incrementQteReception(reception.getReceptionItems());
        return 1;
    }

    private int saveReception(Reception reception) {
        //cette méthode permet de sauvegarder reception seul dans la base de donnes
        if (reception == null) {
            return -1;
        } else {
            Reception rec = findByReference(reception.getReference());
            if (rec != null || reception.getReference() == null || reception.getReference().isEmpty()) {
                return -2;
            } else if (reception.getReceptionItems().isEmpty()) {
                return -3;
            } else if (reception.getDateReception() == null) {
                return -4;
            } else {
                //sauvegarde Reception seul !!!
                receptionDao.save(reception);
                return 1;
            }
        }
    }

    @Override
    public List<Reception> findStocksByCommandeAndStrategy(String refreception, String strategy) {
        if (strategy.equalsIgnoreCase("FIFO")) {
            return receptionDao.findByReferenceCommandeOrderByDateReceptionAsc(refreception);
        } else if (strategy.equalsIgnoreCase("LIFO")) {
            return receptionDao.findByReferenceCommandeOrderByDateReceptionDesc(refreception);
        } else {
            return receptionDao.findByReferenceCommande(refreception);
        }
    }

    @Override
    public String generateReceptionReference() {
        long i = receptionDao.count() + 1;
        int year = Year.now().getValue();
        String reference = "rec-" + year + "-" + i;
        return reference;
    }

    @Override
    public List<Reception> findByCriteria(String reference, String commande, Date dateMin, Date dateMax) {
        return receptionSearch.findByCriteria(reference, commande, dateMin, dateMax);
    }

    @Override
    public int removeByReference(String reference) {
        Reception reception = findByReference(reference);
        if (reception != null) {
            receptionDao.delete(reception);
            stockProxy.deleteByReferenceCommandeAndReception(reception.getReferenceCommande(), reception.getReference());
            receptionItemService.decrementQteReception(reception.getReceptionItems());
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public List<Reception> findAll() {
        return receptionDao.findAll(new Sort(Sort.Direction.DESC, "dateReception"));
    }

    @Override
    public List<Reception> findByCommandeReference(String reference) {
        return receptionDao.findByReferenceCommande(reference);
    }

    @Override
    public Reception findByReference(String reference) {
        return receptionDao.findByReference(reference);
    }

    public ReceptionDao getReceptionDao() {
        return receptionDao;
    }

    public void setReceptionDao(ReceptionDao receptionDao) {
        this.receptionDao = receptionDao;
    }

    public ReceptionItemService getReceptionItemService() {
        return receptionItemService;
    }

    public void setReceptionItemService(ReceptionItemService receptionItemService) {
        this.receptionItemService = receptionItemService;
    }

    public ReceptionStock getReceptionStock() {
        return receptionStock;
    }

    public void setReceptionStock(ReceptionStock receptionStock) {
        this.receptionStock = receptionStock;
    }

}
