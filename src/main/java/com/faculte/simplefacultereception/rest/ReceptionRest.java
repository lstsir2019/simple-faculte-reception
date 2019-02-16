/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.rest;

import com.faculte.simplefacultereception.rest.converter.ReceptionConverter;
import com.faculte.simplefacultereception.rest.converter.ReceptionItemConverter;
import com.faculte.simplefacultereception.rest.proxy.ProduitProxy;
import com.faculte.simplefacultereception.rest.vo.ReceptionItemVo;
import com.faculte.simplefacultereception.rest.vo.ReceptionVo;
import com.faculte.simplefacultereception.rest.vo.exchange.ProduitVo;
import com.faculte.simplefacultereception.service.ReceptionItemService;
import com.faculte.simplefacultereception.service.ReceptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
//@CrossOrigin(origins = "http://127.0.0.1:4200")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reception-api/reception")
public class ReceptionRest {

    @Autowired
    private ReceptionService receptionService;
    @Autowired
    private ReceptionItemService receptionItemService;
    @Autowired
    private ReceptionConverter receptionConverter;
    @Autowired
    private ReceptionItemConverter receptionItemConverter;
    @Autowired
    private ProduitProxy produitProxy ;

    @PostMapping("/")
    public int createReception(@RequestBody ReceptionVo receptionVo) {
        return receptionService.createReception(receptionConverter.toItem(receptionVo));
    }

    @GetMapping("/receptions")
    public List<ReceptionVo> findAll() {
        return receptionConverter.toVo(receptionService.findAll());
    }

    @GetMapping("/reference/{reference}/receptionitems")
    public List<ReceptionItemVo> findByReceptionreference(@PathVariable("reference") String reference) {
        return receptionItemConverter.toVo(receptionItemService.findByReceptionReference(reference));
    }

    @GetMapping("/test/{reference}")
    public int findByReference(@PathVariable String reference) {
        for (int i = 0; i < 9999; i++) {
            produitProxy.findByReference(reference);
        }
        return 1;
    }

    @GetMapping("/reference/{reference}")
    public ReceptionVo findReceptionByReference(@PathVariable String reference) {
        return receptionConverter.toVo(receptionService.findByReference(reference));
    }

    public ReceptionService getReceptionService() {
        return receptionService;
    }

    public void setReceptionService(ReceptionService receptionService) {
        this.receptionService = receptionService;
    }

    public ReceptionConverter getReceptionConverter() {
        return receptionConverter;
    }

    public void setReceptionConverter(ReceptionConverter receptionConverter) {
        this.receptionConverter = receptionConverter;
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

    public ProduitProxy getProduitProxy() {
        return produitProxy;
    }

    public void setProduitProxy(ProduitProxy produitProxy) {
        this.produitProxy = produitProxy;
    }

}
