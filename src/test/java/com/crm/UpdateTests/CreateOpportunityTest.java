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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunityTest {
	@Test
	public void CreateOpportunity() throws Throwable
	{
		//Step1 Read all necessary data
	PropertyFileUtility pLib=new PropertyFileUtility();
	JavaUtility jLib=new JavaUtility();
	ExcelFileUtility eLib=new ExcelFileUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	
	//read the necceary data
	String BROWSER = pLib.readDataFromPropertyFile("browser");
	String URL = pLib.readDataFromPropertyFile("url");
	String USERNAME = pLib.readDataFromPropertyFile("username");
	String PASSWORD = pLib.readDataFromPropertyFile("password");
	
	/* lunch the browser*/
	String ContactName=eLib.readDataFromExcel("Sheet1", 1, 2)+"_"+jLib.getRandomNumber();
	String CampName = eLib.readDataFromExcel("Sheet1", 1, 3)+"_"+jLib.getRandomNumber();
	String oopName = eLib.readDataFromExcel("Sheet1", 1, 4)+"_"+jLib.getRandomNumber();
	String RepValue = eLib.readDataFromExcel("Sheet1",1, 5)+"_"+jLib.getRandomNumber();
	String Leadrs = eLib.readDataFromExcel("Sheet1",1, 6)+"_"+jLib.getRandomNumber();
	//step4: lunch the browser
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("invalid browser");
	}
	
	wLib.maximizeWindow(driver);
	wLib.waitForPageLoad(driver);
	driver.get(URL);
	
	/* step 3:login to application*/
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	/* step 4:navigate to contact link*/
	driver.findElement(By.xpath("//a[.='Contacts']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(ContactName);
	/*step 5: save the contact*/
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String conHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(conHeader.contains(ContactName))
	{
		System.out.println(conHeader);
		System.out.println("contact is created");
	}
	else
	{
		System.out.println(conHeader);
		System.out.println("contact is not created");
	}
	/*step6: navigate to comgian link*/
	driver.findElement(By.xpath("//a[.='More']")).click();
	driver.findElement(By.name("Campaigns")).click();
	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	driver.findElement(By.name("campaignname")).sendKeys(CampName);
	driver.findElement(By.name("button")).click();
	String camignHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(camignHeader.contains(CampName))
	{
		System.out.println(camignHeader);
		System.out.println("camgian is created");
	}
	else
	
	{
		System.out.println(camignHeader);
		System.out.println("camgian is not  created");
	}
	
	//step to navigation to opprtunitirs
	driver.findElement(By.linkText("Opportunities")).click();
	driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
	driver.findElement(By.name("potentialname")).sendKeys(oopName);
	WebElement ele = driver.findElement(By.id("related_to_type"));
	wLib.select(RepValue,ele );
	
	

	
	

				
		
		
	}
}

	