package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	//declaration
	@FindBy(xpath = "//a[.='Products']")
	private WebElement productpageLnk;
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createpdtLookUpImg;
	
	//intilization
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utolization

	public WebElement getProductpageLnk() {
		return productpageLnk;
	}

	public WebElement getCreatepdtLookUpImg() {
		return createpdtLookUpImg;
	}

//business library
	public void clickProductLnk() {
		productpageLnk.click();
	}
public void clickoncreatePdtImg()
{
	createpdtLookUpImg.click();
}
}
	
	


