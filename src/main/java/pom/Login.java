package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login
{
	
	public Login(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	private @FindBy(xpath = "//a[text()='Log in']")
	WebElement loginLink;
	
	public WebElement getloginLink()
	{
		return loginLink;	
	}
	private @FindBy(id = "Email")
	WebElement userEmail;
	
	public WebElement getuserEmail()
	{
		return userEmail;	
	}
	private @FindBy(id="Password")
	WebElement userPassword;
	
	public WebElement getuserPassword()
	{
		return userPassword;
	}
	private @FindBy(css = "input[value='Log in']")
	WebElement loginButton;
	
	public WebElement getloginButton()
	{
		return loginButton;
	}
	
	private @FindBy(xpath = "//a[text()='Log out']")
	WebElement logoutLink;
	
	public WebElement getLogout()
	{
		return logoutLink; 
	}
	
	public void getUserLogout()
	{
		logoutLink.click();
	}
	
}
