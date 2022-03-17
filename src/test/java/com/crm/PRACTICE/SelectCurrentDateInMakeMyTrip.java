package com.crm.PRACTICE;



import java.util.Date;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class SelectCurrentDateInMakeMyTrip  {
	@Test
	public void CurrentDateIntoGobibo() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");
	
	Date date = new Date();
	String d1 = date.toString();
	
	String[] date1 = d1.split(" ");
	
	String day = date1[1];
	String monandyear = date1[2];
	//String year = date1[5];
	String time = date1[3].replace(":","-");
	String dataformate = day+"-"+monandyear+"-"+time;
	System.out.println(dataformate);
	
	
	Actions actions=new Actions(driver);
	actions.moveByOffset(10, 10).click().perform();
	
	driver.findElement(By.xpath("//span[text()='From']")).click();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("pune");
	driver.findElement(By.xpath("//p[text()='Pune, India']")).click();
	
	driver.findElement(By.xpath("//span[text()='To']")).click();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("thiland");
	driver.findElement(By.xpath("//p[text()='Bangkok, Thailand']")).click();
	
	driver.findElement(By.xpath("//a[text()='Search']")).click();
	
	
	
	//driver.findElement(By.xpath("//span[text()='DEPARTURE']"));
	driver.findElement(By.xpath("//div[@aria-label='"+dataformate+"']")).click();
	//driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today']")).click();
	
	
	
	
	
	
	
	
	
		
	}

}
