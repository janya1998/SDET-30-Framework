package com.crm.LeadsTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLeadDataTest {
	@Test
	public void CreateLeadData() throws Throwable
	{
	/*generate random number*/
	Random ran = new Random();
	int random = ran.nextInt(500);

	//Read the data from all necessary files
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties pObj = new Properties();
			pObj.load(fis);
			String BROWSER = pObj.getProperty("browser");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("username");
			String PASSWORD = pObj.getProperty("password");
			/* read data from excel sheet*/
			FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet("sou1");
			Row ro = sh.getRow(1);
			Cell cel = ro.getCell(0);
			String FirstName = cel.getStringCellValue();
			String fn= FirstName+" "+random;
			
	Cell ce = ro.getCell(1);
			String lastname= ce.getStringCellValue();
			String ln=lastname+""+random;
	Cell cel2=ro.getCell(2);
	String company= cel2.getStringCellValue();
	String cpname=company+""+random;
	Cell cel3=ro.getCell(3);
	String title= cel3.getStringCellValue();
	String titlename=company+""+random;
	Cell cel4=ro.getCell(4);
	double annualfee= cel4.getNumericCellValue();
	
	Cell cel5=ro.getCell(5);
	double noofemp= cel5.getNumericCellValue();
	
	Cell cel6=ro.getCell(6);
	String secmail= cel6.getStringCellValue();
	String secondrymail=secmail+""+random;
	Cell cel7 = ro.getCell(7);
	double phone= cel7.getNumericCellValue();
	Cell cel8 = ro.getCell(8);
	double mobile = cel8.getNumericCellValue();
	Cell cel9 = ro.getCell(9);
	double fax = cel9.getNumericCellValue();
	Cell cel10=ro.getCell(10);
	String email= cel10.getStringCellValue();
	String emailename=email+""+random;
	
	Cell cel11=ro.getCell(11);
	String website= cel11.getStringCellValue();
	String websitename=website+""+random;
	
	Cell cel12=ro.getCell(12);
	String postal= cel12.getStringCellValue();
	String streetname=postal+""+random;
	
	Cell cel13=ro.getCell(13);
	double postalcode= cel13.getNumericCellValue();
	
	Cell cel14=ro.getCell(14);
	String country= cel14.getStringCellValue();
	String countryname=country+""+random;

	Cell cel15=ro.getCell(15);
	double pobox=cel15.getNumericCellValue();
	
	
	Cell cel16=ro.getCell(16);
	String state=cel16.getStringCellValue();
	
	String statename=state+""+random;
	Cell cel17=ro.getCell(17);
	String city=cel17.getStringCellValue();
	String  cityname=city+""+random;
	
	
	
	Cell cel18=ro.getCell(18);
	String description=cel18.getStringCellValue();
	
	String descriptionname=description+""+random;
	
	/*Step 2: launch the browser*/
			WebDriver driver=null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("Firefox"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("invalid browser");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);
			/*Step 3: login to application*/
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			
			
			/*click on lead*/
			driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']")).click();
			driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
			/* enter valid inputs to lead create page*/
			WebElement ele = driver.findElement(By.name("salutationtype"));
			Select sc=new Select(ele);
			sc.selectByVisibleText("Mr.");
			driver.findElement(By.name("firstname")).sendKeys(fn);
			driver.findElement(By.name("lastname")).sendKeys(ln);
			driver.findElement(By.name("company")).sendKeys(cpname);
			driver.findElement(By.id("designation")).sendKeys(titlename);
			WebElement ele1 =driver.findElement(By.name("leadsource"));
			Select sc1=new Select(ele1);
			sc1.selectByVisibleText("Cold Call");
			WebElement ele2= driver.findElement(By.name("industry"));
			Select sc2=new Select(ele2);
			sc2.selectByVisibleText("Banking");
			
			driver.findElement(By.xpath("//input[@name='annualrevenue']")).sendKeys(Integer.toString((int) annualfee));
			driver.findElement(By.name("noofemployees")).sendKeys(Integer.toString((int)noofemp));
			driver.findElement(By.name("secondaryemail")).sendKeys(secondrymail);
			/*driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
			driver.findElement(By.name("phone")).sendKeys(Integer.toString((int)phone));
			driver.findElement(By.name("mobile")).sendKeys(Integer.toString((int)mobile));
			driver.findElement(By.name("fax")).sendKeys(Integer.toString((int)fax));
			driver.findElement(By.name("email")).sendKeys(emailename);
			driver.findElement(By.name("website")).sendKeys(websitename);
			WebElement ele3 = driver.findElement(By.name("leadstatus"));
			Select sc3=new Select(ele3);
			sc3.selectByVisibleText("Contact in Future");
			WebElement ele4 = driver.findElement(By.name("rating"));
			Select sc4=new Select(ele4);
			sc4.selectByVisibleText("Active");
			driver.findElement(By.name("lane")).sendKeys(streetname);
			driver.findElement(By.name("code")).sendKeys(Integer.toString((int)postalcode));
			driver.findElement(By.name("country")).sendKeys(countryname);
			driver.findElement(By.name("pobox")).sendKeys(Integer.toString((int)pobox));
			driver.findElement(By.name("city")).sendKeys(cityname);
			driver.findElement(By.name("state")).sendKeys(state);
			driver.findElement(By.name("description")).sendKeys(descriptionname);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			

			
			
			
			
			
			/*Step 11: logout and close the browser*/
			/*WebElement element1= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act1 = new Actions(driver);
			act1.(element1).perform();*/
			
			//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			//driver.quit();
			
			
			
			
		
					
	}
			
			
			

}
