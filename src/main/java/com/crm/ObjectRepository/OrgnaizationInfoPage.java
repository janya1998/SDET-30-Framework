package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;
//step1:declration
public class OrgnaizationInfoPage extends WebDriverUtility
{
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	//step2:intilization
	public OrgnaizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step3:utilization
	public WebElement getHeaderText() {
		return headerText;
	}
	
	//business library
	public String OrgNameInfo() {
		String orgInfo = headerText.getText();
		return orgInfo;
	}
	
	
	

}
