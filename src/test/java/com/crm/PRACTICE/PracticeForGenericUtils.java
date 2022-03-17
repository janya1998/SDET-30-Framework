package com.crm.PRACTICE;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticeForGenericUtils {
	@Test
	
	public void practice() throws Throwable
	{
		JavaUtility jlib=new JavaUtility();
		int ran=jlib.getRandomNumber();
		String dat = jlib.getSystemDateInForamte();
		String date = jlib.getSystemDate();
		System.out.println(ran+date);
		System.out.println(dat);
		
		PropertyFileUtility plib=new PropertyFileUtility();
		String brows = plib.readDataFromPropertyFile("browser");
		System.out.println(brows);
		String url = plib.readDataFromPropertyFile("url");
		System.out.println(url);
		String username = plib.readDataFromPropertyFile("username");
		System.out.println(username);
		String password= plib.readDataFromPropertyFile("password");
		System.out.println(password);
		
		
		ExcelFileUtility elib=new ExcelFileUtility();
		String value=elib.readDataFromExcel("Org",1,2);
		System.out.println(value);
	
		
		
		
		
		
	}

}
