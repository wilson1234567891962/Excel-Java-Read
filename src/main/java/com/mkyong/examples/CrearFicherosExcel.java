/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkyong.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CrearFicherosExcel {
    final static Logger logger = Logger.getLogger(CrearFicherosExcel.class);
    private static final String VALUE_RANGE = "10.68";
    
    private static final String[][] DOCUMENT = new String[][]{
        {"AP150", "ACCESS POINT TP-LINK TL-WA901ND 450Mbps Wireless N 1RJ45 10-100 3Ant.", "112.00", "50"},
        {"RTP150", "ROUTER TP-LINK TL-WR940ND 10-100Mbpps LAN WAN 2.4 - 2.4835Ghz", "19.60", "25"},
        {"TRT300", "TARJETA DE RED TPLINK TL-WN881ND 300Mpbs Wire-N PCI-Exp.", VALUE_RANGE, "26"},
        {"TRT300", "DE RED TPLINK TL-WN881ND 300Mpbs Wire-N PCI-Exp.", VALUE_RANGE, "15"},
        {"TR0", "DE RED TPLINK TL-WN881ND 300Mpbs Wire-N PCI-Exp.", VALUE_RANGE, "14"}
    };

    public static void main(String[] args) {

        String nombreArchivo = "Inventario.xlsx";
        String rutaArchivo = "C:\\Ficheros-Excel\\" + nombreArchivo;
        String hoja = "Hoja1";

        try (XSSFWorkbook libro = new XSSFWorkbook()) {
            XSSFSheet hoja1 = libro.createSheet(hoja);
            //cabecera de la hoja de excel
            String[] header = new String[]{"Código", "Producto", "Precio", "Unidades"};

            //poner negrita a la cabecera
            CellStyle style = libro.createCellStyle();
            Font font = libro.createFont();
            font.setBold(true);
            style.setFont(font);

            //generar los datos para el documento
            for (int i = 0; i <= DOCUMENT.length; i++) {
                XSSFRow row = hoja1.createRow(i);//se crea las filas
                for (int j = 0; j < header.length; j++) {
                    if (i == 0) {//para la cabecera
                        XSSFCell cell = row.createCell(j);//se crea las celdas para la cabecera, junto con la posición
                        cell.setCellStyle(style); // se añade el style crea anteriormente
                        cell.setCellValue(header[j]);//se añade el contenido
                    } else {//para el contenido
                        XSSFCell cell = row.createCell(j);//se crea las celdas para la contenido, junto con la posición
                        cell.setCellValue(DOCUMENT[i - 1][j]); //se añade el contenido
                    }
                }
            }

            File file;
            file = new File(rutaArchivo);
            try (FileOutputStream fileOuS = new FileOutputStream(file)) {
                if (file.exists()) {
                    if (!file.delete()) {
                        logger.info("Archivo eliminado");
                    }

                }
                libro.write(fileOuS);
                fileOuS.flush();
                fileOuS.close();
                System.out.println("Archivo Creado");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
