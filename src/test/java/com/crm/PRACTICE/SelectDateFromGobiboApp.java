package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectDateFromGobiboApp {
	@Test
	public void calender() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com");
		

		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("bangalore");
		driver.findElement(By.xpath("//span[@class='autoCompleteTitle ']")).click();
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("delhi");
		driver.findElement(By.xpath("//span[@class='autoCompleteTitle ']")).click();
		
		//driver.findElement(By.xpath("//button[text()='Login/Sign Up']")).click();
		/*
		 * Actions act=new Actions(driver); act.moveByOffset(10, 10).click().perform();
		 */
		//driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("//div[text()='March 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='11']")).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();
		
	}

}
