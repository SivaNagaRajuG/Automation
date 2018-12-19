package com.selenium.infrastructure.datahandler;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelReader implements DataReader {

    private String dataSource;
    private String scenarioName;
    private Map<String , String> data = new HashMap<String , String>();

    /**
     * To get the data source and scenario name
     * @param dataSource
     * @param scenarioName
     */
    public ExcelReader(String dataSource, String scenarioName)
    {
        this.dataSource = dataSource;
        this.scenarioName = scenarioName;

    }

    /**
     * Method to create the data record in hash map
     */
    public void generateDataRecord() throws Exception {

        FileInputStream fileInputStream = null;
        XSSFSheet ExcelWSheet;

        ExcelWSheet = getExcelSheetFromFile();

        DataFormatter dataFormatter = new DataFormatter();
        Row headerRow = ExcelWSheet.getRow(0);

        int currentRow = getRowNumberFromScenarioName(ExcelWSheet);

        if(currentRow != 0) {
            Row row = ExcelWSheet.getRow(currentRow);
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                int cellNr = cell.getColumnIndex();
                String dataKey = headerRow.getCell(cell.getColumnIndex()).getRichStringCellValue().getString();
                if (dataKey != null) {
                    data.put(dataKey, getCellDataAsString(cell));

                }

            }
        }else{
            throw new Exception("The provided scenario name is not present in excel sheet");
        }
    }

    /**
     * Method to get the row number from scenario name
     * @param ExcelWSheet
     * @return
     */
    private int getRowNumberFromScenarioName(XSSFSheet ExcelWSheet) {
        Iterator<Row> rowIterator = ExcelWSheet.rowIterator();

        while (rowIterator.hasNext())
        {
            Row row = rowIterator.next();
            if(row.getCell(0).toString().equalsIgnoreCase(scenarioName) )
            {
                return row.getRowNum();
            }

        }

        return 0;
    }

    /**
     * Method to get the Excel sheet from file
     * @return
     */
    private  XSSFSheet getExcelSheetFromFile() {
        FileInputStream fileInputStream = null;
        XSSFWorkbook ExcelWBook = null;
        XSSFSheet ExcelWSheet = null;
        String sSheetName = null;
        int rowCount = 0;

        try {

            fileInputStream = new FileInputStream(new File(dataSource));

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        try {
            ExcelWBook =  new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {

            e.printStackTrace();
        }
        if (sSheetName == null) ExcelWSheet = ExcelWBook.getSheetAt(0);
        else  ExcelWSheet = ExcelWBook.getSheet(sSheetName);

        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ExcelWSheet;
    }

    /**
     * Method to return all the cell data as string
     * @param cell
     * @return
     */
    private String getCellDataAsString(Cell cell) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    /**
     * Method to get the required data
     * @param name
     * @return
     */
    public String getData(String name) {
        return data.get(name);
    }




}