/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest;

import com.faculte.simplefacultereception.domain.model.service.ReceptionItemService;
import com.faculte.simplefacultereception.domain.rest.converter.ReceptionItemConverter;
import com.faculte.simplefacultereception.domain.rest.vo.ReceptionItemVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Anas
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reception-api/receptionitems")
public class ReceptionItemsRest {

    @Autowired
    private ReceptionItemService receptionItemService;
    @Autowired
    private ReceptionItemConverter receptionItemConverter;

    @GetMapping("/reference/{reference}")
    public List<ReceptionItemVo> findByReceptionreference(@PathVariable("reference") String reference) {
        return receptionItemConverter.toVo(receptionItemService.findByReceptionReference(reference));
    }

    public ReceptionItemService getReceptionItemService() {
        return receptionItemService;
    }

    public void setReceptionItemService(ReceptionItemService receptionItemService) {
        this.receptionItemService = receptionItemService;
    }

    public ReceptionItemConverter getReceptionItemConverter() {
        return receptionItemConverter;
    }

    public void setReceptionItemConverter(ReceptionItemConverter receptionItemConverter) {
        this.receptionItemConverter = receptionItemConverter;
    }
}
