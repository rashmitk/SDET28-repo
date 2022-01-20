package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataFromExcelTest {
// adding data to excel sheet
	public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/Data03.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	
	Sheet sheet = workbook.getSheet("Sheet1");
	Row row = sheet.getRow(2);
	row.createCell(2).setCellValue("IBM");
	
	FileOutputStream fos = new FileOutputStream("./src/test/resources/Data03.xlsx");
	workbook.write(fos);
	workbook.close();

	}

}
