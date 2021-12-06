package com.qa.pages;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.utilities.ReadConfig;

public class Baseclass 
{
	//to read ReadConfig from utilities pkg
	ReadConfig rc = new ReadConfig();
	
	public String baseurl=rc.getApplicationURL();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) 
	{	 
		 logger =Logger.getLogger("ebanking");
		 PropertyConfigurator.configure("log4j.properties");
		
		 if(br.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",rc.getChromePath());
				driver=new ChromeDriver();
			}
			else if(br.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",rc.getFirefoxPath());
				driver = new FirefoxDriver();
			}
			else if(br.equals("ie"))
			{
				System.setProperty("webdriver.ie.driver",rc.getIEPath());
				driver = new InternetExplorerDriver();
			}
			
			driver.get(baseurl);
		 
	}
	
	
	@AfterClass
	public void teardown()
	{
		//driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		Date currenDate = new Date();
		String screenshotfilename = currenDate.toString().replace(" ", " ").replace(":", "-");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + screenshotfilename + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomstring()
	{
		String generatedstring=	RandomStringUtils.randomAlphabetic(5);
		return(generatedstring);
	}
	
	public static String randomNumber()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(4);
		return (generatedNumber);
	}
}
