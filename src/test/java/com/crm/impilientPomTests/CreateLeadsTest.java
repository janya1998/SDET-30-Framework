package com.crm.impilientPomTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateLeadsInfoPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LeadsPage;
import com.crm.ObjectRepository.LoginPage;

public class CreateLeadsTest {
	@Test
	public void CreateLeads() throws Throwable {
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
		
		String lastName = eLib.readDataFromExcel("sou1", 1, 1);
		String companyName = eLib.readDataFromExcel("sou1", 1, 2);
 
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
	
	
//step3:login to app

LoginPage lp=new LoginPage(driver);
lp.loginToApp(USERNAME, PASSWORD);
//navigate to contact link
HomePage hp=new HomePage(driver);
hp.clickONleadsLink();
//leadspage
LeadsPage lr=new LeadsPage(driver);
lr.clickOnLeadsCreateImg();
//data verified
CreateLeadsInfoPage lil=new CreateLeadsInfoPage(driver);
String actlastName = lil.createLeadsInfo();
if(actlastName.contains(lastName))
{
	
System.out.println(lastName+"------->data verified");
}
else
{
	System.out.println("invalid data");
}

//logout
		hp.SignOutOfApp(driver);
}

	}



	


