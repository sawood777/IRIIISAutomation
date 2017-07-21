package iriiisMailTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifyReplyAndForwardingEmail;

public class VerifyReplyAndForwardIRIIIS extends BaseTest{
	

	@Test(priority=1)
public void testVerifyForwardIRIIIS()
{ 
	MailPage m= new MailPage(driver);
	
	VerifyReplyAndForwardingEmail v= new VerifyReplyAndForwardingEmail(driver);
	m.clickmailCard();
	m.clickMailFilter();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Actions action = new Actions(driver); 
	 action.moveToElement(m.hoverAllaccount()).build().perform();
	 try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	List<WebElement> acc = m.getAccountList();
	for(int i=0;i<acc.size();i++)
	{
		if(acc.get(i).getText().contains("@iriiis"))
		{
		acc.get(i).click();
		break;
		}
	}
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	v.testReply("Forward","Forwarding to Email");
}
	@Test(priority=2)
	public void testVerifyReplyEmailIRIIIS()
	{ 
		MailPage m= new MailPage(driver);
		
		VerifyReplyAndForwardingEmail v= new VerifyReplyAndForwardingEmail(driver);
		m.clickMailFilter();
		m.clickUnProcessedFilter();
		v.testReply("Reply","Replying to Email");
		
	}
	
	@Test(dependsOnMethods="testVerifyForwardIRIIIS")
	public void testVerifyReplyAllIRIIIS()
	{ 
		MailPage m= new MailPage(driver);
		
		VerifyReplyAndForwardingEmail v= new VerifyReplyAndForwardingEmail(driver);
		m.clickMailFilter();
		m.clickUnProcessedFilter();
		v.testReplyAll("ReplyAll to Email");
		
	}

}
