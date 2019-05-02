/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapinotes.rest.vo.exchange;

import java.util.List;

/**
 *
 * @author Naoufal's pc
 */
public class SemestreVo {
    
    private Long id;
    private String libelle;
    private String reference;
    private List<ModuleVo> filiereModuleVos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<ModuleVo> getFiliereModuleVos() {
        return filiereModuleVos;
    }

    public void setFiliereModuleVos(List<ModuleVo> filiereModuleVos) {
        this.filiereModuleVos = filiereModuleVos;
    }
    
    
}
