package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	public WebDriver driver;
	By email=By.cssSelector("#user_email");
	By sendmeInstruction = By.cssSelector("#user_email");
	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public WebElement sendmeinstruction()
	{
		//System.out.println(" I am here ");
		return driver.findElement(sendmeInstruction);
	}
	

	public WebElement getemail()
	{
		//System.out.println(" I am here ");
		return driver.findElement(email);
	}
	

}
