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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLeadAndDeleteTest {
	
		@Test
		public void CreateLeadAndDeleteTest() throws Throwable
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
	
				
				
	

				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				Alert a = driver.switchTo().alert();
				String text=a.getText();
				a.accept();
				System.out.println(text);
				driver.findElement(By.name("selected_id")).click();
				
				driver.findElement(By.xpath("//input[@value='Delete']")).click();
				Alert a1 = driver.switchTo().alert();
				String text1=a1.getText();
				System.out.println(text1);
				a.accept();
				
				
				
		}

	}
