package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAssignPractice {
	
	@Test(dataProvider = "getData")
	public void sampleDataProvider(String Name,String model){
		
		System.out.println(Name+"---"+model+"---");
		}
	@DataProvider
	public Object[][] getData(){
		Object[][] obj=new Object[6][2];
		
		obj[0][0]="MI";
		obj[0][1]="13 PRO max";
			
		
		obj[1][0]="iphone";
		obj[1][1]="11 max";
		
		
		obj[2][0]="vivo";
		obj[2][1]="17 max";
		
		
		obj[3][0]="realme";
		obj[3][1]="11 pro max";
		
		
		
		obj[4][0]="nokia";
		obj[4][1]="12 pro  max";
		
		obj[5][0]="china";
		obj[5][1]="10 pro  max";
		
		
		return obj;
		
	}

}


