package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.Baseclass;
import com.qa.pages.LoginPage;

public class TC_LoginTest_001 extends Baseclass
{
	
	@Test
	public void loginTest() throws IOException 
	{
		driver.get(baseurl);
		logger.info("url is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("entered username");
		
		lp.setPassword(password);
		logger.info("pwd entered");
		lp.clickSubmit();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);
			logger.info("test passed");
		} 
		else 
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("test failed");
		}
	}
}
