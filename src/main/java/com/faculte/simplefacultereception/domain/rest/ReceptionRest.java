/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest;

import com.faculte.simplefacultereception.commun.util.DateUtil;
import com.faculte.simplefacultereception.commun.util.GeneratePdf;
import com.faculte.simplefacultereception.domain.bean.Reception;
import com.faculte.simplefacultereception.domain.model.service.ReceptionItemService;
import com.faculte.simplefacultereception.domain.rest.vo.ReceptionVo;
import com.faculte.simplefacultereception.domain.model.service.ReceptionService;
import com.faculte.simplefacultereception.domain.rest.converter.AbstractConverter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    private ReceptionItemService receptionItemService;
    @Autowired
    @Qualifier("receptionConverter")
    private AbstractConverter<Reception, ReceptionVo> receptionConverter;

    @PostMapping("/search")
    public List<ReceptionVo> findByCriteria(@RequestBody ReceptionVo receptionVo) {
        return receptionConverter.toVo(receptionService.findByCriteria(receptionVo.getReference(), receptionVo.getReferenceCommande(), DateUtil.parseDate(receptionVo.getDateMin()), DateUtil.parseDate(receptionVo.getDateMax())));
    }

    @GetMapping("/referencecommande/{refcommande}/strategy/{strategy}")
    public List<ReceptionVo> findStocksByCommandeAndStrategy(@PathVariable String refcommande, @PathVariable String strategy) {
        return receptionConverter.toVo(receptionService.findStocksByCommandeAndStrategy(refcommande, strategy));
    }

    @PostMapping("/")
    public int createReception(@RequestBody ReceptionVo receptionVo) {
        int res = receptionService.createReception(receptionConverter.toItem(receptionVo));
        return res;
    }

    @GetMapping("/")
    public List<ReceptionVo> findAll() {
        return receptionConverter.toVo(receptionService.findAll());
    }

    @GetMapping("/reference/{reference}")
    public ReceptionVo findReceptionByReference(@PathVariable String reference) {
        return receptionConverter.toVo(receptionService.findByReference(reference));
    }

    @GetMapping("/pdf/reference/{reference}")
    public ResponseEntity<Object> CommandePrint(@PathVariable String reference) throws JRException, IOException {
        Reception r = receptionService.findByReference(reference);
        if (r == null) {
            r = new Reception();
        }
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("dateReception", r.getDateReception());
        parameters.put("referenceCommande", r.getReferenceCommande());
        parameters.put("reference", r.getReference());

        return GeneratePdf.generate("reception", parameters, receptionItemService.findByReceptionReference(reference), "/reports/reception.jasper");
    }

    @DeleteMapping("/reference/{reference}")
    public void removeReceptionByReference(@PathVariable String reference) {
        receptionService.removeByReference(reference);
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
