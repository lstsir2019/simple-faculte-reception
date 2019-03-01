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
            receptionItemDao.saveAll(receptionItems);
            return 1;
        }
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

}
