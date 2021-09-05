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
public class GroupTest extends TestBase{
	
	

	@Test(groups = {"sanity"})
	public void test1()
	{
		System.out.println("sanity only");
		
	}
	
	@Test(groups = {"sanity", "regression"})
	public void test2()
	{
		System.out.println("Sanity and regression");
		
	}
	
	@Test(groups = {"regression"})
	public void test3()
	{
	    System.out.println("regression only");
		
	}
	
	@Test(groups = {"smoke"})
	public void test4() 
	{
	  System.out.println("smoke only");
	}

	@Test(groups = {"smoke","regression"})
	public void test5() 
	{
	  System.out.println("smoke and regression");
	}

	@Test
	public void test6() 
	{
	  System.out.println("blank");
	}
		
	
	
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	
	  }
}
