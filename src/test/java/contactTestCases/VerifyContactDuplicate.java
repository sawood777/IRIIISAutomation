package contactTestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.ContactPage;
import Pages.DashboardPage;
import emailTestCases.BaseTest;

public class VerifyContactDuplicate extends BaseTest{
	
	//Scenario:18  Finding the duplicate contacts and merging them
	@Test(priority=1)
	public void testDuplicateContact()
	{
		DashboardPage d= new DashboardPage(driver);
		ContactPage c= new ContactPage(driver);
		SoftAssert softAssert = new SoftAssert();
		 d.clickContactCard();
		c.clickMoreIcon();
		List<WebElement> o = c.getoptionsUnderMore();
		for(int i=0;i<o.size();i++)
		{
			if(o.get(i).getText().equals("Find and Merge Duplicates"))
			{
				o.get(i).click();
				break;
			}
		}
		
		if(c.verifyToastNotification())
		{
			System.out.println("Contacts internal server error ");
			c.clickGoToContacts();
			softAssert.fail("Something went wrong");
		}
		else if(c.verifynoDuplicatesFound())
		{
			System.out.println("No duplicate contacts found");
			softAssert.assertFalse(c.verifynoDuplicatesFound(), "No duplicates found");
			c.clickGoToContacts();
		}
		else
		{
			c.clickMergeAll();
			if(c.verifynoDuplicatesFound())
			{
				System.out.println("MergeAll is working");
				c.clickGoToContacts();
			}
			else
			{
				Assert.fail("Mergeall got failed");
			}
		}
		

}
	//Sorting contact by Name
	//@Test(priority=2)
	public void testSortByName()
	{
		ContactPage c= new ContactPage(driver);
		c.clickContactFilter();
		List<WebElement> r = c.getSortOptions();
		r.get(0).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> s = c.getContactList();
		
		for(int i=1;i<s.size();i++)
		{
			if(s.get(i).getText().toLowerCase().compareTo(s.get(i - 1).getText().toLowerCase()) >= 0)
			{
				//System.out.println("Contacts are sorted");
			}
			else
			{
				Assert.fail("Contacts are not sorted");
			}
 }
		
	}
	
	//Sorting contact byRecency
	//	@Test(priority=3)
		public void testSortByRecency()
		{
			Boolean flag=false;
			ContactPage c= new ContactPage(driver);
			//Contact Creation Logic
			c.clickCreateIcon();
			c.enterProfileseachKey("devuser");
			List<WebElement> result = c.getProfileSearchResult();
			String profileName = result.get(0).getText();
			result.get(0).click();
			c.clickCreateButton();
			List<WebElement> sub1=c.getContactList();
			for(int i=0;i<sub1.size();i++)
			{
				
				if(sub1.get(i).getText().equals(profileName))
				{
					flag=true;
					break;
				}
			}
			Assert.assertEquals((flag==true), true, "create contact is unsucessfully");
			
			//End of Contact creation logic
			//iRecency validation logic
			c.clickContactFilter();
			List<WebElement> r = c.getSortOptions();
			r.get(1).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> s = c.getContactList();
			
			if(s.get(0).getText().equals("devuser"))
			{
				System.out.println("Contacts are sorted by recency");
			}
			else
				{
				Assert.fail("Contact are not sorted by recency");
				}
			
			
		}
		
		//@Test(priority=2)
		public void testExportContact()
		{
			ContactPage c= new ContactPage(driver);
			c.clickMoreIcon();
			c.clickExportOption().click();
			c.clickCSVExport();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Runtime.getRuntime().exec("D:\\AutoIT Script\\Test.exe");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Test(priority=2)
		public void testImportCSVContact() throws InterruptedException
		{
			ContactPage c= new ContactPage(driver);
			c.clickMoreIcon();
			
			c.clickImportContact().click();
			List<WebElement> l = c.getImportTypes();
					l.get(0).click();	
			c.clickSelectFromComputer();
			try {
				Runtime.getRuntime().exec("D:\\AutoIT Script\\FileUpload.exe");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			c.clickUpload();
			
			
		}
		@Test(priority=3)
		public void testImportGoogleCSVContact()
		{
			ContactPage c= new ContactPage(driver);
			c.clickMoreIcon();
			c.clickImportContact().click();
			List<WebElement> l = c.getImportTypes();
					l.get(1).click();	
			c.clickSelectFromComputer();
			try {
				Runtime.getRuntime().exec("D:\\AutoIT Script\\FileUploadGoogleCSV.exe");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			c.clickUpload();
			c.getNumberOfContacts();
		}
		
		@Test(priority=4)
		public void testImportOutlookCSVContact()
		{
			ContactPage c= new ContactPage(driver);
			c.clickMoreIcon();
			c.clickImportContact().click();
			List<WebElement> l = c.getImportTypes();
					l.get(2).click();	
			c.clickSelectFromComputer();
			try {
				Runtime.getRuntime().exec("D:\\AutoIT Script\\FileUploadOutlookCSV.exe");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			c.clickUpload();
			c.getNumberOfContacts();
		}
		@Test(priority=5)
		public void testImportVCFContact()
		{
			ContactPage c= new ContactPage(driver);
			c.clickMoreIcon();
			c.clickImportContact().click();
			List<WebElement> l = c.getImportTypes();
					l.get(3).click();	
			c.clickSelectFromComputer();
			try {
				Runtime.getRuntime().exec("D:\\AutoIT Script\\FileUploadVCF.exe");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			c.clickUpload();
			c.getNumberOfContacts();
		}
		
}
