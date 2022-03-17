package com.crm.GenericLibrary;

import java.awt.AWTException;



import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * THIS CLASS CONSIST Od all generic methods related to weddriveractions
 * @author User
 *
 */
public class WebDriverUtility {
	
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * this method will wait  for 20 sec for the  element visiable
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * this method will wait  for 20 sec for the  element visiable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this method will select data from dropdown using element
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method will select data from dropdown using index
	 * @param element
	 * @param index
	 */
	public void select( WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * this method will select data from dropdown using value
	 * @param element
	 * @param value
	 */
	public void select( WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * this method will select data from dropdown value text
	 * @param element
	 * @param value
	 */
	public void select( String text,WebElement element)
	{
	
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * this method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 *  this method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param traget
	 */
	
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement traget)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src,traget).perform();
		
	}
	/**
	 * this method will perform double click action
	 * @param driver
	 * @param element
	 */
	
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 *  this method will perform rightclickaction on webpage
	 * @param driver
	 */
	
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 *  this method will perform rightclickaction on element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	} 
	/**
	 * this method will press enter key
	 * @param driver
	 */
	
	public void enterKeyPress(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 *  this method will press enter key
	 * @throws Throwable
	 */
	public void enterKey() throws Throwable {
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * this method will release the key
	 * @throws Throwable
	 */
	
	public void enterRelease() throws Throwable {
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * this methos will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this methos will switch the frame based on name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * this methos will switch the frame based on adress of the element
	 * @param driver
	 * @param address
	 */
	 
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	 /**
	   * this method will accept alert pop up
	   * @param driver
	   * @param address
	   */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	/**
	 * this method will cancel alert pop up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method will switch to window depending on partial window title
	 * @param driver
	 * @param PartialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String PartialWinTitle)
	{
		//step1: use getwindowhandle to capture all window ids
		Set<String> windows = driver.getWindowHandles();
		//step2: iterate thru the window
		Iterator<String> it = windows.iterator();
		
		//step#: check the thru the next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String  winId=it.next();
			//step5: switch to cureent window and cpture the title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//step6: check whether the current window is excpted
			if(currentWinTitle.contains(PartialWinTitle))
			{
				break;
			}
			
		}
		
	}
	/**
	 * this method will take sceenshot and store it in folder called screenshot
	 * @param driver
	 * @param screenshotname
	 * @throws Throwable
	 */
	public String getScreenShot(WebDriver driver,String screenshotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
	String path = "./Screenshot"+screenshotName+".png";
		File dst=new File(path);
		Files.copy(src, dst);
		return dst.getAbsolutePath();
		
	}
	/** this method perform raandom scroll \21`
	 * 
	 * @param driver
	 */
	
	public void scroolAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scollBy(0,500)","");
	}
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window(0,"+y+")", element);
		//js.executeScript("argument[0].scrollIntoView()",element );
	}
	
	
	
	
	
	

}
