package vtiger;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import FIleUtility.ExcelForVtiger;
import baseClass.BaseClassForVtiger;
import javaUtility.JavaUtil;
import pom.Organizations;
import pom.VtigerHome;

public class Task7 extends BaseClassForVtiger{

	@Test 
	public void testCase7() throws EncryptedDocumentException, IOException
	{
		VtigerHome h = new VtigerHome(driver);
		ExcelForVtiger eUtil = new ExcelForVtiger();
		Organizations org = new Organizations(driver);
		h.organizations();
		org.plusIcon();	
		String orgName = eUtil.getData("vtigerExcel", 0, 1);
		org.organizationName(orgName+JavaUtil.generateRandomNumber(10000));
		String industry = eUtil.getData("vtigerExcel", 1, 1);
		org.getassign().click();;
		org.group();
		org.assignedto(eUtil.getData("vtigerExcel", 1, 1));
		org.saveBtn();
		assertTrue((org.getCreatedOrgText().getText()).contains(orgName));
		assertTrue(!(org.getIndustryText().getText()).contains(industry));
	}
}
