package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class DynamicWebTablecheckBoxPractice extends BaseClass{
@Test
public void DynamicWebTablecheckBoxPractice() {
	//navigate to contack link
	HomePage hp=new HomePage(driver);
	hp.ClickContactLink();
	
	List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
	for(WebElement e:ele)
	{
		e.click();
	}
}

}
