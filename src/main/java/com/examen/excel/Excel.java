/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examen.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author wilso
 */
public class Excel {

    public static void main(String[] args) {
        try {
            System.out.println("Prueba de codigo");
            ArrayList<String> dta = new ArrayList<>();
            try (Workbook workbook = WorkbookFactory.create(new File("C:\\Users\\wilso\\OneDrive\\Documents\\NetBeansProjects\\Excel\\src\\resources/Employment.xlsx"))) {
                Sheet firstSheet = workbook.getSheetAt(0);
                Iterator<Row> iterator = firstSheet.iterator();
                StringBuilder result;
                while (iterator.hasNext()) {
                    result = new StringBuilder();
                    Row nextRow = iterator.next();
                    Iterator<Cell> cellIterator = nextRow.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                result.append(cell.getStringCellValue());
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                result.append(cell.getNumericCellValue());
                                break;
                        }
                        result.append(":");
                    }
                    dta.add(result.toString());
                }
                System.out.println("Resultado");
                System.out.println(dta);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
