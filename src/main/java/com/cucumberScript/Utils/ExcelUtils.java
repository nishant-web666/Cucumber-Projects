package com.cucumberScript.Utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    XSSFWorkbook workbook = null;
    FileInputStream fis = null;
    XSSFSheet sheet = null;
    XSSFRow headerRow = null;
    XSSFRow row = null;
    XSSFCell cell = null;
    int colNum = 0;
    int rowCount = 0;
    List<String> columnData = new ArrayList<>();

    public ExcelUtils ( String filePath){
        try {
            fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            fis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> readExcelData(String sheetName, String columnName){
        sheet = workbook.getSheet(sheetName);
        headerRow = sheet.getRow(1);
        rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        for (int i = 0; i <= rowCount ; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < headerRow.getLastCellNum() ; j++) {
                if (headerRow.getCell(j).getStringCellValue().trim().equals(columnName.trim()))
                    colNum = j;
            }
            cell = row.getCell(colNum);
            String value = cell.getStringCellValue();
            columnData.add(value);
        }
        return columnData;
    }
}
