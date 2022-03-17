package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectAnyDataFromCalenderTest {
	@Test
	public void calender()
	{
		//String data="13";
		//String monthAndYear="March 2022 ";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.makemytrip.com");
		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String dateXpath = "//div[text()='March 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='12']";
		driver.findElement(By.xpath(dateXpath)).click();
		
		 
		
	}

}
