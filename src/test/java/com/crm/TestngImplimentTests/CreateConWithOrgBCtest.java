package com.crm.TestngImplimentTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateInfoPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateConWithOrgBCtest extends BaseClass {
	@Test
	
public void CreateConWithOrgBC() throws Throwable 
{
	String lastname = eLib.readDataFromExcel("Sheet2", 4, 2);
	String leadsource = eLib.readDataFromExcel("Sheet2", 4, 3);
	
	//navigate to contact link
	HomePage hp=new HomePage(driver);
	hp.ClickContactLink();
	ContactPage cp=new ContactPage(driver);
	cp.clickOnCreateContactImg();
	Assert.fail();

	//navigate to create contact link
	CreateContactPage ccp=new CreateContactPage(driver);
	ccp.creatNewContact(lastname, leadsource);
	//creete new contact information
	CreateInfoPage cip=new CreateInfoPage(driver);
	String actlastname = cip.contactNameInfo();
	if(actlastname.contains(lastname))
	{
		System.out.println(actlastname+"--->data verified");
	}
	else
	{
		System.out.println("data invalid");
	}
	
	
	
}
		
}
		
	
		
		
