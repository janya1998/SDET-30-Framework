package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//step1:declaration -use @findby annotation
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement userNameEdt;
	
	@FindBy(xpath ="//input[@name='user_password']")
	private WebElement passWordEdt;
	
	@FindBy(xpath = "//input[@id='submitButton']")
	private WebElement submitBtn;
	
	//step2: Intialization -use constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//step3: Utilization -provide getters

	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPassWordEdt() {
		return passWordEdt;
	}
     public WebElement getSubmitBtn() {
		return submitBtn;
	}




//BUSINESS liBRARY
public void loginToApp(String  userName,String password)
{
	userNameEdt.sendKeys("admin");
	passWordEdt.sendKeys("admin");
	submitBtn.click();
	
}
	
}

