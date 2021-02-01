package FrameworkE2E;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resourses.base;

import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;

import pageObject.LandingPage;


public class GetTitle extends base{
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=InitializeDriver();
		log.info("Driver is initalized again");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to URL ");
		driver.manage().window().maximize();
		
	}
	@Test
	public void courses() throws IOException
	{
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]"));
    	//ele.click();  
		LandingPage l = new LandingPage(driver);
		AssertJUnit.assertEquals(l.getTitle().getText(),"FEATURED COURSES123");
		
		log.info("Successfully Navigated Text Message  ");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}
