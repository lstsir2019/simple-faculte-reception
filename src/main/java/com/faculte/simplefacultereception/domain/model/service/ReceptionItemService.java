/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.model.service;

import com.faculte.simplefacultereception.domain.bean.Reception;
import com.faculte.simplefacultereception.domain.bean.ReceptionItem;
import java.util.List;

/**
 *
 * @author Anas
 */
public interface ReceptionItemService {

    public int saveReceptionItem(ReceptionItem receptionItem);

    public List<ReceptionItem> findByReceptionReference(String reference);

    public int saveReceptionItems(Reception reception, List<ReceptionItem> receptionItems);

}
