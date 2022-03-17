package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignpage {
	//declration
	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement craetecamaignLookUpImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	//intilization
	public CreateCampaignpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getCraetecamaignLookUpImg() {
		return craetecamaignLookUpImg;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//buiness library
	public void  createNewCamign(String camgianName)
	{
		craetecamaignLookUpImg.click();
		saveBtn.click();
	}

}
