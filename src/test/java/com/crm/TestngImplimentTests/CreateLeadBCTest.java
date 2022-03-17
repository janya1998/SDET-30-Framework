package com.crm.TestngImplimentTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ListnerImplementationClass;
import com.crm.ObjectRepository.CraeteLeadsPage;
import com.crm.ObjectRepository.CreateInfoPage;
import com.crm.ObjectRepository.CreateOrgnaizationPage1;
import com.crm.ObjectRepository.CreateOrgnizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LeadsPage;
import com.crm.ObjectRepository.OrgnaizationInfoPage;

@Listeners(ListnerImplementationClass.class)
public class CreateLeadBCTest extends BaseClass {
	@Test
public void CreateLeadBC() throws Throwable {
		String lastName = eLib.readDataFromExcel("sou1", 1, 1);
		String companyName = eLib.readDataFromExcel("sou1", 1, 2);
		
		//navigate to lead  link
		SoftAssert sa=new SoftAssert();
		
		HomePage hp=new HomePage(driver);
		hp.clickONleadsLink();
		
		String expData = "Leads";
		String actData = driver.findElement(By.linkText("Leads")).getText();
		sa.assertEquals(expData, actData);
		 
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnLeadsCreateImg();
		
		 String expHeader ="Creating New Lead"; 
		 String actHeader =driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		 sa.assertEquals(actHeader, expHeader);
		
		//navigate to leads create page
		CraeteLeadsPage clp=new CraeteLeadsPage(driver);
		clp.createNewLeads(lastName, companyName);
		
		//navigate to leads create info page
		CreateInfoPage cip=new CreateInfoPage(driver);
		String actlastname = cip.contactNameInfo();
		
		/*if(actlastname.contains(lastName))
		{
			System.out.println(lastName+"--->data verified");
		}
		else
		{
			System.out.println("data invalid");
		}*/
		 Reporter.log(actlastname+"lead created",true);
		 
		  sa.assertTrue(actlastname.contains("shjh")); 
		  sa.assertAll();
		  
	}
		
		

	
@Test(groups =  {"RegressionSuite" ,"smokeSuite"})
public void CreateOrgTest() throws Throwable 
{
String orgname=eLib.readDataFromExcel("Org",1,2)+" "+jLib.getRandomNumber();

//navigate to organization link
SoftAssert sa=new SoftAssert();

HomePage hp=new HomePage(driver);
hp.ClickOrgLink();

String expData = "Organizations";
String actData = driver.findElement(By.linkText("Organizations")).getText();
Assert.assertEquals(expData, actData);

CreateOrgnizationPage cp=new CreateOrgnizationPage(driver);
cp.clickOnCreateOrgImg();

 String expHeader ="Creating New Organization"; 
 String actHeader =driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
 sa.assertEquals(actHeader, actHeader);
 
	
/*Step 5: click on create org swanization btn*/
CreateOrgnaizationPage1 ccp=new CreateOrgnaizationPage1(driver);
ccp.createNewOrg(orgname);

//verification
	OrgnaizationInfoPage oip=new OrgnaizationInfoPage(driver);
	String actOrgName = oip.OrgNameInfo();

	/*
	 * if(actOrgName.contains(orgname)) {
	 * System.out.println(actOrgName+"--->data verified"); } else {
	 * System.out.println("data invalid"); }
	 * 
	 * 
	 */ 
	
	
	 Reporter.log(actOrgName+"org created",true);
	  sa.assertTrue(actOrgName.contains("abc")); 
	  sa.assertAll();
	
}
	
}



