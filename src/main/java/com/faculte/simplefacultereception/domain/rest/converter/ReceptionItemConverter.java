/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest.converter;

import com.faculte.simplefacultereception.domain.bean.ReceptionItem;
import com.faculte.simplefacultereception.commun.util.ConverterUtil;
import com.faculte.simplefacultereception.domain.rest.vo.ReceptionItemVo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anas
 */
@Component
public class ReceptionItemConverter extends AbstractConverter<ReceptionItem, ReceptionItemVo> {

    public ReceptionItemConverter() {
    }

    @Override
    public ReceptionItem toItem(ReceptionItemVo receptionItemVo) {
        if (receptionItemVo != null) {
            ReceptionItem receptionItem = new ReceptionItem();
            receptionItem.setReferenceCategorie(receptionItemVo.getReferenceCategorie());
            receptionItem.setReferenceProduit(receptionItemVo.getReferenceProduit());
            receptionItem.setReferenceMagasin(receptionItemVo.getReferenceMagasin());
            receptionItem.setQte(ConverterUtil.toInteger(receptionItemVo.getQte()));
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

    public List<ReceptionItem> toItem(List<ReceptionItemVo> receptionItemVos) {
        if (receptionItemVos == null || receptionItemVos.isEmpty()) {
            return null;
        } else {
            List<ReceptionItem> items = new ArrayList<>();
            for (ReceptionItemVo receptionItemVo : receptionItemVos) {
                items.add(toItem(receptionItemVo));
            }
            return items;
        }
    }

    public List<ReceptionItemVo> toVo(List<ReceptionItem> receptionItems) {
        if (receptionItems == null || receptionItems.isEmpty()) {
            return null;
        } else {
            List<ReceptionItemVo> itemVos = new ArrayList<>();
            for (ReceptionItem receptionItem : receptionItems) {
                itemVos.add(toVo(receptionItem));
            }
            return itemVos;
        }
    }
}
