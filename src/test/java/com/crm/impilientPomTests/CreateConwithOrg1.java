
package com.crm.impilientPomTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateInfoPage;
import com.crm.ObjectRepository.CreateOrgnaizationPage1;
import com.crm.ObjectRepository.CreateOrgnizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrgnaizationInfoPage;


public class CreateConwithOrg1 {
	
	


	@Test
	public void CreateConwithOrg1() throws Throwable
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
		
		String lastName = eLib.readDataFromExcel("Sheet2", 1, 2);
		String orgName = eLib.readDataFromExcel("Sheet2", 4, 3);
	
		
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
SoftAssert sa=new SoftAssert();
HomePage hp=new HomePage(driver);
hp.ClickContactLink();
String expData = "Contacts";
String actData = driver.findElement(By.linkText("Contacts")).getText();
sa.assertEquals(expData, actData);


ContactPage cp=new ContactPage(driver);
cp.clickOnCreateContactImg();
String expHeader = "Creating New Contact";
String actHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
sa.assertEquals(expHeader, actHeader);

//step6: click on create contact btn
CreateContactPage ccp=new CreateContactPage(driver);
ccp.createNewContact(driver, lastName, actHeader);
//step6:verification
CreateInfoPage cip=new CreateInfoPage(driver);

String actContactName=cip.contactNameInfo();
/*if(actContactName.contains(lastName))
{
	System.out.println(lastName+"---->data verified");
	
}
else
{
	System.out.println("invalid data");
}*/
Reporter.log(actContactName+"org created",true);
sa.assertTrue(actContactName.contains("abc")); 
sa.assertAll();






	}
}
	





	
			
		
			

	
	
	
