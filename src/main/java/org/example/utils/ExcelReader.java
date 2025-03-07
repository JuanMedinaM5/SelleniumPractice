package org.example.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    public static List<Map<String, String>> readExcel(String filePath, String sheetName) {
        List<Map<String, String>> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("La hoja con el nombre " + sheetName + " no existe.");
            }

            // Leer la primera fila para obtener los encabezados
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new IllegalArgumentException("La hoja está vacía.");
            }

            // Obtener los nombres de las columnas
            int columnCount = headerRow.getPhysicalNumberOfCells();
            String[] headers = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                Cell cell = headerRow.getCell(i);
                headers[i] = cell.getStringCellValue();
            }

            // Leer las filas restantes
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Comenzar desde 1 para omitir encabezados
                Row row = sheet.getRow(i);
                if (row != null) {
                    Map<String, String> rowData = new HashMap<>();
                    for (int j = 0; j < columnCount; j++) {
                        Cell cell = row.getCell(j);
                        String cellValue = (cell != null) ? cell.toString() : ""; // Manejar celdas nulas
                        rowData.put(headers[j], cellValue);
                    }
                    data.add(rowData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}