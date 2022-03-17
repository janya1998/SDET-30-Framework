package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrgnaizationPage1 extends WebDriverUtility
{
	//step1:declration
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;

	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//step2: intilization
	public CreateOrgnaizationPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//step3:utilization

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

//business library
public String createNewOrg(String orgName) {
	
	OrgNameEdt.sendKeys(orgName);
	saveBtn.click();
	return orgName;
}
	public void createNewOrg(String orgName,String indType) 
	{
		OrgNameEdt.sendKeys(orgName);
		select(indType, industryDropDown);
		saveBtn.click();
		
	}
	
	public void createNewOrg(String orgName,String indType,String typename)	
	{
		OrgNameEdt.sendKeys(orgName);
		select(indType, industryDropDown);
		select(typename,typeDropDown);
		saveBtn.click();
	}
}
	
	
		
	
	
	
	


	
	

	

	
	
	
	


