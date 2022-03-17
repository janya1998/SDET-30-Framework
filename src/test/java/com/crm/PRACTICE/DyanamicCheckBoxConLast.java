package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;
import com.mysql.cj.jdbc.Driver;

public class DyanamicCheckBoxConLast extends BaseClass{
	@Test
	public void DyanamicCheckBoxConLast()
	{
		//navigate to contack link
		HomePage hp=new HomePage(driver);
		hp.ClickContactLink();
		
		 List<WebElement> ele1 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]"));
		
		
		  	
		   for (int i=ele1.size()-1;i>=0;i--)
		        {
		WebElement we = ele1.get(i);
		    
		    	// if (!we.isSelected())
			//{
		    		 //JavascriptExecutor js=(JavascriptExecutor) driver;
			       		//js.executeScript("window.scrollBy(0,500)");
		            we.click();
		            break;
		           
	                  
			//}
		    	 
	    }
	}
}
