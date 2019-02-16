/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.service;

import com.faculte.simplefacultereception.bean.Reception;
import com.faculte.simplefacultereception.bean.ReceptionItem;
import java.util.List;

/**
 *
 * @author Anas
 */
public interface ReceptionItemService {

    public int createReceptionItem(ReceptionItem receptionItem);

    public List<ReceptionItem> findByReceptionReference(String reference);

    public int createReceptionItems(Reception reception, List<ReceptionItem> receptionItems);

}
