package test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.Base;
import pages.Loginpage;


public class logintest extends Base {

	
	Loginpage loginpage = null;
	@BeforeSuite
public	void setup ()
	{
		logger.info("inside beforesuite");
	initilization();
	reportInit();
     loginpage= new Loginpage(driver);
	}
	
	
	@AfterSuite
	public	void teardown ()
		{
		 report.flush(); 
	  
	 
			
		}
		
	
	
	@Test
	public void test01()
	{
		
		test = report.createTest("test01");
		Assert.assertEquals(driver.getTitle(), "javabykiran | Log in");
		
		
	}
	
	
	@Test
	public void test011()
	{
		
	loginpage.loginApplication();
	Assert.assertEquals(driver.getTitle(), "javabykiran | Log in");
	
		
		
	}
	
	

	
	@Test
	public void passTest() {
		logger.info("executing fail test");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
		logger.info("fail test failed");
	}
	
	
	@Test
	public void failTest() {
		logger.info("executing fail test");
		Assert.assertEquals(driver.getTitle(), "llavaByKiran | Log in");
		logger.info("fail test failed");
	}
	
	
}
