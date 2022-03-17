package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrgnizationPage extends WebDriverUtility{
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	//step2: intialization 
	public CreateOrgnizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	//step3: utilization
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
	
	//business library
	public void clickOnCreateOrgImg() {
		createOrgLookUpImg.click();
	}
		
}
