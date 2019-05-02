/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapinotes.rest.vo.exchange;

/**
 *
 * @author Naoufal's pc
 */
public class EtudiantVo {
    
    private Long id;
    private String napogee;
    private String cne;
    private String filiereActuelle;
    private String reference;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNapogee() {
        return napogee;
    }

    public void setNapogee(String napogee) {
        this.napogee = napogee;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getFiliereActuelle() {
        return filiereActuelle;
    }

    public void setFiliereActuelle(String filiereActuelle) {
        this.filiereActuelle = filiereActuelle;
    }

    

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    
    
    
}
