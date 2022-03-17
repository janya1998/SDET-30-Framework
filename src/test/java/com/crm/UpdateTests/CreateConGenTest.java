package com.crm.UpdateTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrgnaizationPage1;
import com.crm.ObjectRepository.CreateOrgnizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrgnaizationInfoPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateConGenTest {
	@Test
	public void CreateConGenTest() throws Throwable
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
		
		 String OrgName=eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
		 String indType=eLib.readDataFromExcel("org", 3, 3)+"_"+jLib.getRandomNumber();
		 String type=eLib.readDataFromExcel("org", 3, 4)+"_"+jLib.getRandomNumber();
		 
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
			
			/*step 3: login to application */
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			//* step 4:navigate to orgnaization page
			HomePage hp=new HomePage(driver);
			hp.ClickOrgLink();
			//step 5:click on oranization btn*/
			CreateOrgnizationPage op=new CreateOrgnizationPage(driver);
			op.clickOnCreateOrgImg();
			/*step 6:enter mandatroy fields and save */
			CreateOrgnaizationPage1 cop=new CreateOrgnaizationPage1(driver);
			
		
			
			cop.createNewOrg(OrgName);
			/* step 7:verification*/
			OrgnaizationInfoPage oip=new OrgnaizationInfoPage(driver);
			String actOrgName = oip.OrgNameInfo();
			if(actOrgName.contains(OrgName))
			{
				System.out.println(actOrgName+"--->data verified");
			}
			else
			{
				System.out.println("data invalid");
			}
			/* step 7:logout the application*/
			hp.SignOutOfApp(driver);
			/*step 8: close the browser*/
			driver.quit();
			}
			
			  
			}

	
	
	
	
