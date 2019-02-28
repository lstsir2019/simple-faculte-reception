/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest.converter;

import com.faculte.simplefacultereception.commun.util.NumberUtil;
import com.faculte.simplefacultereception.domain.bean.ReceptionItem;
import com.faculte.simplefacultereception.domain.rest.vo.ReceptionItemVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anas
 */
@Component
public class ReceptionItemConverter extends AbstractConverter<ReceptionItem, ReceptionItemVo> {

    @Override
    public ReceptionItem toItem(ReceptionItemVo receptionItemVo) {
        if (receptionItemVo != null) {
            ReceptionItem receptionItem = new ReceptionItem();
            receptionItem.setReferenceCategorie(receptionItemVo.getReferenceCategorie());
            receptionItem.setReferenceProduit(receptionItemVo.getReferenceProduit());
            receptionItem.setReferenceMagasin(receptionItemVo.getReferenceMagasin());
            receptionItem.setQte(NumberUtil.toInteger(receptionItemVo.getQte()));
            return receptionItem;
        }
        return null;
    }

    @Override
    public ReceptionItemVo toVo(ReceptionItem item) {
        if (item != null) {
            ReceptionItemVo itemVo = new ReceptionItemVo();
            itemVo.setReferenceCategorie(item.getReferenceCategorie());
            itemVo.setReferenceProduit(item.getReferenceProduit());
            itemVo.setReferenceMagasin(item.getReferenceMagasin());
            itemVo.setQte(item.getQte() + "");
            return itemVo;
        } else {
            return null;
        }
    }
}
