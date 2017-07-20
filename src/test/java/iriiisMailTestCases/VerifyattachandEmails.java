package iriiisMailTestCases;

import org.testng.annotations.Test;

import emailTestCases.BaseTest;
import emailTestCases.VerifySentEmails;

public class VerifyattachandEmails extends BaseTest {
	
	@Test
	public void VeiryAttachments(){
		VerifySentEmails  attach=new VerifySentEmails(driver);
		attach.VerifyAttachment();	
	}

}
