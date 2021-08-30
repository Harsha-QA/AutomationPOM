package com.amz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amz.qa.base.TestBase;
import com.amz.qa.pages.HomePage;
import com.amz.qa.pages.LoginPage;
import com.amz.qa.pages.YourAcountpage;
import com.amz.qa.util.CustomListener;

@Listeners(CustomListener.class)
public class HomepageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	YourAcountpage youraccountpage;
	
	public HomepageTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		youraccountpage = new YourAcountpage();
		homepage  =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@Test(priority = 1)
	public void loginPageTitle()
	{
		String title = homepage.verifyHomePageTitle();
		//Assert.assertEquals(title, "Amazon Sign In");
		System.out.println(title);
		
	}
	
	@Test(priority = 2)
	public void VerifyAccount()
	{
		try {
			youraccountpage = homepage.VerifyUserProfile();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
