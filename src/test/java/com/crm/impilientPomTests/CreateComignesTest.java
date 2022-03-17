package com.crm.impilientPomTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.CreateComignTests.CreateCampaignTest;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CampignesPage;
import com.crm.ObjectRepository.CreateCamgianInfoPage;
import com.crm.ObjectRepository.CreateCampaignpage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateComignesTest {
	@Test
	public void CreateComgignPage() throws Throwable {
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
		
		String camgianName = eLib.readDataFromExcel("Sheet3", 1, 2);
		
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
		wLib.waitForPageLoad
		(driver);
		driver.get(URL);
		//step3:login to app

		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		//navigate to contact link
		HomePage hp=new HomePage(driver);
		hp.clickonmoreLink();
		hp.clickonComignesLink();
		//click on createComign link
		CampignesPage cp=new CampignesPage(driver);
		cp.clickOncreateComImg();
		//click on createcamianpage
		CreateCampaignpage ccp=new CreateCampaignpage(driver);
	ccp.createNewCamign(camgianName);
		//verification
		CreateCamgianInfoPage cip=new CreateCamgianInfoPage(driver);
		 String actcamiganname = cip.createCamgianInfo();
			if(actcamiganname.contains(actcamiganname))	 
			{
				System.out.println(camgianName+"------->data verified");
			}
			else {
				System.out.println("data is invalid");
			}
		 
	

//logout
		hp.SignOutOfApp(driver);
}
}

		
		


		
	
	
	
	
	
	


