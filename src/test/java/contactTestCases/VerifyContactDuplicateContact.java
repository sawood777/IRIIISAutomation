package contactTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ContactPage;
import Pages.DashboardPage;
import Pages.IriiisLogoPage;
import Pages.MailPage;
import emailTestCases.BaseTest;

public class VerifyContactDuplicateContact extends BaseTest {
	//Scenario: 13: Create a duplicate contact and verify whether the duplicate contact get auto merged [same name AND [ email OR phone] ] should match
	@Test(priority=1)
	public void testDuplicateContact()
	{
		int n=0;
		DashboardPage d= new DashboardPage(driver);
		ContactPage c= new ContactPage(driver);
		d.clickContactCard();
		List<WebElement> a = c.getContactList();
		String s=a.get(0).getText();
		System.out.println(s);
		c.clickCreateIcon();
		c.enterProfileseachKey(s);
		List<WebElement> result = c.getProfileSearchResult();
		String profileName = result.get(0).getText();
		result.get(0).click();
		c.clickCreateButton();
		List<WebElement> sub1=c.getContactList();
		for(int i=0;i<sub1.size();i++)
		{
			
			if(sub1.get(i).getText().equals(profileName))
			{
				n=n+1;
			}
		}
		
		Assert.assertEquals((n==1), true, "Auto duplicate merge is not working");
		

	}
	//Scenario: 14: Initiating the One to One chat from the contact
	@Test(priority=2)
	public void testInitiatingContactForOneOnOneChat()
	{
	
		ContactPage c= new ContactPage(driver);
		if(c.verifyChatButton())
		{
			c.clickChatButton();
		}
		if(c.verifyTextArea())
			{
				System.out.println("Success");
			}
			else
				Assert.assertTrue(c.verifyTextArea(), "Initiating the One to One chat from the contact failed");
	}
	@Test(priority=3)
	public void testCreatingContactGroup()
	{
		boolean flag=false;
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		DashboardPage d= new DashboardPage(driver);
		ContactPage c= new ContactPage(driver);
		MailPage m=new MailPage(driver);
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		d.clickContactCard();
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
		for(int i=1;i<8;i++)
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
	
	//Scenario: 15 : Deleted contact should be removed from all the contact group
	@Test(priority=4)
	public void testContactRemovalFromGroupWhenContactDeleted()
	{
		String p1 = null;
	boolean flag=false;
	
	ContactPage c= new ContactPage(driver);
	
	List<WebElement> q = c.getContactGroupList();
	String qtext= q.get(0).getText();
	
	if(qtext.isEmpty())
	{
		System.out.println("Contact Group List is empty for this group");
	}
	else
	{ 		q.get(0).click();
		List<WebElement> list1 = c.getContactList();
		if(list1.size()>0)
		{
			p1=list1.get(0).getText();
		}
	}
	c.clickGoToContacts();
	c.clickContactFilter();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 c.clickGroupOptions().click();
	
	List<WebElement> l = c.getContactFilters();
	l.get(0).click();
	System.out.println("Value of P1   === "+p1);
	List<WebElement> contactlist = c.getContactList();
	for(int i=0;i<contactlist.size();i++)
	{
		if(contactlist.get(i).getText().equals(p1))
		{
			contactlist.get(i).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.clickContactDeletIcon();
			c.clickDelete();
			break;
		}
	}
	c.clickContactFilter();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 c.clickFilterOptions().click();
	 List<WebElement> s1 = c.getContactFilters();
		s1.get(1).click();
		List<WebElement> q1 = c.getContactGroupList();
		q1.get(0).click();
		List<WebElement> list1 = c.getContactList();
		for (int i=0;i<list1.size();i++)
		{
			if(list1.get(i).getText().equals(p1))
			{
				flag=true;
				break;
			}
		}
	
		Assert.assertEquals(flag==false, true, "ContactGroup creation Failed");

	}
}

