package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homepage;
     public LoginPageTest()
     {
    	 super();
     }
	
	@BeforeMethod
	public void SetUp()
	{
		initialization();
		loginPage = new LoginPage();
	}
     
	@Test
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM PRO");
	}
	
	@Test
	public void loginTest()
	{
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password")); 
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
