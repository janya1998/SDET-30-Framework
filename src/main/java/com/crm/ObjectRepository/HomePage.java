package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility {


	
	//Step 1: Declaration
	  @FindBy(linkText="Organizations")
	  private WebElement OrganizationLnk;
	  
	  @FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
	  private WebElement ContactsLnk;
	  
	  @FindBy(linkText="Opportunities")
	  private WebElement OpportunitiesLnk;
	  
	  @FindBy(linkText="Products")
	  private WebElement ProductsLnk;
	  
	  @FindBy(linkText="More")
	  private WebElement MoreLnk;
	  
	  @FindBy(linkText="Campaigns")
	  private WebElement CampaignsLnk;
	  
	  @FindBy(xpath = "//a[.='Leads']")
	   private WebElement leadsLnk;
	  
	  @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	  private WebElement administratorImg;
	  
	  @FindBy(linkText="Sign Out")
	  private WebElement SignOutLnk;
	  
	  //Step 2: Initialization
	  public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	//step3:generate getters
	public WebElement getOrganizationLnk() {
		return OrganizationLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getMoreLnk() {
		return MoreLnk;
	}

	public WebElement getCampaignsLnk() {
		return CampaignsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}

	//business library
	 //business Library
	public void ClickOrgLink()
	{
		OrganizationLnk.click();
		}

	public void ClickContactLink()
	{
		ContactsLnk.click();
	}
	public void clickOnProductLink() {
		ProductsLnk.click();
	}
	public void clickonmoreLink() {
		MoreLnk.click();
	}
	public void clickonComignesLink() {
		CampaignsLnk.click();
	}
	public void clickONleadsLink() {
		leadsLnk.click();
	}

	public void clickOnMoreLink() {
		MoreLnk.click();
	}
	public void SignOutOfApp(WebDriver driver)
	{
		mouseHover(driver,administratorImg);
		SignOutLnk.click();
	}
	
		
		
	}
	
	
	
	
	
	
	
	


