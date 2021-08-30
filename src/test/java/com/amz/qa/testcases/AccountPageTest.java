package com.amz.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amz.qa.base.TestBase;
import com.amz.qa.pages.HomePage;
import com.amz.qa.pages.LoginPage;
import com.amz.qa.pages.YourAcountpage;
import com.amz.qa.util.CustomListener;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(CustomListener.class)
public class AccountPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	YourAcountpage youraccountpage;
	
	public AccountPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homepage  =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		youraccountpage = new YourAcountpage();
		
	}
	
	@Test(priority = 1)
	public void loginPageTitle()
	{
		
		String title = homepage.verifyHomePageTitle();
		//Assert.assertEquals(title, "Amazon Sign In");
		System.out.println(title);
	}
	
	@Test(priority = 2)
	public void VerifyAddress()
	{
		try {
			homepage.VerifyUserProfile();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		youraccountpage.verifyAddressPage();
		
		}
	
	@Test(priority = 3)
	
	public void confirmAddressPage() throws InterruptedException
	{
		homepage.VerifyUserProfile();
		youraccountpage.verifyAddressPage();
		youraccountpage.addAddress();
		Assert.assertEquals(youraccountpage.confirmAddres.getText(), "Add a new address");
			
		}
		
	
	
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	
	  }
}
