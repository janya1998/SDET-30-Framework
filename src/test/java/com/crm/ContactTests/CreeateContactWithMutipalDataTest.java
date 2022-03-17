package com.crm.ContactTests;

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
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrgnaizationPage1;
import com.crm.ObjectRepository.CreateOrgnizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrgnaizationInfoPage;

public class CreeateContactWithMutipalDataTest {
	PropertyFileUtility pLib=new PropertyFileUtility();
	ExcelFileUtility   eLib=new ExcelFileUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	JavaUtility jLib=new JavaUtility();

	@Test(dataProvider = "OrgTestdata")
	public void CreateOrgWithMulipleData(String lastname) throws Throwable
	{
		//read the data
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("uername");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		  String lastname1 = lastname;
		
		
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
		hp.ClickContactLink();
		Reporter.log("navigate to org link",true);
		
		//create org
		ContactPage op=new ContactPage(driver);
		op.clickOnCreateContactImg();
		Reporter.log("click on create org link",true);
		
		//create new org
		CreateContactPage cop=new CreateContactPage(driver);
		cop.creatNewContact(lastname);
		
		
		//validate
		OrgnaizationInfoPage oip=new OrgnaizationInfoPage(driver);
		String actHeader = oip.OrgNameInfo();
		
		if(actHeader.contains(lastname)) {
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
	Object[][] data1=eLib.readmultipleDataFromExcel("ContMultipalData");
	return data1;
}
	

}
