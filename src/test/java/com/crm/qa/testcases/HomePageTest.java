package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends  TestBase
{
	LoginPage loginPage;
	HomePage homepage;
	ContactsPage contactpage;
	 public HomePageTest()
     {
    	 super();
     }
	
	 
	 @BeforeMethod
		public void SetUp()
		{
			initialization();
			loginPage = new LoginPage();
			homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); 
			
		}
	 
	 
	   @Test(priority=1)
	   public void verifyHomePageTitleTest()
	   {
		  String homepageTitle = homepage.verifyHomePageTitle();
		   Assert.assertEquals(homepageTitle, "Cogmento CRM");
	   }
	 
	   @Test(priority=2)
	   public void verifyUsernameTest()
	   {
		   
		   Assert.assertTrue(homepage.verifyCorrectUsername());
	   }
	   
	   @Test(priority=3)
	   public void verifyContactsLinkTest()
	   {
		   contactpage = homepage.clickOnContactsLink(); 
	       //return new ContactsPage();
	   }
	 
	 @AfterMethod
		public void tearDown() 
		{
			driver.quit();
		}
	 
	 
}
