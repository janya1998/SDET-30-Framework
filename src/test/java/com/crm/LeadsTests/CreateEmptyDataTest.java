package com.crm.LeadsTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateEmptyDataTest {
	@Test
	public void CreateEmptyData() throws Throwable
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
			driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
			
			/* enter valid inputs to lead create page*/
			WebElement ele = driver.findElement(By.name("salutationtype"));
			Select sc=new Select(ele);
			sc.selectByVisibleText("Mr.");
			driver.findElement(By.name("firstname"));
			WebElement el = driver.findElement(By.name("lastname"));
			/*String text=el.getText();
			System.out.println(text);*/
			driver.findElement(By.name("company"));
			driver.findElement(By.id("designation"));
			WebElement ele1 =driver.findElement(By.name("leadsource"));
			Select sc1=new Select(ele1);
			sc1.selectByVisibleText("Cold Call");
			WebElement ele2= driver.findElement(By.name("industry"));
			Select sc2=new Select(ele2);
			sc2.selectByVisibleText("Banking");
			driver.findElement(By.xpath("//input[@name='annualrevenue']"));
			driver.findElement(By.name("noofemployees"));
			driver.findElement(By.name("secondaryemail"));
			/*driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
			driver.findElement(By.name("phone"));
			driver.findElement(By.name("mobile"));
			driver.findElement(By.name("fax"));
			driver.findElement(By.name("email"));
			driver.findElement(By.name("website"));
			WebElement ele3 = driver.findElement(By.name("leadstatus"));
			Select sc3=new Select(ele3);
			sc3.selectByVisibleText("Contact in Future");
			WebElement ele4 = driver.findElement(By.name("rating"));
			Select sc4=new Select(ele4);
			sc4.selectByVisibleText("Active");
			driver.findElement(By.name("lane"));
			driver.findElement(By.name("code"));
			driver.findElement(By.name("country"));
			driver.findElement(By.name("pobox"));
			driver.findElement(By.name("city"));
			driver.findElement(By.name("state"));
			driver.findElement(By.name("description"));
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			Alert a = driver.switchTo().alert();
			String text=a.getText();
			System.out.println(text);
		
			
	}
	

}
