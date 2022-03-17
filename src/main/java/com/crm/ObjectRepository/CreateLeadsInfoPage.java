package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadsInfoPage {
	//declration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	//intilization
	public CreateLeadsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getHeaderText() {
		return headerText;
	}
	//business library
	public String createLeadsInfo() {
		String leadsInfo=headerText.getText();
		return leadsInfo;
	}

}
