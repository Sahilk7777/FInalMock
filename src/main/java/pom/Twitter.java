package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FIleUtility.ExcelUtility;

public class Twitter
{
	ExcelUtility ex = new ExcelUtility();
	
	public Twitter(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Twitter']")
	WebElement twitterLink;
	
	public WebElement getTwitterLink()
	{
		return twitterLink;
	}
	public void scroll(WebDriver driver)
	{
		Actions as = new Actions(driver);
		as.scrollToElement(twitterLink);
		as.perform();
	}
	
	
	@FindBy(xpath = "//span[text()='Create account']")
	WebElement createAccount;
	
	public WebElement getCreateAccount()
	{
		return createAccount;
	}
	
	@FindBy(css = "input[autocomplete='name']")
	WebElement userName;
	
	public WebElement getUserName()
	{
		return userName;
	}
	
	@FindBy (css = "input[autocomplete='tel']")
	WebElement userNumber;
	
	public WebElement getUserNumber()
	{
		return userNumber;
	}
	public void createAccountFunction() throws EncryptedDocumentException, IOException
	{
		getCreateAccount().click();
		getUserName().sendKeys(ex.getData("Twitter", 0, 1));
		getUserNumber().sendKeys("9049052709");
	}
}
