/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapinotes.service.impl;

import com.efaculte.efaculteapinotes.bean.NoteEtudiantModule;
import com.efaculte.efaculteapinotes.common.util.Jexcel;
import static com.efaculte.efaculteapinotes.common.util.Jexcel.startXl;
import com.efaculte.efaculteapinotes.dao.NoteEtudiantModuleDao;
import com.efaculte.efaculteapinotes.rest.converter.NoteEtudiantModuleConverter;
import com.efaculte.efaculteapinotes.rest.proxy.EtudiantProxy;
import com.efaculte.efaculteapinotes.rest.vo.NoteEtudiantModuleVo;
import com.efaculte.efaculteapinotes.service.NoteEtudiantModuleService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naoufal's pc
 */
@Service
public class NoteEtudiantModuleServiceImpl implements NoteEtudiantModuleService {

    @Autowired
    private NoteEtudiantModuleDao noteEtudiantModuleDao;
    @Autowired
    private EtudiantProxy etudiantProxy;

    public NoteEtudiantModuleDao getNoteEtudiantModuleDao() {
        return noteEtudiantModuleDao;
    }

    public void setNoteEtudiantModuleDao(NoteEtudiantModuleDao noteEtudiantModuleDao) {
        this.noteEtudiantModuleDao = noteEtudiantModuleDao;
    }

    public EtudiantProxy getEtudiantProxy() {
        return etudiantProxy;
    }

    public void setEtudiantProxy(EtudiantProxy etudiantProxy) {
        this.etudiantProxy = etudiantProxy;
    }

//    @Override
//    public List<NoteEtudiantModule> findByrefSemestre(String refSemestre) {
//    return noteEtudiantModuleDao.findByrefSemestre(refSemestre);
//    }
//    @Override
//    public NoteEtudiantModule create(String refEtudant, String refModule, Integer finale) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public List<NoteEtudiantModuleVo> create(String xlfile, String module, String semestre, int j) {
        List<NoteEtudiantModuleVo> notesVo = new ArrayList<>();
        Jexcel jexcel = new Jexcel();
        File file = new File(xlfile);

        try {
            Sheet s = startXl(file);
            int r = s.getRows();
            for (int i = j; i < r-1; i++) {
                NoteEtudiantModuleVo note = jexcel.createNote(file, i);
                note.setRefModule(module);
                note.setRefSemestre(semestre);
                NoteEtudiantModule test = noteEtudiantModuleDao.findByRefEtudiant(note.getRefEtudiant());
                if (test != null) {
                    note.setEtat("Existant");
                } else if (note.getRefEtudiant() == "") {
                    note.setEtat("Pas de CNE");
                } else if (note.getFinale() == "") {
                    note.setEtat("Pas de note finale");
                } else {
                    note.setEtat("Good");
                }
                notesVo.add(note);
            }
        } catch (IOException ex) {
            Logger.getLogger(NoteEtudiantModuleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(NoteEtudiantModuleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //        for (NoteEtudiantModule note : notesVo) {
        //            NoteEtudiantModule test = noteEtudiantModuleDao.findByRefEtudiant(note.getRefEtudiant());
        //            if (test != null) {
        //                test.setFinale(note.getFinale());
        //                noteEtudiantModuleDao.save(test);
        //            } else {
        //                noteEtudiantModuleDao.save(note);
        //            }
        //        }
        return notesVo;
    }

    @Override
    public NoteEtudiantModule findByRefEtudiant(String refEtudiant) {
        return noteEtudiantModuleDao.findByRefEtudiant(refEtudiant);
    }

    @Override
    public List<NoteEtudiantModule> findAll() {
        return noteEtudiantModuleDao.findAll();
    }

    @Override
    public List<NoteEtudiantModule> saveNotes(List<NoteEtudiantModule> notes) {
        if (notes.isEmpty()) {
            return null;
        } else {
            List<NoteEtudiantModule> existing = new ArrayList<>();
            for (NoteEtudiantModule note : notes) {
                NoteEtudiantModule test = noteEtudiantModuleDao.findByRefEtudiant(note.getRefEtudiant());
                if (test != null || note.getRefEtudiant() == "" || "".equals(note.getFinale())) {
                    existing.add(note);
                } else {
//                    noteEtudiantModuleDao.save(note);
                }
            }
            return existing;
        }
    }
}
