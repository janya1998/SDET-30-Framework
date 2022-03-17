package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//create object of all the utilities
	public DatabaseUtility dbLib=new DatabaseUtility();
	public ExcelFileUtility eLib=new ExcelFileUtility();
	public JavaUtility jLib=new JavaUtility();
	public PropertyFileUtility pLib=new PropertyFileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver=null;
	 public static WebDriver sDriver;
	
	
	@BeforeSuite(groups = {"RegressionSuite" ,"smokeSuite"})
	
		public void connectDataBase() {
			//dbLib.connectToDb();
			Reporter.log("====database connection sucessfull===",true);
		}
	@BeforeClass(groups =  {"RegressionSuite" ,"smokeSuite"})
	//@Parameters("browser")
	//@BeforeTest
	// for parallel execution we add parameterized
	public void lunchTheBrowser() throws Throwable {
		//read the data from property
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		
	//CREATE the runtime polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
					
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		  sDriver = driver; 
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		Reporter.log("====browser launch sucessful===",true);
		
	}
	@BeforeMethod(groups =  {"RegressionSuite" ,"smokeSuite"})
	public void login() throws Throwable {
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("====LOGIN sucessful===",true);
	}
	
	@AfterMethod(groups= {"RegressionSuite" ,"smokeSuite"})
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.SignOutOfApp(driver);
		Reporter.log("===sucessfually logout====",true);
	}
	@AfterSuite(groups= {"RegressionSuite" ,"smokeSuite"})
	public void closeDb() {
		driver.quit();
		Reporter.log("===database close sucessfull====",true);
	}
	
	
		
		
	
	

}
