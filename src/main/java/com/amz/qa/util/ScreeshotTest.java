package com.amz.qa.util;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.amz.qa.base.TestBase;

public class ScreeshotTest extends TestBase{
	
	@BeforeMethod
	public void setup()
	{
		initialization();
	}

	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
}
