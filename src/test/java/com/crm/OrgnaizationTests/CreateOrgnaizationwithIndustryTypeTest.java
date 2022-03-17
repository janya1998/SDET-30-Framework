package com.crm.OrgnaizationTests;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateOrgnaizationwithIndustryTypeTest {
	
@Test
	public void  CreateOrgnaizationwithIndustryType() throws Throwable
	{
	/* step1: read all neccessaary data*/
		//read data from property file
		/*generate random number*/
		Random ran = new Random();
		int random = ran.nextInt(500);
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		//read the data from excel sheet
		FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Org");
		Row ro = sh.getRow(3);
		Cell cel = ro.getCell(2);
		String orgname = cel.getStringCellValue();
		Cell cel1 = ro.getCell(3);
		String Indtype = cel1.getStringCellValue();
		
		
		/* step2: launch the browser*/
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		/*step 3: login to application */
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		/*naviagate the organization link*/
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 /*enter mandatory fields*/
		driver.findElement(By.name("accountname")).sendKeys(orgname+" "+random);
		/*choose the data healthcare industry from dropdown and save*/
		WebElement ele=driver.findElement(By.name("industry"));
		Select s=new Select(ele);
		s.selectByValue(Indtype);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		/* logout the application */
		
		/*WebElement e
	=driver.findElement(By.xpath("//img[@src=themes/softed/images/user.PNG]"));
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		/*Step 8: close the browser*/
		driver.quit();
	}
}
		
		
		
