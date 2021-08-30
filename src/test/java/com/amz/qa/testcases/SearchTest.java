package com.amz.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amz.qa.base.TestBase;
import com.amz.qa.pages.HomePage;
import com.amz.qa.pages.LoginPage;
import com.amz.qa.pages.Search;
import com.amz.qa.pages.YourAcountpage;
import com.amz.qa.util.CustomListener;

@Listeners(CustomListener.class)
public class SearchTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	YourAcountpage youraccountpage;
	Search searchPage;
	
	public SearchTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homepage  =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		youraccountpage = new YourAcountpage();
		searchPage = new Search();
		String title = homepage.verifyHomePageTitle();
		System.out.println(title);
		searchPage.searchContent();
	}
	
	/*
	 * @Test(priority = 1) public void loginPageTitle() { String title=
	 * homepage.verifyHomePageTitle(); //Assert.assertEquals(title,
	 * "Amazon Sign In");
	 * 
	 * }
	 */
	
	/*
	 * @Test(priority = 2) public void verifySearch() { searchPage.searchContent();
	 * 
	 * }
	 */
	

	@Test(priority = 1)
	
	public void verifyPrime()
	{
		
		searchPage.primeOption();
		Assert.assertTrue(searchPage.primeOption(), "All prime option is not available");
		
		}
	@Test(priority = 2)
	public void verifyPrice() throws InterruptedException
	{
		
		searchPage.SelectPrice("100", "500");
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("#a-autoid-9")).click();
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		//exe.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("#a-autoid-9")));
		
		}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
