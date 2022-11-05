/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkyong.examples;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerFicherosExcel {
	private static final  Logger logger = Logger.getLogger(LeerFicherosExcel.class);
	public static void main(String[] args) {
		String nombreArchivo = "Inventario.xlsx";
		String rutaArchivo = "C:\\Ficheros-Excel\\" + nombreArchivo;
		String hoja = "Hoja1";

		try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
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
	}
}