package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class LeadsPage extends WebDriverUtility {
	//declaration
   @FindBy(xpath = "//a[.='Leads']")
   private WebElement leadsLnk;
   @FindBy(xpath = "//img[@alt='Create Lead...']")
   private WebElement leadsLookUpImg;
    
   //intilization
   public LeadsPage(WebDriver diver) {
	   PageFactory.initElements(diver, this);
   }
   //utilization

public WebElement getLeadsLnk() {
	return leadsLnk;
}

public WebElement getLeadsLookUpImg() {
	return leadsLookUpImg;
}
   //business library
public void clickOnLeadsPage() {
	leadsLnk.click();
}
	
	public void clickOnLeadsCreateImg() {
		leadsLookUpImg.click();
	
}

}
