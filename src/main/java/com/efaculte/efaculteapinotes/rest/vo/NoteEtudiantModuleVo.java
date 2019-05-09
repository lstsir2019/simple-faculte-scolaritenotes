/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.efaculte.efaculteapinotes.rest.vo;

/**
 *
 * @author YOUNES
 */
public class NoteEtudiantModuleVo {

    private Long id;
    private String refSemestre;
    private String refModule;
    private String refEtudiant;
    private String noteAavantRatt;
    private String noteapresRatt;
    private String finale;
    private String statutFinal;
    private String etat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefSemestre() {
        return refSemestre;
    }

    public void setRefSemestre(String refSemestre) {
        this.refSemestre = refSemestre;
    }

    public String getRefModule() {
        return refModule;
    }

    public void setRefModule(String refModule) {
        this.refModule = refModule;
    }

    public String getRefEtudiant() {
        return refEtudiant;
    }

    public void setRefEtudiant(String refEtudiant) {
        this.refEtudiant = refEtudiant;
    }

    public String getNoteAavantRatt() {
        return noteAavantRatt;
    }

    public void setNoteAavantRatt(String noteAavantRatt) {
        this.noteAavantRatt = noteAavantRatt;
    }

    public String getNoteapresRatt() {
        return noteapresRatt;
    }

    public void setNoteapresRatt(String noteapresRatt) {
        this.noteapresRatt = noteapresRatt;
    }

    public String getFinale() {
        return finale;
    }

    public void setFinale(String finale) {
        this.finale = finale;
    }

    public String getStatutFinal() {
        return statutFinal;
    }

    public void setStatutFinal(String statutFinal) {
        this.statutFinal = statutFinal;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    
    
}
