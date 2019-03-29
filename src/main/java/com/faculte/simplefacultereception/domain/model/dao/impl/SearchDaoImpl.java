package com.faculte.simplefacultereception.domain.model.dao.impl;

import com.faculte.simplefacultereception.domain.bean.Reception;
import com.faculte.simplefacultereception.domain.model.dao.SearchDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Repository
public class SearchDaoImpl implements SearchDao {

    EntityManager entityManager;

    public SearchDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*
        public List<Reception> findByCriteria(String reference,String commande ,Date dateMin, Date dateMax, Double qte) {
            String query="SELECT r FROM Reception r where 1=1";
            if(reference!=null && !reference.isEmpty()) query+=" and r.reference='"+reference+"'";
            if(commande!=null && !commande.isEmpty()) query+=" and r.referenceCommande='"+commande+"'";
            return entityManager.createQuery( query).getResultList();
        }*/

    @Override
    public List<Reception> findByCriteria(String reference, String commande, Date dateMin, Date dateMax, Double qte) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Reception> cq = cb.createQuery(Reception.class);

        Root<Reception> root = cq.from(Reception.class);
        if (reference != null && !reference.isEmpty()){
            Predicate referencePredicate = cb.equal(root.get("reference"), reference);
            cq.where(referencePredicate);
        }
        if (commande != null && !commande.isEmpty()){
            Predicate commandePredicate = cb.like(root.get("referenceCommande"), "%" + commande + "%");
            cq.where( commandePredicate);
        }

       // cq.
        TypedQuery<Reception> query = entityManager.createQuery(cq);

        return query.getResultList();
    }


}
