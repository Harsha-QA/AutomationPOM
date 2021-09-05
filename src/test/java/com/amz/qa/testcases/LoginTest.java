package com.amz.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amz.qa.base.TestBase;
import com.amz.qa.pages.HomePage;
import com.amz.qa.pages.LoginPage;
import com.amz.qa.util.CustomListener;

@Listeners(CustomListener.class)
public class LoginTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginTest() {
		super();
	}
	Logger log = Logger.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void setUp()
	{ 
		log.info("****************************** Starting test cases execution  *****************************************");

		initialization();
		log.info("launching chrome broswer");
		loginPage = new LoginPage();
		
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
		
	}

	
	@Test(priority = 1, groups = {})
	public void loginPageTitle()
	{
		String title = loginPage.validateLoginTitle();
		Assert.assertEquals(title, "Amazon Sign In");
		System.out.println(title);
		log.info("login page title is--->"+title);
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
		log.info("****************************** Browser is closed *****************************************");
	}
	
}
