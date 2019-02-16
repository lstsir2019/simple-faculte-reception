/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.rest.converter;

import com.faculte.simplefacultereception.bean.Reception;
import com.faculte.simplefacultereception.commun.util.ConverterUtil;
import com.faculte.simplefacultereception.rest.vo.ReceptionVo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anas
 */
@Component
public class ReceptionConverter implements AbstractConverter<Reception, ReceptionVo> {

    @Override
    public Reception toItem(ReceptionVo receptionVo) {
        if (receptionVo != null) {
            Reception reception = new Reception();
            reception.setReference(receptionVo.getReference());
            reception.setReferenceCommande(receptionVo.getReferenceCommande());
            reception.setReceptionItems(new ReceptionItemConverter().toItem(receptionVo.getReceptionItems()));
            try {
                Date receptionDate = ConverterUtil.parseDate(receptionVo.getDateReception());
                reception.setDateReception(receptionDate);
            } catch (ParseException e) {
                reception.setDateReception(null);
            }
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
            receptionVo.setDateReception(ConverterUtil.formateDate(item.getDateReception()));
            receptionVo.setReceptionItems(new ReceptionItemConverter().toVo(item.getReceptionItems()));
            return receptionVo;
        }
    }

    public List<ReceptionVo> toVo(List<Reception> receptions) {
        List<ReceptionVo> receptionVos = new ArrayList<>();
        if (receptions != null) {
            receptions.forEach((reception) -> {
                receptionVos.add(toVo(reception));
            });
        }
        return receptionVos;
    }
}
