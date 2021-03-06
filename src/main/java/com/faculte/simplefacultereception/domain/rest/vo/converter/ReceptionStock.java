/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest.vo.converter;

import com.faculte.simplefacultereception.commun.util.DateUtil;
import com.faculte.simplefacultereception.domain.bean.ReceptionItem;
import com.faculte.simplefacultereception.domain.rest.proxy.StockProxy;
import com.faculte.simplefacultereception.domain.rest.vo.exchange.MagasinVo;
import com.faculte.simplefacultereception.domain.rest.vo.exchange.StockVo;
import java.util.ArrayList;
import java.util.Date;
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
        for (ReceptionItem receptionItem : receptionItems) {
            StockVo stockVo = receptionItemToStock(receptionItem);
            int re = stockProxy.save(stockVo);
            if (re < 1) {
                return false;
            }
            res += re;
        }
        return res == receptionItems.size();        
    }

    private StockVo receptionItemToStock(ReceptionItem receptionItem) {
        //Methode permet de transforme ReceptionItem to Stock 
        if (receptionItem != null) {
            StockVo stockVo = new StockVo();
            stockVo.setReferenceProduit(receptionItem.getReferenceProduit());
            stockVo.setReferenceReception(receptionItem.getReception().getReference());
            stockVo.setReferenceCommande(receptionItem.getReception().getReferenceCommande());
            stockVo.setQte(receptionItem.getQte()+"");
            stockVo.setDateReception(DateUtil.formateDate(receptionItem.getReception().getDateReception()));
            stockVo.setMagasinVo(new MagasinVo(receptionItem.getReferenceMagasin()));
            return stockVo;
        } else {
            return new StockVo();
        }
    }

    
    public StockProxy getStockProxy() {
        return stockProxy;
    }

    public void setStockProxy(StockProxy stockProxy) {
        this.stockProxy = stockProxy;
    }

}
