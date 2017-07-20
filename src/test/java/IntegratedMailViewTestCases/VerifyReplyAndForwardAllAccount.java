package IntegratedMailViewTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifyReplyAndForwardingEmail;

public class VerifyReplyAndForwardAllAccount extends BaseTest{
	

	@Test
public void testVerifyReplyEmailAllaccount()
{ 
	MailPage m= new MailPage(driver);
	
	VerifyReplyAndForwardingEmail v= new VerifyReplyAndForwardingEmail(driver);
	m.clickmailCard();
	v.testReply("Reply","Replying to Email");
}
	@Test(dependsOnMethods="testVerifyReplyEmailAllaccount")
	public void testVerifyForwardAllaccount()
	{ 
		MailPage m= new MailPage(driver);
		
		VerifyReplyAndForwardingEmail v= new VerifyReplyAndForwardingEmail(driver);
		m.clickMailFilter();
		m.clickUnProcessedFilter();
		v.testReply("Forward","Forwarding to Email");
		
	}
	@Test(dependsOnMethods="testVerifyForwardAllaccount")
	public void testVerifyReplyAllAllaccount()
	{ 
		MailPage m= new MailPage(driver);
		
		VerifyReplyAndForwardingEmail v= new VerifyReplyAndForwardingEmail(driver);
		m.clickMailFilter();
		m.clickUnProcessedFilter();
		v.testReplyAll("ReplyAll to Email");
		
	}

}
