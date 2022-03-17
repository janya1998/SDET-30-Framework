package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCamgianInfoPage {
	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement hederText;
	//intilization
	public CreateCamgianInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utlization
	public WebElement getHederText() {
		return hederText;
	}
	
	//business library
	public String createCamgianInfo() {
		String crecamign = hederText.getText();
		return crecamign;
	}
}
