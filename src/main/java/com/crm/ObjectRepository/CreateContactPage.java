package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility
{
	
//step1:declration
@FindBy(name="lastname")
private WebElement lastNameEdt;
@FindBy(xpath ="//input[@name='account_name']/following-sibling::img[@alt='Select']")
private WebElement orgNameLookUpImg;


@FindBy(name="leadsource")
private WebElement leadsourceDropDown;	

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy(name ="search_text" )
private WebElement searchEdt;

@FindBy(name="search")
private WebElement searchBtn;

//step2:intilization
public CreateContactPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//step3:utilization

public WebElement getLastNameEdt() {
	return lastNameEdt;
}

public WebElement getOrgNameLookUpImg() {
	return orgNameLookUpImg;
}

public WebElement getLeadsourceDropDown() {
	return leadsourceDropDown;
}


public WebElement getSaveBtn() {
	return saveBtn;
}

public WebElement getSearchEdt() {
	return searchEdt;
}

//business library
public void creatNewContact(String lastaName)
{
	lastNameEdt.sendKeys(lastaName);
	saveBtn.click();
}
/**
 * create new contact with lastname and leadsource dropdown
 * @param lastaName
 * @param leadSource
 */
public void creatNewContact(String lastaName,String leadSource)
{
	lastNameEdt.sendKeys(lastaName);
	select(leadSource, leadsourceDropDown);
	saveBtn.click();
	}
/**
 * create new contact with orgnization and lastname
 * @param driver
 * @param lastName
 * @param orgName
 */
public void createNewContact(WebDriver driver,String lastName,String orgName)
{
	lastNameEdt.sendKeys(lastName);
	orgNameLookUpImg.click();
	switchToWindow(driver, "Accounts");
	searchEdt.sendKeys(orgName);
	searchBtn.click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	switchToWindow(driver, "Contacts");
	saveBtn.click();
	
}
}







