/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.service.impl;

import com.faculte.simplefacultereception.bean.Reception;
import com.faculte.simplefacultereception.bean.ReceptionItem;
import com.faculte.simplefacultereception.dao.ReceptionItemDao;
import com.faculte.simplefacultereception.service.ReceptionItemService;
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
    public int createReceptionItems(Reception reception, List<ReceptionItem> receptionItems) {
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
    public int createReceptionItem(ReceptionItem receptionItem) {
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
