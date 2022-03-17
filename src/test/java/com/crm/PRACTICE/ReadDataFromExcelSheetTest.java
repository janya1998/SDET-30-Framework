package com.crm.PRACTICE;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;



public class ReadDataFromExcelSheetTest {
	@Test
	public void readthedatafromexcel() throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\DATA.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		
		Row r = sh.getRow(0);
		Cell c = r.getCell(0);
		String value = c.getStringCellValue();
	System.out.println(value);		
		
	}

}
	


