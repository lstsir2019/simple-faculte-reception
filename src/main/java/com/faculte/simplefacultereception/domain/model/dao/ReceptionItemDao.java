/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.model.dao;

import com.faculte.simplefacultereception.domain.bean.Reception;
import com.faculte.simplefacultereception.domain.bean.ReceptionItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anas
 */
@Repository
public interface ReceptionItemDao extends JpaRepository<ReceptionItem, Long> {


    public List<ReceptionItem> findByReceptionReference(String reference);
}
