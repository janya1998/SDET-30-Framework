
package com.crm.TestngImplimentTests;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ListnerImplementationClass;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateInfoPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrgnaizationInfoPage;
@Listeners(ListnerImplementationClass.class)
public class CreateContactTest extends BaseClass {
	@Test

	public void CreateContact() throws Throwable {

		String lastname = eLib.readDataFromExcel("Sheet2",1 , 2);

		/*naviagate the contact link*/
		SoftAssert sa=new SoftAssert();
		HomePage hp=new HomePage(driver);
		hp.ClickContactLink();
		//Assert.fail();
		String expdata = "Contacts";
		String actdata = driver.findElement(By.linkText("Contacts")).getText();
		sa.assertEquals(expdata, actdata);

		ContactPage cp=new ContactPage(driver);
		cp.clickOnCreateContactImg();

		String expHeader ="Creating New Contact"; 
		String actHeader =driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		sa.assertEquals(actHeader, actHeader);

		/*click on create org swanization bin*/
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.creatNewContact(lastname);

		/*step 6: enter the mandatory fields and save*/


		//verification
		CreateInfoPage cip=new CreateInfoPage(driver);
		String actlastname = cip.contactNameInfo();
		/*if(actlastname.contains(lastname))
		{
			System.out.println(actlastname+"--->data verified");
		}
		else
		{
			System.out.println("data invalid");
		}*/
		Reporter.log(actlastname+"con created",true);
		sa.assertTrue(actlastname.contains("abc")); 
		sa.assertAll();


	}




}


