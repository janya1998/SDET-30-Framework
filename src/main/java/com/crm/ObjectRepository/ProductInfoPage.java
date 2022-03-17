package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	//declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
    private WebElement headertext;
	//intilization
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utlization
	public WebElement getHeadertext() {
		return headertext;
	}
	//business library
	public String productNameInfo()
	{

		String productinfo = headertext.getText();
		return productinfo;
	}
}
