package com.faculte.simplefacultereception.domain.model.dao.search;

import com.faculte.simplefacultereception.domain.bean.Reception;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;
import util.SearchUtil;
import com.faculte.simplefacultereception.domain.model.dao.ReceptionSearch;

@Repository
public class ReceptionSearchImpl  implements ReceptionSearch{

    private EntityManager entityManager;

    public ReceptionSearchImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Reception> findByCriteria(String reference, String commande, Date dateMin, Date dateMax) {
        String query = "SELECT r FROM Reception r where 1=1";
        query+=SearchUtil.addConstraint("r", "reference", "LIKE", reference);
        query+=SearchUtil.addConstraint("r", "referenceCommande", "LIKE", commande);
        query+=SearchUtil.addConstraintMinMaxDate("r", "dateReception", dateMin, dateMax);
        return entityManager.createQuery(query).getResultList();
    }

//    @Override
//    public List<Reception> findByCriteria(String reference, String commande, Date dateMin, Date dateMax, Double qte) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Reception> cq = cb.createQuery(Reception.class);
//
//        Root<Reception> root = cq.from(Reception.class);
//        if (reference != null && !reference.isEmpty()){
//            Predicate referencePredicate = cb.equal(root.get("reference"), reference);
//            cq.where(referencePredicate);
//        }
//        if (commande != null && !commande.isEmpty()){
//            Predicate commandePredicate = cb.like(root.get("referenceCommande"), "%" + commande + "%");
//            cq.where( commandePredicate);
//        }
//
//       // cq.
//        TypedQuery<Reception> query = entityManager.createQuery(cq);
//
//        return query.getResultList();
//    }
}
