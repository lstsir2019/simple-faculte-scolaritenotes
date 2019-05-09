/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapinotes.rest.converter;

import com.efaculte.efaculteapinotes.bean.NoteEtudiantModule;
import com.efaculte.efaculteapinotes.rest.vo.NoteEtudiantModuleVo;

/**
 *
 * @author Naoufal's pc
 */
public class NoteEtudiantModuleConverter extends AbstractConverter<NoteEtudiantModule, NoteEtudiantModuleVo> {

    @Override
    public NoteEtudiantModule toItem(NoteEtudiantModuleVo vo) {
        if (vo == null) {
            return null;
        } else {
            NoteEtudiantModule item = new NoteEtudiantModule();
            item.setId(vo.getId());
            item.setRefEtudiant(vo.getRefEtudiant());
            item.setRefModule(vo.getRefModule());
            item.setRefSemestre(vo.getRefSemestre());
            item.setNoteAavantRatt(vo.getRefSemestre());
            item.setNoteapresRatt(vo.getNoteapresRatt());
            item.setFinale(vo.getNoteapresRatt());
            item.setStatutFinal(vo.getStatutFinal());
            return item;
        }
    }

    @Override
    public NoteEtudiantModuleVo toVo(NoteEtudiantModule item) {
        if (item == null) {
            return null;
        } else {
            NoteEtudiantModuleVo vo = new NoteEtudiantModuleVo();
            vo.setId(item.getId());
            vo.setRefEtudiant(item.getRefEtudiant());
            vo.setRefModule(item.getRefModule());
            vo.setRefSemestre(item.getRefSemestre());
            vo.setNoteAavantRatt(item.getRefSemestre());
            vo.setNoteapresRatt(item.getNoteapresRatt());
            vo.setFinale(item.getNoteapresRatt());
            vo.setStatutFinal(item.getStatutFinal());
            return vo;
        }
    }

}
