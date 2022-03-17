package com.crm.UpdateTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrganizationGenTest {
	@Test
	public void CreateOrganizationGen() throws Throwable
	{
		
	
	/*read data*/
	PropertyFileUtility pLib = new PropertyFileUtility();
	JavaUtility jLib = new JavaUtility();
	ExcelFileUtility eLib = new ExcelFileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	
	/*Step 1: read all neccessary data*/
	String BROWSER = pLib.readDataFromPropertyFile("browser");
	String URL = pLib.readDataFromPropertyFile("url");
	String USERNAME = pLib.readDataFromPropertyFile("username");
	String PASSWORD = pLib.readDataFromPropertyFile("password");
	
	String orgnam=eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("Firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
		
	}
	else
	{
		System.out.println("invalid browser");
	}
	
	wLib.maximizeWindow(driver);
	wLib.waitForPageLoad(driver);
	driver.get(URL);
	
	
	/*Step 4: Navigate to Organizations Link*/
	driver.findElement(By.linkText("Organizations")).click();
	
	/*Step 5: click on create org swanization btn*/
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	/*Step 6: enter mandatory fields and save*/
	driver.findElement(By.name("accountname")).sendKeys(orgnam);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	//wLib.mouseHover(driver, ele);
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	/*Step 8: close the browser*/
	driver.quit();
	}
	

}
