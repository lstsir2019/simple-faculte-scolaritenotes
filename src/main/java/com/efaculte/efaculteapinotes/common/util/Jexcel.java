/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapinotes.common.util;

import com.efaculte.efaculteapinotes.bean.NoteEtudiantModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author Naoufal's pc
 */
public class Jexcel {

    public static void readXls(File file) throws IOException, BiffException {
        Sheet s = startXl(file);
        int rows = s.getRows();
        int cols = s.getColumns();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                jxl.Cell c = s.getCell(j, i);
                if (c.getCellFormat() != null) {
                    System.out.println(c.getContents() + " ");
                }
            }
        }
    }

    public static void readLine(File file, int line) throws IOException, BiffException {
        Sheet s = startXl(file);
        int rows = s.getRows();
        for (int i = 0; i < rows; i++) {
            jxl.Cell c = s.getCell(i, line - 1);
            System.out.println(c.getContents() + " ");
        }
    }

    public static void readCell(File file, int col, int row) throws IOException, BiffException {
        Sheet s = startXl(file);
        jxl.Cell c = s.getCell(col - 1, row - 1);
        if (c.getCellFormat() != null) {
            System.out.println(c.getContents() + " ");
        }
    }

    public static Sheet startXl(File file) throws IOException, BiffException {
        Workbook workbook = Workbook.getWorkbook(file);
        Sheet s = workbook.getSheet(0);
        return s;
    }

    public static List createList(File file) throws IOException, BiffException {
        Sheet s = startXl(file);
        int cols = s.getColumns();
        List<String> eList = new ArrayList();
        for (int k = 0; k < s.getRows(); k++) {
            for (int i = 0; i < cols; i++) {
                jxl.Cell c = s.getCell(i, k);
                eList.add(c.getContents());
            }
        }
//        for (int i = 0; i < eList.size(); i++) {
//            String get = eList.get(i);
//            if (!"".equals(get)) {
//                System.out.println(get);
//            }
//            
//
//        }
        return eList;
    }

    public NoteEtudiantModule createNote(File file, int line) throws IOException, BiffException {
        List elist = new ArrayList();
        Sheet s = startXl(file);
        NoteEtudiantModule noteEtudiantModule = new NoteEtudiantModule();
        int cols = s.getColumns();
        for (int i = 0; i < cols; i++) {
            jxl.Cell c = s.getCell(i, line);
            elist.add(c.getContents());
        }
        noteEtudiantModule.setRefEtudiant((String) elist.get(0));
        noteEtudiantModule.setNoteAavantRatt((String) elist.get(3));
        noteEtudiantModule.setNoteapresRatt((String) elist.get(4));
        noteEtudiantModule.setFinale((String) elist.get(5));
        noteEtudiantModule.setStatutFinal((String) elist.get(7));
        return noteEtudiantModule;
    }

}
