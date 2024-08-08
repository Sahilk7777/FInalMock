package demoWebShop;

import java.io.IOException;

import org.testng.annotations.Test;
import FIleUtility.PropertyUtility;
import baseClass.BaseClass;
import pom.HomePage;

public class Task3 extends BaseClass
{
	PropertyUtility p = new PropertyUtility();
	
	@Test
	public void testCases() throws IOException
	{
		HomePage h = new HomePage(driver);	
		h.getDigitaldownloads().click();
		h.sortByDropDown();
		h.sortByDropDown();
		h.displayDropDown();
		h.viewDropDown();
	}
}