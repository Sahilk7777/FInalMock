package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import FIleUtility.ExcelUtility;

public class HomePage
{
	ExcelUtility ex = new ExcelUtility();
	public HomePage(WebDriver driver)
	{
			PageFactory.initElements(driver, this);
	}
	private @FindBy(xpath = "(//a[contains(text(),'Digital downloads')])[1]")
	WebElement digitaldownloads;
	
	public WebElement getDigitaldownloads()
	{
		return digitaldownloads;
	}
	
	private @FindBy(id = "products-orderby")
	WebElement productsOrderBy;
	
	public WebElement getProductsOrderBy()
	{
		return productsOrderBy;
	}
	
	private @FindBy(id = "products-pagesize")
	WebElement display;
	
	public WebElement getDisplay()
	{
		return display;
	}
	
	private @FindBy(id = "products-viewmode")
	WebElement view;
	
	public WebElement getView()
	{
		return view;
	}
	
	public void sortByDropDown() throws EncryptedDocumentException, IOException
	{
		String data = ex.getData("ExcelForDemo", 0, 1);
		Select s = new Select(productsOrderBy);
		s.selectByVisibleText(data);
	}
	public void displayDropDown()
	{
		Select s = new Select(display);
		s.selectByIndex(1);
	}
	
	public void viewDropDown() throws EncryptedDocumentException, IOException
	{
		String viewData = ex.getData("ExcelForDemo", 1, 1);
		Select s = new Select(view);
		s.selectByVisibleText(viewData);
	} 
}
