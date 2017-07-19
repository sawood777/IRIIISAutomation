package IntegratedMailViewTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifyReadUnread;

public class VerifyReadUnreadAllAccount extends BaseTest {
	
	@Test(priority=16)
	public void testMarkAsUnreadAllAccount()
	{ 
		MailPage m= new MailPage(driver);
		VerifyReadUnread v= new VerifyReadUnread(driver);
		m.clickmailCard();
		v.testMarkAsUnread();
		}
	@Test(dependsOnMethods="testMarkAsUnreadAllAccount")
	public void testBatchUnreadAllAccount()
	{ 
		VerifyReadUnread v= new VerifyReadUnread(driver);
		v.testBatchUnread();
	
	}
	@Test(priority=18)
	public void testBatchReadAllAccount()
	{ 
		VerifyReadUnread v= new VerifyReadUnread(driver);
		v.testBatchRead();
	
	}
	

}
