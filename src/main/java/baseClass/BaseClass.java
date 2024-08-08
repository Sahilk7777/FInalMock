package baseClass;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import FIleUtility.PropertyUtility;
import pom.Login;

public class BaseClass 
{
	public static WebDriver driver;
	String expectedURL="https://demowebshop.tricentis.com/";
PropertyUtility putil = new PropertyUtility();
	
	@BeforeClass
	public void preCondition() throws IOException
	{
		String browser = putil.getInputData("Browser");
		String url = putil.getInputData("URL");

		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		String actualURL = driver.getCurrentUrl();
		assertTrue(expectedURL.equals(actualURL));
	}
	@BeforeMethod()
	public void login() throws IOException
	{
		Login l= new Login(driver);
		l.getloginLink().click();
		l.getuserEmail().sendKeys(putil.getInputData("Email"));
		l.getuserPassword().sendKeys(putil.getInputData("Password"));
		l.getloginButton().click();
	}
	@AfterMethod
	public void Userlogout()
	{
		Login l= new Login(driver);
		l.getUserLogout();
	}
	@AfterClass
	public void postCondition()
	{
		driver.quit();
	}
}
