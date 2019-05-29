/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest.proxy;

import com.faculte.simplefacultereception.domain.rest.vo.exchange.StockVo;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Anas
 */
@FeignClient(name = "microservice-stock", url = "localhost:8042")
@RibbonClient(name = "microservice-stock")
public interface StockProxy {

    @PostMapping("/stock-api/stocks/")
    public int save(@RequestBody StockVo stock);

    @DeleteMapping("/stock-api/stocks/commande/{referencecommande}/reception/{referencereception}")
    public void deleteByReferenceCommandeAndReception(@PathVariable("referencecommande") String referencecommande, @PathVariable("referencereception") String referencereception);

}
