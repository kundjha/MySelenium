package FrameworkE2E;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resourses.base;

import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;

import pageObject.LandingPage;

public class ValidateNavigationBar extends base{
	//Done for parallel mode execution 
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	//public Properties prop;
	//prop=new Properties();
	@BeforeTest
	public void initialize() throws IOException
	{
      driver=InitializeDriver();
		
	    driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	@Test
	public void basePageNavigation() throws IOException
	{
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]"));
    	ele.click();  
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Base page Navigation Done");
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	

}
