/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.model.service;

import com.faculte.simplefacultereception.domain.bean.Reception;
import java.util.List;

/**
 *
 * @author Anas
 */
public interface ReceptionService {

    public int createReception(Reception reception);

    public List<Reception> findAll();

    public Reception findByReference(String reference);

    public List<Reception> findByCommandeReference(String reference);

}
