package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CraeteLeadsPage extends WebDriverUtility{
	//dclaration
	@FindBy(name = "lastname")
	private WebElement lastNameText;
	
	@FindBy(name="company")
	private WebElement companyNameText;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	//intilization
	public CraeteLeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getLastNameText() {
		return lastNameText;
	}
	public WebElement getCompanyNameText() {
		return companyNameText;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business library
	public void createNewLeads(String lastName,String companyName) {
		lastNameText.sendKeys(lastName);
		companyNameText.sendKeys(companyName);
		saveBtn.click();
		
	}
	
	
	

}
