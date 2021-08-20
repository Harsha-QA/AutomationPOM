package com.amz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amz.qa.base.TestBase;
import com.amz.qa.pages.HomePage;
import com.amz.qa.pages.LoginPage;

public class LoginTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}

	
	@Test(priority = 1)
	public void loginPageTitle()
	{
		String title = loginPage.validateLoginTitle();
		Assert.assertEquals(title, "Amazon Sign In");
		System.out.println(title);
	}
	
	@Test(priority = 2)
	public void verifyLogo()
	{
	boolean flag = loginPage.logo();
	Assert.assertTrue(flag);
	System.out.println(flag);
	}
	
	@Test(priority = 3) 
	public void LoginMethod()
	{
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Login successfull");
	
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
