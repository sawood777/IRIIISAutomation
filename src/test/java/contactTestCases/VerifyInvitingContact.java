package contactTestCases;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Pages.ContactPage;
import Pages.DashboardPage;
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
		ContactPage c= new ContactPage(driver);
		c.clickContactFilter();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> opt = c.getContactFilterOptions();
		for(int i=0;i<opt.size();i++)
		{
			System.out.println(opt.get(i).getText());
		}
	}
	
}