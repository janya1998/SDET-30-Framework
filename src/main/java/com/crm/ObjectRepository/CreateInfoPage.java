package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateInfoPage extends WebDriverUtility
{
	
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	//intilization
	public CreateInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilzation

	public WebElement getHeaderText() {
		return headerText;
	}
	
	//business library
	public String contactNameInfo()
	{
		String conInfo = headerText.getText();
		return conInfo;
	}
	

	
}
