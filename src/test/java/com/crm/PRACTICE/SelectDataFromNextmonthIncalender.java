package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectDataFromNextmonthIncalender {
	@Test
	public void calendernextmonth()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.makemytrip.com");
		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String arrowXpath = "//span[@aria-label='Next Month']";
		String dateXpath = "//div[text()='March 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='12']";
		
		
		//driver.findElement(By.xpath(dateXpath)).click();
		for(;;)
		{
			try {
				driver.findElement(By.xpath(dateXpath)).click();
				break;
			}catch (Exception e) {
				driver.findElement(By.xpath(arrowXpath)).click();
				// TODO: handle exception
			}
		}
	}

}
