package Resourses;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class base {
	//This is Genreaic Driver initialization function , applicable for all drivers 
	//We use properties file to pass the driver on which execution to be done 
	//Here We are drining Webdriver as public so that can be used across and simplify the code 
	//Creating driver object only once
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver InitializeDriver() throws IOException
	{
		
	   prop =new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\FrameworkE2E\\src\\main\\java\\Resourses\\data.properties");
		//How properties file will know about this file 
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equals("chrome"))
		{
			System.out.println("Invoked");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\Downloads\\geckodriver-v0.29.0-win32\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browserName.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\hp\\Downloads\\edgedriver_win32\\msedgedriver.exe");
			driver=new EdgeDriver();
			
		}
		System.out.println("coming out of loop");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
				
	}
	public String getScreenShotPath(String testcasename, WebDriver driver) throws IOException
	{
		//driver=this.driver;
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
	

}
