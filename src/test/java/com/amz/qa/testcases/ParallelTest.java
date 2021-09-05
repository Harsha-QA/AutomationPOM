package com.amz.qa.testcases;

import org.testng.annotations.Test;

public class ParallelTest {
	
	@Test
	public void test1()
	{
		System.out.println("test1 "+Thread.currentThread().getId());
	}
	@Test
	public void test2()
	{
		System.out.println("test2 "+Thread.currentThread().getId());
	}
	@Test
	public void test3()
	{
		System.out.println("test3 "+Thread.currentThread().getId());
	}
	@Test(threadPoolSize = 3, invocationCount = 5)
	public void test4()
	{
		System.out.println("test4 "+Thread.currentThread().getId());
	}

}
