package iriiisMailTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifySpam;

public class VerifySpamIRIIIS extends BaseTest {
	@Test(priority=6)
	public void testMoveToSpamIRIIIS()
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
		v.testMoveToSpam();
		}
	@Test(priority=7)
	public void testMarkAsNotSpamIRIIIS()
	{ 
		VerifySpam v= new VerifySpam(driver);
		v.testMarkAsNotSpam();
	
	}
	@Test(priority=8)
	public void testBatchMovetoSpamIRIIIS()
	{ 
		VerifySpam v= new VerifySpam(driver);
		v.TestBatchMovetoSpamOfEmail();
	
	}
	@Test(priority=9)
	public void testBatchMovetoInboxOfSpamIRIIIS()
	{ 
		VerifySpam v= new VerifySpam(driver);
		v.TestBatchMovetoInboxOfSpamEmail();
	
	}

}
