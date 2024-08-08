package pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FIleUtility.PropertyforVtiger;

public class vtigerLogin {
	PropertyforVtiger putil = new PropertyforVtiger();
	public vtigerLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	private @FindBy(name = "user_name")
	WebElement uName;
	
	public WebElement getUsername()
	{
		return uName;
	}
	
	private @FindBy(name = "user_password")
	WebElement pass;
	
	public WebElement getPassword()
	{
		return pass;
	}
	
	private @FindBy(id = "submitButton")
	WebElement loginBtn;
	
	public WebElement getLogin()
	{
		return loginBtn;
	}
	
	public void login() throws IOException
	{
		getUsername().sendKeys(putil.getInputData("UserName"));
		getPassword().sendKeys(putil.getInputData("Password"));
		getLogin().click();
	}
}