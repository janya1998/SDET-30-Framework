package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataintoExcelSheetTest {
	@Test
	public void WriteDataintoExcelSheet() throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\DATA.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		
		Row r = sh.getRow(0);
		Cell ce = r.createCell(9);
		ce.setCellValue("tc_1000");
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\DATA.xlsx");
		wb.write(fos);
	}

}
