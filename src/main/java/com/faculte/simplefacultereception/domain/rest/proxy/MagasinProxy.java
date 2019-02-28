/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest.proxy;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 *
 * @author Anas
 */
@FeignClient(name = "microservice-magasin")
@RibbonClient(name = "microservice-magasin")
public interface MagasinProxy {

   
}
