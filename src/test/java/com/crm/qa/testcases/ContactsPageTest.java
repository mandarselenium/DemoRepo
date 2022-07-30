package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homepage;
	ContactsPage contactpage;
	TestUtil testutil;
	
	String sheetName = "contacts";
   
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		contactpage = new ContactsPage();
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password")); 
		contactpage=homepage.clickOnContactsLink();
	}


	
	@Test
	public void verifyContactFirstNameTest()
	{
		Assert.assertTrue(contactpage.verifyContactFirstName(),"Contacts page first name is missing");
	}
	
	@Test
	public void verifyFirstnamesendkeysTest() 
	{
		contactpage.verifyFirstnamesendkeys();
		System.out.println(contactpage.toString());
	}
	

	@DataProvider
	public Object  [][] getCRMTestData() throws Exception, Exception
	{
		Object data [][]  = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	
	@Test(dataProvider = "getCRMTestData" )
	public void validateCreateNewContact(String fname,String lname,String mname ,String Email) throws InterruptedException
	{
		//contactpage.createNewContact("Mandar", "Bhogate", "Balavant", "test@test.com");
		contactpage.createNewContact(fname, lname, mname, Email);
	}
	

   @AfterMethod
   public void tearDoown()
  {
	   driver.quit();
  }
}
