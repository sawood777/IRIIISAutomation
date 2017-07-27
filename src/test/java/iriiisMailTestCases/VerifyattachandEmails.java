package iriiisMailTestCases;

import org.testng.annotations.Test;

import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifySentEmails;

public class VerifyattachandEmails extends BaseTest {
	
	@Test(priority=1)
	public void VeiryAttachments(){
		VerifySentEmails  attach=new VerifySentEmails(driver);
		attach.VerifyAttachment();	
		
	}
	
	
	@Test(priority=2)
	public void VerifyReplyAttachments(){
		VerifySentEmails  attach=new VerifySentEmails(driver);
		attach.ReplyAndForwardwithAttach("Reply", "Replytoall");
	}
	
	@Test(priority=3)
	public void VerifyForwardAttachments(){
		MailPage m= new MailPage(driver);
		
		m.clickMailFilter();
		m.clickUnProcessedFilter();
		VerifySentEmails  attach=new VerifySentEmails(driver);
		attach.ReplyAndForwardwithAttach("Forward", "Forwar to mail");
	}
	
	@Test(priority=4)
	public void VerifyReplyallwithAttachment(){
		MailPage m= new MailPage(driver);
		//m.clickmailCard();
		VerifySentEmails  attach=new VerifySentEmails(driver);
		attach.testReplyAllwithAttachment("Replying to all with attachment");
		
		
	}
	
	
	

}
