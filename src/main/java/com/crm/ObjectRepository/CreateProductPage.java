package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	//declaration
	@FindBy(name ="productname")
	private WebElement productnametext;
	@FindBy(xpath = ("//input[title='Save [Alt+S]']"))
	private WebElement 	saveBtn;
	//intilization
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getProductnametext() {
		return productnametext;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//business library
	public void createNewOrg(String pdroductName)
	{
		productnametext.sendKeys(pdroductName);
	}


}
