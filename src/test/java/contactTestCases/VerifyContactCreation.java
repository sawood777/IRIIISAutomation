package contactTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ContactPage;
import Pages.DashboardPage;
import emailTestCases.BaseTest;

public class VerifyContactCreation extends BaseTest{
	
	//Scenario 2: Creating quick contact
	@Test(priority=1)
	public void testContactQuickCreate()
	{
		boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		ContactPage c= new ContactPage(driver);
		c.clickQuickContactIcon();
		c.enterQuickContactName("1");
		c.enterQuickContactEmail("1@1.com");
		c.clickCreateButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d.clickContactCard();
		List<WebElement> sub1=c.getContactList();
		for(int i=0;i<sub1.size();i++)
		{
			
			if(sub1.get(i).getText().equals("1"))
			{
				flag=true;
				break;
			}
		}
		Assert.assertEquals((flag==true), true, "create contact is unsucessfully");
		
	
	
	}
	//Scenarios 1: Creating contact by searching the existing IRIIIS user
	@Test(priority=2)
	public void testCreateContactionBySearch()
	{
		boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		ContactPage c= new ContactPage(driver);
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
	
}
	
	
	@Test(priority=3)
	public void testCreateContactWithoutProfileSearch()
	{
		boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		ContactPage c= new ContactPage(driver);
		c.clickCreateIcon();
		c.enterDisplayName("praveen");
		c.enterEmailAddress("1@1.com");
		c.enterPhoneNumbar("9880186792");
		c.enterContactNote("note");
		c.enterContactTag("tag");
		c.clickCreateButton();
		List<WebElement> sub1=c.getContactList();
		for(int i=0;i<sub1.size();i++)
		{
			
			if(sub1.get(i).getText().equals("praveen"))
			{
				flag=true;
				break;
			}
		}
		Assert.assertEquals((flag==true), true, "create contact is unsucessfully");
	
}
	
	//Scenario 3: Attempting to create Contact without filling any fields
	@Test(priority=4)
	public void testCreateContactWithoutAnyfields()
	{
		ContactPage c= new ContactPage(driver);
		c.clickCreateIcon();
		c.clickCreateButton();
		c.verifyContactError();
		Assert.assertEquals(c.verifyContactError()==true, true, " Scenario 3: Attempting to create Contact without filling any fields FALIED");
		c.clickGoToContacts();
	
	}
	//Scenario: 4 Updating contact display name ,number, email , notes, tags
	@Test (priority=5)
	public void testUpdateContact()
	{
			boolean flag=false;
			ContactPage c= new ContactPage(driver);
			List<WebElement> sub1=c.getContactList();
			String name=sub1.get(0).getText();
			sub1.get(0).click();
			if(c.verifyUpdatePageLoaded())
			{
			c.clickUpdateContact();
			c.enterDisplayName("123");
			c.enterEmailAddress("21@12.com");
			c.enterPhoneNumbar("123455677");
			c.enterContactTag("he");
			c.enterContactNote("his");
			c.clickCreateButton();
			List<WebElement> sub2=c.getContactList();
			for(int i=0;i<sub2.size();i++)
			{
				
				if(sub2.get(i).getText().equals(name))
				{
					flag=true;
					break;
				}
			}
			Assert.assertEquals((flag==true), false, "Scenario: 4 Updating contact display name ,number, email , notes, tags got FAILED");
			
			
			
			}
			else
				Assert.fail("Contact edit page is not loading");
	}
	//Scenario 5: Deleting contact
	@Test(priority=6)
	public void testSingleContactDeletion()
	{
		boolean flag=false;
		ContactPage c= new ContactPage(driver);
		List<WebElement> sub1=c.getContactList();
		String name=sub1.get(0).getText();
		sub1.get(0).click();
		if(c.verifyUpdatePageLoaded())
		{
		c.clickContactDeletIcon();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.clickDelete();
		List<WebElement> sub2=c.getContactList();
		for(int i=0;i<sub1.size();i++)
		{
			
			if(sub2.get(i).getText().equals(name))
			{
				flag=true;
				break;
			}
		}
		Assert.assertEquals((flag==true), false, "Scenario 5: Deleting contact got FAILED");
		}
		else
			Assert.fail("Contact edit page is not loading");
	
	}
	
	}
	
	


