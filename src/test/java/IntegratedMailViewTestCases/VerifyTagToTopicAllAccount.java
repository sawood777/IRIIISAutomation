package IntegratedMailViewTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifyTagToTopic;

public class VerifyTagToTopicAllAccount  extends BaseTest{
	
	@Test(priority=19)
	public void testTagToTopicAllAccount()
	{
		MailPage m= new MailPage(driver);
		VerifyTagToTopic v= new VerifyTagToTopic(driver);
		m.clickmailCard();
		v.testTagToTopic();
		}
	@Test(dependsOnMethods="testTagToTopicAllAccount")
	public void testBatchTagToTopicAllAccount()
	{ 
		VerifyTagToTopic v= new VerifyTagToTopic(driver);
		v.testBatchTagToTopic();
	
	}
	
	
	
	
}
