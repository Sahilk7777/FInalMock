package demoWebShop;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pom.Login;
import pom.Twitter;

public class Task4 extends BaseClass
{
	Login l =new Login(driver);
	@Test 
	public void taskNo4() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String pID= driver.getWindowHandle();
		Twitter t = new Twitter(driver);
		t.scroll(driver);
		
		t.getTwitterLink().click();
		Thread.sleep(2000);
		Set<String> ids = driver.getWindowHandles();
		System.out.println(ids);
		for(String str:ids)
		{
			driver.switchTo().window(str).getCurrentUrl();
		}
		
		driver.switchTo().window(pID);
	}
}
