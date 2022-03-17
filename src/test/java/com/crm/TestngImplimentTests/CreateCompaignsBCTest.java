package com.crm.TestngImplimentTests;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CampignesPage;
import com.crm.ObjectRepository.CreateCamgianInfoPage;
import com.crm.ObjectRepository.CreateCampaignpage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductInfoPage;

public class CreateCompaignsBCTest extends BaseClass{
	 
@Test
public void CreateCompaignsBC() throws Throwable {
	String compaignName = eLib.readDataFromExcel("Sheet3", 1, 2);
	
	//navigate to campaign
	HomePage hp=new HomePage(driver);
	hp.clickonComignesLink();
	
	CampignesPage cp=new CampignesPage(driver);
	cp.clickOncreateComImg();
	
	//navigate to create campaignpage
	CreateCampaignpage ccp=new CreateCampaignpage(driver);
	ccp.createNewCamign(compaignName);
	
	//verification
	CreateCamgianInfoPage cip=new CreateCamgianInfoPage(driver);
	String actcampignname = cip.createCamgianInfo();
	if(actcampignname.contains(compaignName))
	{
		System.out.println(compaignName+"--->data verified");
	}
	else
	{
		System.out.println("data invalid");
	}
	
	
}
	
}



