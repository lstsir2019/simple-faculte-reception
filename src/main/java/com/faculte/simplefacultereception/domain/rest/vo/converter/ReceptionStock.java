/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest.vo.converter;

import com.faculte.simplefacultereception.domain.bean.ReceptionItem;
import com.faculte.simplefacultereception.domain.rest.proxy.StockProxy;
import com.faculte.simplefacultereception.domain.rest.vo.exchange.MagasinVo;
import com.faculte.simplefacultereception.domain.rest.vo.exchange.StockVo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anas
 */
@Component
public class ReceptionStock {

    @Autowired
    private StockProxy stockProxy;

    public Boolean saveStock(List<ReceptionItem> receptionItems) {
        int res = 0;
        List<StockVo> stockVos = receptionItemsToStocks(receptionItems);
        if (stockVos != null && !stockVos.isEmpty()) {
            res = stockProxy.create(stockVos);
        }
        return res == 1;
    }

    private StockVo receptionItemToStock(ReceptionItem receptionItem) {
        //Methode permet de transforme ReceptionItem to Stock 
        if (receptionItem != null) {
            StockVo stockVo = new StockVo();
            stockVo.setReferenceProduit(receptionItem.getReferenceProduit());
            stockVo.setReferenceReception(receptionItem.getReception().getReference());
            stockVo.setReferenceCommande(receptionItem.getReception().getReferenceCommande());
            stockVo.setQte(receptionItem.getQte());
            stockVo.setMagasinVo(new MagasinVo(receptionItem.getReferenceMagasin()));
            return stockVo;
        } else {
            return new StockVo();
        }
    }

    private List<StockVo> receptionItemsToStocks(List<ReceptionItem> receptionItems) {
        List<StockVo> stockVos = new ArrayList<>();
        if (receptionItems != null && !receptionItems.isEmpty()) {
            receptionItems.forEach(receptionItem -> stockVos.add(receptionItemToStock(receptionItem)));
            return stockVos;
        }
        return new ArrayList<>();
    }

    public StockProxy getStockProxy() {
        return stockProxy;
    }

    public void setStockProxy(StockProxy stockProxy) {
        this.stockProxy = stockProxy;
    }

}
