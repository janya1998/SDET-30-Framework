package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampignesPage {
	//declration
	
	@FindBy(xpath = "//a[.='More']")
	private WebElement moreLink;
	
	@FindBy(xpath="//a[.='Campaigns']")
	private WebElement campignesLink;
	
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement campignesLookUpImg;
	//intilization
	public CampignesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getMoreLink() {
		return moreLink;
	}


	public WebElement getCampignesLink() {
		return campignesLink;
	}


	public WebElement getCampignesLookUpImg() {
		return campignesLookUpImg;
	}

	
//business library
	public void clickMoreLnk() {
		moreLink.click();	
	}
	public void clickComLink() {
		campignesLink.click();
	
	}
	

	public void clickOncreateComImg() {
		campignesLookUpImg.click();
	}
}
