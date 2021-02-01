package FrameworkE2E;

import org.testng.annotations.Test;

import Resourses.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;

public class HomePage extends base{
	//Done for parallel mode execution 
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=InitializeDriver();
		driver.get("http://www.qaclickacademy.com");
		driver.manage().window().maximize();
	}
	@Test(dataProvider="getdata")
	public void basePageNavigation(String Username,String Password) throws IOException
	{
		driver=InitializeDriver();
		driver.get("http://www.qaclickacademy.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]"));
    	ele.click();  
		LandingPage l = new LandingPage(driver);
		LoginPage login=l.getLogin();
		//LoginPage login = new LoginPage(driver);
		
		login.getloginbtn().click();
		ForgotPassword fp= login.forgotpassword();
		fp.getemail().sendKeys(Username);
		fp.sendmeinstruction().click();
	
		log.info("Successfully Navigated base page");
		
	}
	@DataProvider
	public Object[][] getdata()
	{
		//Row stands for how many different data type test should run 
		//Column stands for how many values for each test 
		
		
		Object[][] data= new Object[2][2];
		data[0][0]="abg@gmail.com";
		data[0][1]="test1234";
		data[1][0]="def@gmail.com";
		data[1][1]="test1234";
		
		return data;
	}
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}

}
