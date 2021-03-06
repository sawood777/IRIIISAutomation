package iriiisMailTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifyReadUnread;

public class VerifyReadUnreadIRIIIS extends BaseTest {
	
	@Test(priority=16)
	public void testMarkAsUnreadIRIIIS()
	{ 
		MailPage m= new MailPage(driver);
		VerifyReadUnread v= new VerifyReadUnread(driver);
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
		v.testMarkAsUnread();
		}
	@Test(dependsOnMethods="testMarkAsUnreadIRIIIS")
	public void testBatchUnreadIRIIIS()
	{ 
		VerifyReadUnread v= new VerifyReadUnread(driver);
		v.testBatchUnread();
	
	}
	@Test(priority=18)
	public void testBatchReadIRIIIS()
	{ 
		VerifyReadUnread v= new VerifyReadUnread(driver);
		v.testBatchRead();
	
	}
	

}
