package GmailTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifySpam;

public class VerifySpamGmail extends BaseTest {
	@Test(priority=6)
	public void testMoveToSpamGmail()
	{ 
		MailPage m= new MailPage(driver);
		VerifySpam v= new VerifySpam(driver);
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
			if(acc.get(i).getText().contains("@gmail.com"))
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
		v.testMoveToSpam();
		}
	@Test(priority=7)
	public void testMarkAsNotSpamGMail()
	{ 
		VerifySpam v= new VerifySpam(driver);
		v.testMarkAsNotSpam();
	
	}
	@Test(priority=8)
	public void testBatchMovetoSpamGmail()
	{ 
		VerifySpam v= new VerifySpam(driver);
		v.TestBatchMovetoSpamOfEmail();
	
	}
	@Test(priority=9)
	public void testBatchMovetoInboxOfSpamGmail()
	{ 
		VerifySpam v= new VerifySpam(driver);
		v.TestBatchMovetoInboxOfSpamEmail();
	
	}

}
