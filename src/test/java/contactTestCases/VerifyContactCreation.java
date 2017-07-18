package contactTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ContactPage;
import Pages.DashboardPage;
import emailTestCases.BaseTest;

public class VerifyContactCreation extends BaseTest{
	
	
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
	
	@Test(priority=2)
	public void testCreateContact()
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
	
	
	}
	
	


