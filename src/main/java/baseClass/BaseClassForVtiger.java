package baseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import FIleUtility.PropertyforVtiger;
import pom.VtigerHome;
import pom.vtigerLogin;

public class BaseClassForVtiger {
	
public static WebDriver driver;
	
    PropertyforVtiger putil = new PropertyforVtiger();	
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
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
		vtigerLogin l = new vtigerLogin(driver);
		l.login();
	}
	
	@AfterMethod
	public void logout()
	{
		VtigerHome h = new VtigerHome(driver);
		h.logout(driver);
	}
	
	@AfterClass
	public void postCondition()
	{
		driver.quit();
	}
}

