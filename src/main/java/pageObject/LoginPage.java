package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	By email=By.id("user_email");
	By password = By.id("user_password");
	By btnLogin= By.name("commit");
	By ForgotPassword=By.cssSelector("a[class='link-below-button']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public ForgotPassword forgotpassword()
	{
		driver.findElement(ForgotPassword).click();
		return new ForgotPassword(driver);
		
		
	}
	
	

	public WebElement getemail()
	{
		//System.out.println(" I am here ");
		return driver.findElement(email);
	}
	
	
	public WebElement getpassword()
	{
		//System.out.println(" I am here ");
		return driver.findElement(password);
	}
	public WebElement getloginbtn()
	{
		//System.out.println(" I am here ");
		return driver.findElement(btnLogin);
	}

}
