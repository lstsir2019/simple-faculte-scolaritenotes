/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapinotes.rest;

import com.efaculte.efaculteapinotes.bean.NoteEtudiantModule;
import com.efaculte.efaculteapinotes.rest.converter.NoteEtudiantModuleConverter;
import com.efaculte.efaculteapinotes.rest.vo.NoteEtudiantModuleVo;
import com.efaculte.efaculteapinotes.service.NoteEtudiantModuleService;
import java.io.IOException;
import java.util.List;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Naoufal's pc
 */
@RestController()
@CrossOrigin(origins = ("http://localhost:4200"))
@RequestMapping({"/efaculte-api-notes/notes"})
public class NoteEtudiantModuleRest {

    @Autowired
    private NoteEtudiantModuleService noteEtudiantModuleService;

//    @GetMapping("/reference/{reference}")
//    public List<NoteEtudiantModule> create(@PathVariable NotesCreate notesCreate) throws IOException, BiffException {
////        xlfile = "C:\\Users\\HP\\Desktop\\rsultatssgbd.xls";
//        System.out.println(notesCreate.getXpath());
//        String link = "C:\\Users\\HP\\Desktop\\" + notesCreate.getXpath();
//        return noteEtudiantModuleService.create(link, notesCreate.getRefModule());
//    }
//    @GetMapping("/")
//    public List<NoteEtudiantModule> findAll() {
//        return noteEtudiantModuleService.findAll();
//    }
//    @GetMapping()
//    public List<NoteEtudiantModule> findByrefSemestre(@PathVariable String refSemestre) {
//        return noteEtudiantModuleService.findByrefSemestre(refSemestre);
//    }
    @GetMapping("/xlpath/{xlpath}/module/{module}/semestre/{semestre}/firstline/{j}")
    public List<NoteEtudiantModuleVo> create(@PathVariable String xlpath, @PathVariable String module, @PathVariable String semestre, @PathVariable int j) throws IOException, BiffException {
//        xlfile = "C:\\Users\\HP\\Desktop\\rsultatssgbd.xls";
        String link1 = "C:\\Users\\HP\\Desktop\\" + xlpath + ".xls";
        return noteEtudiantModuleService.create(link1, module, semestre, j);
    }

    @PostMapping("/")
    public List<NoteEtudiantModule> saveNotes(@RequestBody List<NoteEtudiantModuleVo> notesVo) {
        NoteEtudiantModuleConverter noteEtudiantModuleConverter = new NoteEtudiantModuleConverter();
        List<NoteEtudiantModule> notes = noteEtudiantModuleConverter.toItem(notesVo);
        return noteEtudiantModuleService.saveNotes(notes);
    }

    public NoteEtudiantModuleService getNoteEtudiantModuleService() {
        return noteEtudiantModuleService;
    }

    public void setNoteEtudiantModuleService(NoteEtudiantModuleService noteEtudiantModuleService) {
        this.noteEtudiantModuleService = noteEtudiantModuleService;
    }
}
