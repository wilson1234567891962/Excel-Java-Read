/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkyong.examples;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerFicherosExcel {
	private static final  Logger logger = Logger.getLogger(LeerFicherosExcel.class);
	public String readFile() {
		String nombre = "Reporte Diario - copia.xlsx";

		try (FileInputStream file = new FileInputStream(nombre)) {
			XSSFWorkbook worbook = new XSSFWorkbook(file);
			XSSFSheet sheet = worbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();

			Row row;

			while (rowIterator.hasNext()) {
				row = rowIterator.next();

				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell;

				while (cellIterator.hasNext()) {

					cell = cellIterator.next();
					logger.info(cell.getStringCellValue()+" | ");
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return nombre;
	}
}