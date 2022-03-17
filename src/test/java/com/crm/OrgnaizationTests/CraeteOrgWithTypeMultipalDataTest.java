package com.crm.OrgnaizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
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

public class CraeteOrgWithTypeMultipalDataTest {
	PropertyFileUtility pLib=new PropertyFileUtility();
	ExcelFileUtility   eLib=new ExcelFileUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	JavaUtility jLib=new JavaUtility();

	@Test(dataProvider = "OrgTestdata")
	public void CreateOrgWithMulipleData(String orgName,String indType,String typename) throws Throwable
	{
		//read the data
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("uername");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		String orgname = orgName+jLib.getRandomNumber();
		
		
		//lunch the browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		//login the application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("login sucessful",true);
		
		//navigate to organization
		HomePage hp=new HomePage(driver);
		hp.ClickOrgLink();
		Reporter.log("navigate to org link",true);
		
		//create org
		CreateOrgnizationPage op=new CreateOrgnizationPage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("click on create org link",true);
		
		//create new org
		CreateOrgnaizationPage1 cop=new CreateOrgnaizationPage1(driver);
		cop.createNewOrg(orgname, indType, typename);
	
		
		//validate
		OrgnaizationInfoPage oip=new OrgnaizationInfoPage(driver);
		String actHeader = oip.OrgNameInfo();
		
		if(actHeader.contains(orgname)) {
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
		Reporter.log("verification sucessful",true);
		//logout
		hp.SignOutOfApp(driver);
		driver.quit();
	}
		

@DataProvider(name="OrgTestdata")
public Object[][] getData() throws Throwable
{
	Object[][] data1=eLib.readmultipleDataFromExcel("orgMultipalData2");
	return data1;
}


}	
		
		
	    
	    
		


