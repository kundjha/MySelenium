package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
public WebDriver driver;
By signin=By.cssSelector("a[href*='sign_in']");
By Title = By.cssSelector(".text-center>h2");
By NavBar= By.cssSelector("nav[class='navbar-collapse collapse']");

public LandingPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
}

public LoginPage getLogin()
{
	//System.out.println(" I am here ");
    driver.findElement(signin).click();
    LoginPage login = new LoginPage(driver);
    return login;
}

public WebElement getTitle()
{
	//System.out.println(" I am here ");
	return driver.findElement(Title);
}
public WebElement getNavigationBar()
{
	//System.out.println(" I am here ");
	return driver.findElement(NavBar);
}
}
