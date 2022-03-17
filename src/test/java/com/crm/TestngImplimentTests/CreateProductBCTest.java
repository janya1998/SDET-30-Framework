package com.crm.TestngImplimentTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductsPage;

public class CreateProductBCTest extends BaseClass{
	@Test
	public void CreateProductBC() throws Throwable {
	String productname = eLib.readDataFromExcel("Sheet3", 1, 2);
	//navigate to product link
	SoftAssert sa=new SoftAssert();
	
	HomePage hp=new HomePage(driver);
	hp.clickOnProductLink();
	
	String expData = "Products";
	String actData = driver.findElement(By.linkText("Products")).getText();
	Assert.assertEquals(expData, actData);
	 
	ProductsPage pp=new ProductsPage(driver);
	pp.clickoncreatePdtImg();
	
	 String expHeader ="Creating New Product"; 
	 String actHeader =driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	 sa.assertEquals(actHeader, actHeader);
	//navigate to create product page
	CreateProductPage cp=new CreateProductPage(driver);
	cp.createNewOrg(productname);
	//NAVIGATE to create product
	ProductInfoPage pip=new ProductInfoPage(driver);
	String actproductname = pip.productNameInfo();
	/*if(actproductname.contains(productname))
	{
		System.out.println(productname+"--->data verified");
	}
	else
	{
		System.out.println("data invalid");
	}*/
	 Reporter.log(actproductname+"org created",true);
	  sa.assertTrue(actproductname.contains("abc")); 
	
}
		

	}


