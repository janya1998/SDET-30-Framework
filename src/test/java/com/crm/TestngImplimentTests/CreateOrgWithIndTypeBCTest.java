package com.crm.TestngImplimentTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrgnaizationPage1;
import com.crm.ObjectRepository.CreateOrgnizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrgnaizationInfoPage;
@Listeners(com.crm.GenericLibrary.ListnerImplementationClass.class)
public class CreateOrgWithIndTypeBCTest extends BaseClass 
{
	@Test(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyserImplementation.class)
	public void CreateOrgWithIndType() throws Throwable {
		
		String orgname=eLib.readDataFromExcel("Org", 1, 2)+" "+jLib.getRandomNumber();
		String indType = eLib.readDataFromExcel("Org", 3, 3);
	
		//navigate to organization link
		SoftAssert sa=new SoftAssert();
	HomePage hp=new HomePage(driver);
	hp.ClickOrgLink();
	
	String expData = "Organizations";
	String actData = driver.findElement(By.linkText("Organizations")).getText();
	Assert.assertEquals(expData, actData);
	
	CreateOrgnizationPage cp=new CreateOrgnizationPage(driver);
	cp.clickOnCreateOrgImg();
		
		/*Step 5: click on create org swanization btn*/
	CreateOrgnaizationPage1 ccp=new CreateOrgnaizationPage1(driver);
	ccp.createNewOrg(orgname, indType);
		
		//verification
	OrgnaizationInfoPage cip=new OrgnaizationInfoPage(driver);
		String actOrgName = cip.OrgNameInfo();
		/*if(actOrgName.contains(orgname))
		{
			System.out.println(orgname+"--->data verified");
		}
		else
		{
			System.out.println("data invalid");
		}*/
		
	//Assert.fail();
		 Reporter.log(actOrgName+"org created",true);
		  sa.assertTrue(actOrgName.contains("abc")); 
	}
	@Test
public void testscriptsample() {
		System.out.println("test script2");
		}
	}

 


