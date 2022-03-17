package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunitiesPage {
	
	@FindBy(xpath = "//a[.='Opportunities']")
	private WebElement opportunitiesLnk;
	
	@FindBy(xpath = "//img[@alt='Create Opportunity...']")
	private WebElement opportunitesLookUpImg;
	
	@FindBy(xpath ="//input[@name='potentialname']")
	private WebElement opptxtBox;
	
	@FindBy(xpath = "//input[@id='related_to_display']/following -sibling: :img[@alt='Select']")
	private WebElement reletedToLookUpImg;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchEdt;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBtn;
	 
}
