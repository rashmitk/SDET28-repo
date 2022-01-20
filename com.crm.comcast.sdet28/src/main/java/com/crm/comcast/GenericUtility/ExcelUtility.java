package com.crm.comcast.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * Get data from excel sheet
 * @author sarav
 *
 */

public class ExcelUtility {
	/**
	 * This method will return String value from Excel sheet
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */

	public String getStringCellData(String sheetname,int rowNo,int cellNo ) throws Throwable {
	FileInputStream file = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
	Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet = workbook.getSheet(sheetname);
	Row row = sheet.getRow(rowNo);
	Cell cell = row.getCell(cellNo);
	return cell.getStringCellValue();
	}
	/**
	 * This method will return Numberic value from Excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	
	public double getNumbericalData(String sheetName,int rowNo,int cellNo) throws Throwable {
	FileInputStream file = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
	Workbook workbook = WorkbookFactory.create(file);
	return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();	
	}
	/**
	 * This method will return multiple dat from excel sheet
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	
	public Object[][] getMultipleData(String sheetname) throws Throwable {
	FileInputStream file = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
	Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet = workbook.getSheet(sheetname);
	int rowNO = sheet.getLastRowNum();
	short cellNo = sheet.getRow(0).getLastCellNum();
	Object[][] data = new Object[rowNO][cellNo];
	for(int i=0;i<rowNO;i++) {
		for(int j=0;j<cellNo;j++) {
			data[i][j]=sheet.getRow(i).getCell(j).toString();
		}
	}
	return data;
	}
	/**
	 * This method for write data into the excel sheet
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws Throwable
	 */
	
	public void writeDataintoExcel(String sheetname,int rowNo,int cellNo,String value) throws Throwable {
	FileInputStream readfile = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
	Workbook workbook = WorkbookFactory.create(readfile);
	workbook.createSheet(sheetname).createRow(rowNo).createCell(cellNo).setCellValue(value);
	
	FileOutputStream writefile = new FileOutputStream(IPathConstants.EXCEL_FILEPATH);
	workbook.write(writefile);
	
	workbook.close();
	
		
	}

}
