/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapinotes.service.impl;

import com.efaculte.efaculteapinotes.bean.ExcelFile;
import com.efaculte.efaculteapinotes.bean.NoteEtudiantModule;
import com.efaculte.efaculteapinotes.common.util.Jexcel;
import static com.efaculte.efaculteapinotes.common.util.Jexcel.startXl;
import com.efaculte.efaculteapinotes.dao.NoteEtudiantModuleDao;
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

    public NoteEtudiantModuleDao getNoteEtudiantModuleDao() {
        return noteEtudiantModuleDao;
    }

    public void setNoteEtudiantModuleDao(NoteEtudiantModuleDao noteEtudiantModuleDao) {
        this.noteEtudiantModuleDao = noteEtudiantModuleDao;
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
    public List<NoteEtudiantModule> create(String xlfile, String module, String semestre, int j) {
        List<NoteEtudiantModule> notes = new ArrayList<>();
        Jexcel jexcel = new Jexcel();
        File file = new File(xlfile);

        try {
            Sheet s = startXl(file);
            int r = s.getRows();
            for (int i = j; i < r; i++) {
                NoteEtudiantModule note = jexcel.createNote(file, i);
                note.setRefModule(module);
                note.setRefSemestre(semestre);
                if (note.getRefEtudiant() != "") {
                    notes.add(note);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(NoteEtudiantModuleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(NoteEtudiantModuleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
//        for (NoteEtudiantModule note : notes) {
//            NoteEtudiantModule test = noteEtudiantModuleDao.findByRefEtudiant(note.getRefEtudiant());
//            if (test != null) {
//                test.setFinale(note.getFinale());
//                noteEtudiantModuleDao.save(test);
//            } else {
//                noteEtudiantModuleDao.save(note);
//            }
//        }
        return notes;
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
            List<NoteEtudiantModule> existed = new ArrayList<>();
            for (NoteEtudiantModule note : notes) {
                NoteEtudiantModule test = noteEtudiantModuleDao.findByRefEtudiant(note.getRefEtudiant());
                if (test != null) {
                    existed.add(note);
                }
            }
//             notes.removeAll(existed);
//             for (NoteEtudiantModule note : notes) {
//             noteEtudiantModuleDao.save(note);
//            }
            return existed;
        }
    }
}