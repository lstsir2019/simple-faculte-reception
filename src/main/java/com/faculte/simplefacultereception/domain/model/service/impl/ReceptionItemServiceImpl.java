/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.model.service.impl;

import com.faculte.simplefacultereception.domain.bean.Reception;
import com.faculte.simplefacultereception.domain.bean.ReceptionItem;
import com.faculte.simplefacultereception.domain.model.dao.ReceptionItemDao;
import com.faculte.simplefacultereception.domain.model.service.ReceptionItemService;
import com.faculte.simplefacultereception.domain.rest.proxy.StockProxy;
import com.faculte.simplefacultereception.domain.rest.vo.exchange.MagasinVo;
import com.faculte.simplefacultereception.domain.rest.vo.exchange.StockVo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anas
 */
@Service
public class ReceptionItemServiceImpl implements ReceptionItemService {

    @Autowired
    private ReceptionItemDao receptionItemDao;
    @Autowired
    private StockProxy stockProxy;

    @Override
    public int saveReceptionItems(Reception reception, List<ReceptionItem> receptionItems) {
        if (reception == null) {
            return -1;
        } else if (receptionItems == null || receptionItems.isEmpty()) {
            return -2;
        } else {
            for (ReceptionItem receptionItem : receptionItems) {
                receptionItem.setReception(reception);
            }
            if (!valideStock(receptionItems)) {
                return -3;
            } else {
                receptionItemDao.saveAll(receptionItems);
                return 1;
            }
        }
    }

    //valide si Stock est enregistre sans problem 
    private Boolean valideStock(List<ReceptionItem> receptionItems) {
        List<StockVo> stockVos = receptionItemsToStocks(receptionItems);
        int res = 0;
        if (stockVos != null && !stockVos.isEmpty()) {
            System.out.println("Hello All Stocks has been Saved ");
            res = stockProxy.create(stockVos);
        }
        System.out.println("res from create"+res);
        return res == 1;
    }

    //Methode permet de transforme Objet ReceptionItem to Stock 
    private StockVo receptionItemToStock(ReceptionItem receptionItem) {
        if (receptionItem != null) {
            StockVo stockVo = new StockVo();
            stockVo.setReferenceProduit(receptionItem.getReferenceProduit());
            stockVo.setReferenceReception(receptionItem.getReception().getReference());
            stockVo.setQte(receptionItem.getQte());
            stockVo.setMagasinVo(new MagasinVo(receptionItem.getReferenceMagasin()));
            return stockVo;
        } else {
            return null;
        }
    }

    private List<StockVo> receptionItemsToStocks(List<ReceptionItem> receptionItems) {
        List<StockVo> stockVos = new ArrayList<>();
        if (receptionItems != null && !receptionItems.isEmpty()) {
            for (ReceptionItem receptionItem : receptionItems) {
                stockVos.add(receptionItemToStock(receptionItem));
            }
            return stockVos;
        }
        return null;
    }

    @Override
    public int saveReceptionItem(ReceptionItem receptionItem) {
        receptionItemDao.save(receptionItem);
        return 1;
    }

    @Override
    public List<ReceptionItem> findByReceptionReference(String reference) {
        return receptionItemDao.findByReceptionReference(reference);
    }

    public ReceptionItemDao getReceptionItemDao() {
        return receptionItemDao;
    }

    public void setReceptionItemDao(ReceptionItemDao receptionItemDao) {
        this.receptionItemDao = receptionItemDao;
    }

    public StockProxy getStockProxy() {
        return stockProxy;
    }

    public void setStockProxy(StockProxy stockProxy) {
        this.stockProxy = stockProxy;
    }

}
