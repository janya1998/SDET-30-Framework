package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author User
 *
 */
 
 

public class ExcelFileUtility {
	/**
	 * this method consistes read data from excel sheet and return value when sheetname
	 * row no and cell number is specofied
	 * @param sheetname
	 * @param rowno
	 * @param CelNO
	 * @return
	 * @throws Throwable 
	 */
	public String readDataFromExcel(String Sheetname,int rowNo,int CelNO) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		Row ro = sh.getRow(rowNo);
		Cell cel = ro.getCell(CelNO);
		String value = cel.getStringCellValue();
		return value;	
		
	}
	
	

/**
 * @param sheetname
 * @param rowno
 * @param CelNO
 * @throws Throwable 
 * @throws Throwable 
 * @
 */

public void writeDataFromExcel(String Sheetname, int rowNo, int CelNO , String value) throws Throwable
{

	FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(Sheetname);
	Row ro = sh.getRow(rowNo);
	Cell cel = ro.createCell(CelNO);
	cel.setCellValue(value);
	FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
	wb.write(fos);
	
}

public int getRowCount(String Sheetname) throws Throwable {
	FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(Sheetname);
	int row = sh.getLastRowNum();
	return row;
	
			
	
}
/**
 * this method will read mulipal data from excel sheet with the help of sheetname
 * and return 2 dimentional  object[][]
 * @param SheetName
 * @return
 * @throws Throwable
 */


public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
{
	FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	int lastRow = sh.getLastRowNum();
	int lastCell = sh.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[lastRow][lastCell];
	
	for(int i = 0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	
	return data;

}
}

	

