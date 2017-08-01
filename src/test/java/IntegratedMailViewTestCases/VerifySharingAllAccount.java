package IntegratedMailViewTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifySharing;
import emailTestCases.VerifySpam;

public class VerifySharingAllAccount extends BaseTest {
	
	@Test(priority=21)
	public void testShareToTopicAllAccount()
	{ 
		MailPage m= new MailPage(driver);
		VerifySharing v= new VerifySharing(driver);
		m.clickmailCard();
		v.testShareToTopic();
		}

}
