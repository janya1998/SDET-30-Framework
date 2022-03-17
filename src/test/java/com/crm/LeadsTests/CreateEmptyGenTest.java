package com.crm.LeadsTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateEmptyGenTest {
	@Test
	
	public void CreateEmptyGen() throws Throwable {
	
	
			
		
				
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
				wLib.maximizeWindow(driver);
				wLib.waitForPageLoad(driver);
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
				wLib.select("Mr.", ele);
				/*Select sc=new Select(ele);
				sc.selectByVisibleText("Mr.");*/
				driver.findElement(By.name("firstname"));
				WebElement el = driver.findElement(By.name("lastname"));
				/*String text=el.getText();
				System.out.println(text);*/
				driver.findElement(By.name("company"));
				driver.findElement(By.id("designation"));
				WebElement ele1 =driver.findElement(By.name("leadsource"));
				wLib.select("Banking", ele1);
				/*Select sc1=new Select(ele1);
				sc1.selectByVisibleText("Cold Call");
				WebElement ele2= driver.findElement(By.name("industry"));
				Select sc2=new Select(ele2);
				sc2.selectByVisibleText("Banking");*/
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
				wLib.select("Contact in Future", ele3);
				/*Select sc3=new Select(ele3);
				sc3.selectByVisibleText("Contact in Future");*/
				WebElement ele4 = driver.findElement(By.name("rating"));
				wLib.select("Active", ele4);
				/*Select sc4=new Select(ele4);
				sc4.selectByVisibleText("Active");*/
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



		