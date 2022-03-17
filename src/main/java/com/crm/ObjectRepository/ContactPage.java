package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactPage extends WebDriverUtility
{
	//step1: declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createConImg;
	
	//step2:intilization
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getCreateConImg() {
		return createConImg;
	}
	
	
	
//business library

public void clickOnCreateContactImg()
{
	createConImg.click();
}
}