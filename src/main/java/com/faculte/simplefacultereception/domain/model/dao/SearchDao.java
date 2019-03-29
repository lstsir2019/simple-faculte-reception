package com.faculte.simplefacultereception.domain.model.dao;

import com.faculte.simplefacultereception.domain.bean.Reception;

import java.util.Date;
import java.util.List;

public interface SearchDao {
    public List<Reception> findByCriteria(String reference, String commande,Date dateMin,Date dateMax,Double qte);
}
