/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.model.service.impl;

import com.faculte.simplefacultereception.domain.bean.Reception;
import com.faculte.simplefacultereception.domain.model.dao.ReceptionDao;
import com.faculte.simplefacultereception.domain.model.service.ReceptionItemService;
import com.faculte.simplefacultereception.domain.model.service.ReceptionService;
import com.faculte.simplefacultereception.domain.rest.proxy.MagasinProxy;
import com.faculte.simplefacultereception.domain.rest.proxy.StockProxy;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ReceptionItemService receptionItemService;
    @Autowired
    private StockProxy stockProxy;
    @Autowired
    private MagasinProxy magasinProxy;

    @Override
    public int createReception(Reception reception) {
        if (reception == null) {
            return -1;
        } else {
            Reception rec = findByReference(reception.getReference());
            if (rec != null) {
                return -2;
            } else if (reception.getReceptionItems().isEmpty()) {
                return -3;
            } else if (reception.getDateReception() == null) {
                return -4;
            } else {
                receptionDao.save(reception);
                int i = receptionItemService.saveReceptionItems(reception, reception.getReceptionItems());
                if (i < 0) {
                    return -5;
                } else {
                    return 1;
                }
            }
        }
    }

    @Override
    public List<Reception> findAll() {
        return receptionDao.findAll();
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

    public StockProxy getStockProxy() {
        return stockProxy;
    }

    public void setStockProxy(StockProxy stockProxy) {
        this.stockProxy = stockProxy;
    }

}
