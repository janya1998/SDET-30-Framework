package com.crm.impilientPomTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductsPage;

public class CreateProductTest {
	@Test
public void CreateProduct() throws Throwable {
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
		
		String pdoductName = eLib.readDataFromExcel("Sheet2", 1, 2);
		
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
hp.clickOnProductLink();
//product page
ProductsPage pr=new ProductsPage(driver);
pr.clickoncreatePdtImg();
//click on ctreateproduct link
CreateProductPage cpr=new CreateProductPage(driver);
cpr.createNewOrg(pdoductName);

//data verified
ProductInfoPage pip=new ProductInfoPage(driver);
{
	String actpdoductName = pip.productNameInfo();
	if(actpdoductName.contains(pdoductName))
	{
		System.out.println(pdoductName+"------->data verified");
	}
	else
	{
		System.out.println(" invalid data");
	}
}
//logout
hp.SignOutOfApp(driver);

		
		
	}
}
