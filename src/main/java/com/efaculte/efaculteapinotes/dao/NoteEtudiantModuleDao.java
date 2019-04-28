/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapinotes.dao;

import com.efaculte.efaculteapinotes.bean.NoteEtudiantModule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Naoufal's pc
 */
@Repository
public interface NoteEtudiantModuleDao extends JpaRepository<NoteEtudiantModule, Long> {

//    public List<NoteEtudiantModule> findByrefSemestre(String refSemestre);
    public NoteEtudiantModule findByRefEtudiant(String refEtudiant);

    public List<NoteEtudiantModule> findAll();

    public int deleteByRefEtudiant(String refEtudiant);

}
