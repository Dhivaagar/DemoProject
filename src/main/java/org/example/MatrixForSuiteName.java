package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class MatrixForSuiteName {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\aximsoft-dhivaagarb\\Desktop\\CustomFiles\\EDP-API-suite.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);

            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            System.out.print("[ ");
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Iterate over cells in the row
                Iterator<Cell> cellIterator = row.iterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    System.out.print(cell.getStringCellValue() + ", ");
                }
            }
            System.out.print(" ]");

            workbook.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
