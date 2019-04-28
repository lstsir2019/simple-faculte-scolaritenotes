/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapinotes.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Naoufal's pc
 */
@Entity
public class NoteEtudiantModule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String refSemestre;
    private String refModule;
    private String refEtudiant;
    private String noteAavantRatt;
    private String noteapresRatt;
    private String finale;
    private String statutFinal;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

  
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NoteEtudiantModule)) {
            return false;
        }
        NoteEtudiantModule other = (NoteEtudiantModule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.efaculte.efaculteapinotes.bean.NoteEtudiantSemestre[ id=" + id + " ]";
    }

}
