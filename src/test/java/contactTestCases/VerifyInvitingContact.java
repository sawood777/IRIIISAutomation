package contactTestCases;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.ContactPage;
import Pages.DashboardPage;
import Pages.MailPage;
import emailTestCases.BaseTest;

public class VerifyInvitingContact extends BaseTest {
	
		
		//Scenario 9: Inviting non IRIIIS contact to join IIRIIIS
		@Test(priority=1)
		public void testInvitingContact()
		{
		
			DashboardPage d= new DashboardPage(driver);
			ContactPage c= new ContactPage(driver);
			d.clickContactCard();
			if(c.verifyInviteButton())
			{
				c.clickInviteButton();
				
				if(c.verifyToastNotification())
				{
					System.out.println("Invitation sent successfully");	
				}
				else
				{
					Assert.fail("Invitation not sent");
				}
				} 
			else
				System.out.println("There is no invite option present in the contact");
			
			
		}
		
	
	//Scenario 10: Creating groups under contact and added contacts to the group
	@Test(priority=2)
	public void testCreatingContactGroup()
	{
		
		boolean flag=false;
		ContactPage c= new ContactPage(driver);
		MailPage m=new MailPage(driver);
		c.clickContactFilter();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 c.clickFilterOptions().click();
		
		List<WebElement> s = c.getContactFilters();
		s.get(1).click();
		c.clickCreateIcon1();
		c.enterGroupName("morotoda");
		c.clickContactPicker();
		Actions action1=new Actions(driver);
		action1.moveToElement(c.hoverContactList()).click().build().perform();
		List<WebElement> box = m.getListOfCheckBox();
		for(int i=1;i<4;i++)
		{
			box.get(i).click();
		}
		c.clickAddToContact();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		c.clickCreateButton();
		
		List<WebElement> q = c.getContactGroupList();
				for(int i=0;i<q.size();i++)
				{
					if(q.get(i).getText().contains("morotoda"))
					{
						flag=true;;
					}
				}
				
				Assert.assertEquals(flag==true, true, "ContactGroup creation Failed");
	}
	//Scenario: 11: Inserting and deleting the contacts inside the group
	@Test(priority=3)
	public void testUpdateContactGroup()
	{
		
		boolean flag=false;
		ContactPage c= new ContactPage(driver);
		MailPage m=new MailPage(driver);
		List<WebElement> q = c.getContactGroupList();
				for(int i=0;i<q.size();i++)
				{
					if(q.get(i).getText().contains("morotoda"))
					{
						q.get(i).click();
						break;
					}
				}
		c.clickUpdateGroupicon();	
		c.enterGroupName("click");
		c.clickRemoveContactIcon();
		c.clickContactPicker1();
		
		Actions action1=new Actions(driver);
		action1.moveToElement(c.hoverContactList()).click().build().perform();
		c.clickAddToContact();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		c.clickCreateButton();
		c.clickGoToContacts();
		List<WebElement> r = c.getContactGroupList();
		for(int i=0;i<q.size();i++)
		{
			if(r.get(i).getText().contains("click"))
			{
				flag=true;
			}
		}
		Assert.assertEquals(flag==true, true, "ContactGroup updation Failed");
		}
	//Scenario 12: Deleting contact group
	@Test(priority=4)
	public void testContactGroupDeletion()
	{
		
		boolean flag=false;
		ContactPage c= new ContactPage(driver);
		List<WebElement> q = c.getContactGroupList();
				for(int i=0;i<q.size();i++)
				{
					if(q.get(i).getText().contains("click"))
					{
						q.get(i).click();
						break;
					}
				}
		c.clickDeleteGroupIcon();	
		c.clickDeleteInConformationPopUp();
		
		List<WebElement> r = c.getContactGroupList();
		for(int i=0;i<q.size();i++)
		{
			if(r.get(i).getText().contains("click"))
			{
				flag=true;
			}
		}
		Assert.assertEquals(flag==false, true, "ContactGroup updation Failed");
		}
}