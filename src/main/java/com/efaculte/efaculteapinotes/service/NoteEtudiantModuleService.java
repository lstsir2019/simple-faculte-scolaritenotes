/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapinotes.service;

import com.efaculte.efaculteapinotes.bean.NoteEtudiantModule;
import com.efaculte.efaculteapinotes.rest.vo.NoteEtudiantModuleVo;
import java.util.List;

/**
 *
 * @author Naoufal's pc
 */
public interface NoteEtudiantModuleService {

//    public List<NoteEtudiantModule> findByrefSemestre(String refSemestre);
    public List<NoteEtudiantModuleVo> create(String xlfile, String Module, String Semestre, int j);

    public NoteEtudiantModule findByRefEtudiant(String refEtudiant);

    public List<NoteEtudiantModule> findAll();

    public List<NoteEtudiantModule> saveNotes(List<NoteEtudiantModule> notes);

}
