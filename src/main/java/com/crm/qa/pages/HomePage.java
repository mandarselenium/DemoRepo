package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{

	Actions act;
	@FindBy(xpath="//span[@class='user-display']")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[@href='/contacts']")
	WebElement Comtactsoption;
	
	@FindBy(xpath="//div[3]//button[1]//i[1]")
	WebElement ComtactsAdd_option;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[5]/a[1]/i[1]")
	WebElement Dealsoption;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[5]/button[1]/i[1]")
	WebElement Deals_Add_option;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[6]/a[1]/i[1]")
	WebElement Tasksoption;

	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[6]/button[1]")
	WebElement Tasks_Add_option;
	
	
	
   public HomePage()
   {
	   PageFactory.initElements(driver, this);
   }

   public String verifyHomePageTitle()
   {
	   return driver.getTitle();
   }
   
   public boolean verifyCorrectUsername()
   {
	   return usernamelabel.isDisplayed();
   }

   public ContactsPage clickOnContactsLink()
   {
	   act = new Actions(driver);
	   act.moveToElement(Comtactsoption).build().perform();
	   ComtactsAdd_option.click();
	   
	   return new ContactsPage();
   }

   public DealsPage clickOnDealsLink()
   {
	   act = new Actions(driver);
	   act.moveToElement(Dealsoption);
	   Deals_Add_option.click();
	   
	   return new DealsPage();
   }
   
   
   public TasksPage clickOnTasksLink()
   {
	  // driver.switchTo().frame(1);
	   act = new Actions(driver);
	   act.moveToElement(Tasksoption);
	   Tasks_Add_option.click();
	   
	   return new TasksPage();
   }
   
   
   
}
