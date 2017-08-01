package IntegratedMailViewTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifySpam;

public class VerifySpamAllAccount extends BaseTest {
	@Test(priority=6)
	public void testMoveToSpamAllAccount()
	{ 
		MailPage m= new MailPage(driver);
		VerifySpam v= new VerifySpam(driver);
		m.clickmailCard();
		v.testMoveToSpam();
		}
	@Test(priority=7)
	public void testMarkAsNotSpamAllAccount()
	{ 
		VerifySpam v= new VerifySpam(driver);
		v.testMarkAsNotSpam();
	
	}
	@Test(priority=8)
	public void testBatchMovetoSpamAllAccount()
	{ 
		VerifySpam v= new VerifySpam(driver);
		v.TestBatchMovetoSpamOfEmail();
	
	}
	@Test(priority=9)
	public void testBatchMovetoInboxOfSpamAllAccount()
	{ 
		VerifySpam v= new VerifySpam(driver);
		v.TestBatchMovetoInboxOfSpamEmail();
	
	}

}
