package com.crm.GenericLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;


public class ListnerImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"---->passed");
	
	}

	public void onTestFailure(ITestResult result) 
	{
		String path=null;
		
		String MethodName = result.getMethod().getMethodName();
		
		
		//Step 1: Configure screenshot name
				String screenshotName = MethodName+new JavaUtility().getSystemDateInForamte();
				System.out.println(screenshotName);
				
				//Step 2: using screenshot method from webDriver Utility
				try {
					
					path=new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenshotName);
					
			
					//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
					//File src = eDriver.getScreenshotAs(OutputType.FILE);
					//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
					//path =  ".\\Screenshot\\"+screenshotName+".png";
					//File dst = new File(path);
					//Files.copy(src, dst);
					
				} 
				catch (Throwable e) 
				{
				
					e.printStackTrace();
				}
				test.log(Status.FAIL,MethodName+"......>failed");
				//it will capture the exception and log in the report
				test.log(Status.FAIL,result.getThrowable());
				test.addScreenCaptureFromPath(path);
			
			}


		
	

	public void onTestSkipped(ITestResult result) 
	{
		
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName + "--- TestScript Skipped");
		//it will capture the exception and log it in the report
		test.log(Status.SKIP,MethodName+"......>skipped"); 
		//it will capture the exception and log it in the report
		test.log(Status.SKIP,result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	

	public void onStart(ITestContext context) {
		//excecution will start here
		/*configure the report*/
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDateInForamte()+".html");
		htmlReport.config().setDocumentTitle("SDET-30 Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Selenium Exceution Report");
		
		report =new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-url", "http://localhost:8080");
		report.setSystemInfo("Reporter Name", "soujanya");
		
	}

	
	public void onFinish(ITestContext context) 
	{
		//consolidate all the parameter and generate the report
		report.flush();
	
		
	}

}
