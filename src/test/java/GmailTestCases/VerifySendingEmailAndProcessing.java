package GmailTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.DashboardPage;
import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifySendAndProcessed;

public class VerifySendingEmailAndProcessing extends BaseTest {
	
	@Test(priority=1)
	public void testVerifySendingEmailGmail()
	{ 
		MailPage m= new MailPage(driver);
		VerifySendAndProcessed v= new VerifySendAndProcessed(driver);
		v.testVerifySendingEmail();

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
		}
	@Test(priority=2)
	public void testProcessingEmailGMail()
	{ 
	VerifySendAndProcessed v= new VerifySendAndProcessed(driver);
	v.TestProcessingOfEmail();
	}
	
	@Test(priority=3)
	public void testUnProcessingEmailGMail()
	{ 
	VerifySendAndProcessed v= new VerifySendAndProcessed(driver);
	v.TestUnProcessingOfEmail();
	}
	
	@Test(priority=4)
	public void testBatchProcessingEmailGMail()
	{ 
	VerifySendAndProcessed v= new VerifySendAndProcessed(driver);
	v.TestBatchProcessingOfEmail();
	}
	@Test(priority=5)
	public void testBatchUnProcessingEmailGMail()
	{ 
	VerifySendAndProcessed v= new VerifySendAndProcessed(driver);
	v.TestBatchUnProcessingOfEmail();
	}
	}
