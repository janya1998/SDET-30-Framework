package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class DynamicFifthCbox extends BaseClass{
	@Test
	
public void DynamicFifthCbox() {

//navigate to contact link		
HomePage hp=new HomePage(driver);
hp.ClickContactLink();

 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[1]")).click();
 
 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[1]/following-sibling::td[9]/a[2]")).click();
 //Alert a=driver.switchTo().alert();
 wLib.acceptAlert(driver);
 //a.accept();



	}
}
