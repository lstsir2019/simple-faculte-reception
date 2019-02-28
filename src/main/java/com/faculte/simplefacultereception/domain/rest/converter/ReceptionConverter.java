/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest.converter;

import com.faculte.simplefacultereception.domain.bean.Reception;
import com.faculte.simplefacultereception.commun.util.DateUtil;
import com.faculte.simplefacultereception.domain.rest.vo.ReceptionVo;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anas
 */
@Component
public class ReceptionConverter extends AbstractConverter<Reception, ReceptionVo> {

    @Override
    public Reception toItem(ReceptionVo receptionVo) {
        if (receptionVo != null) {
            Reception reception = new Reception();
            reception.setReference(receptionVo.getReference());
            reception.setReferenceCommande(receptionVo.getReferenceCommande());
            reception.setReceptionItems(new ReceptionItemConverter().toItem(receptionVo.getReceptionItems()));
            Date receptionDate = DateUtil.parseDate(receptionVo.getDateReception());
            reception.setDateReception(receptionDate);
            return reception;
        }
        return null;
    }

    @Override
    public ReceptionVo toVo(Reception item) {
        if (item == null) {
            return null;
        } else {
            ReceptionVo receptionVo = new ReceptionVo();
            receptionVo.setReference(item.getReference());
            receptionVo.setReferenceCommande(item.getReferenceCommande());
            receptionVo.setDateReception(DateUtil.formateDate(item.getDateReception()));
            receptionVo.setReceptionItems(new ReceptionItemConverter().toVo(item.getReceptionItems()));
            return receptionVo;
        }
    }

}
