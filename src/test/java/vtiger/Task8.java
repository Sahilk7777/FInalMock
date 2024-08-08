package vtiger;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import FIleUtility.ExcelUtility;
import baseClass.BaseClassForVtiger;
import javaUtility.JavaUtil;
import pom.Contacts;
import pom.VtigerHome;

public class Task8 extends BaseClassForVtiger
{
	ExcelUtility eUtil = new ExcelUtility();
	@Test
	public void createContact() throws EncryptedDocumentException, IOException
	{
		VtigerHome h = new VtigerHome(driver);
		h.contacts();
		
		Contacts c = new Contacts(driver);
		c.plus();
		c.firstName(eUtil.getData("contact", 0, 0));
		String lName = eUtil.getData("contact", 0, 1);
		c.lastName(lName+JavaUtil.generateRandomNumber(1000));
		c.group();
		c.startDate(JavaUtil.getCurrentDate());
		c.endDate(JavaUtil.getDesiredDate());
		c.saveBtn();
		
		assertTrue((c.getCreatedContactText().getText()).contains(lName));
		assertTrue((c.getStartDateFromCreated().getText()).equals(JavaUtil.getCurrentDate()));
}
}
