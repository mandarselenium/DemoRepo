package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{

	@FindBy(xpath="//input[@name='first_name']")
	WebElement contact_firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement contact_lastname;
	
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement contact_middlename;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement Eamil;
	

	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;	
	
	 public ContactsPage()
	   {
		   PageFactory.initElements(driver, this);
	   }

	 public boolean verifyContactFirstName()
	 {
		return contact_firstname.isDisplayed();
		 
	 }
	 
	 public void verifyFirstnamesendkeys()
	 {
		 contact_firstname.sendKeys("Mandar Bhogate");
	 }


	 public void createNewContact(String firstName,String lastName,String middleName,String EMAIL) throws InterruptedException
	 {
		 contact_firstname.sendKeys(firstName);
		 contact_lastname.sendKeys(lastName);
		 contact_middlename.sendKeys(middleName);
		 Eamil.sendKeys(EMAIL);
		 saveBtn.click();
		 Thread.sleep(2000);
		 
	 }
	 
}
