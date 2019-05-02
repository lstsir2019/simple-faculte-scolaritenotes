/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapinotes.rest.proxy;

import com.efaculte.efaculteapinotes.rest.vo.exchange.EtudiantVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Naoufal's pc
 */
@FeignClient(name = "microservice1-etudiant", url = "localhost:8091")
public interface EtudiantProxy {
    
    @GetMapping("/efaculte-v1-api/etudiants/cne/{cne}")
    public EtudiantVo findByCne(@PathVariable("cne") String cne);
}
