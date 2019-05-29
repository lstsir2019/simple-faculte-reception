/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest.proxy;

import com.faculte.simplefacultereception.domain.rest.vo.exchange.CommandeItemVo;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Anas
 */
@FeignClient(name = "simple-faculte-commande", url = "localhost:8090")
@RibbonClient(name = "simple-faculte-commande")
public interface CommandeProxy {

    @PutMapping("/faculte-commande/items/QteReception/increment")
    public int incrementQteReception(@RequestBody CommandeItemVo commandeItemVo);

    @PutMapping("/faculte-commande/items/QteReception/decrement")
    public int decrementQteReception(@RequestBody CommandeItemVo commandeItemVo);

}
