/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest;

import com.faculte.simplefacultereception.domain.bean.Reception;
import com.faculte.simplefacultereception.domain.rest.vo.ReceptionVo;
import com.faculte.simplefacultereception.domain.model.service.ReceptionService;
import com.faculte.simplefacultereception.domain.rest.converter.AbstractConverter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Anas
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reception-api/receptions")
public class ReceptionRest {

    @Autowired
    private ReceptionService receptionService;
    @Autowired
    @Qualifier("receptionConverter")
    private AbstractConverter<Reception,ReceptionVo> receptionConverter;

    @PostMapping("/")
    public int createReception(@RequestBody ReceptionVo receptionVo) {
        return receptionService.createReception(receptionConverter.toItem(receptionVo));
    }

    @GetMapping("/receptions")
    public List<ReceptionVo> findAll() {
        return receptionConverter.toVo(receptionService.findAll());
    }

    @GetMapping("/reference/{reference}")
    public ReceptionVo findReceptionByReference(@PathVariable String reference) {
        return receptionConverter.toVo(receptionService.findByReference(reference));
    }

    @GetMapping("/reference")
    public String generateReceptionReference() {
        return receptionService.generateReceptionReference();
    }
    

    public ReceptionService getReceptionService() {
        return receptionService;
    }

    public void setReceptionService(ReceptionService receptionService) {
        this.receptionService = receptionService;
    }

    public AbstractConverter<Reception, ReceptionVo> getReceptionConverter() {
        return receptionConverter;
    }

    public void setReceptionConverter(AbstractConverter<Reception, ReceptionVo> receptionConverter) {
        this.receptionConverter = receptionConverter;
    }

  

}
