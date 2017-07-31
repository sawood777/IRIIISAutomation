package IntegratedMailViewTestCases;

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

public class VerifySendingEmailAndProcessingAllAccount extends BaseTest {
	
	@Test(priority=1)
	public void testVerifySendingEmailAllAccount()
	{ 
		MailPage m= new MailPage(driver);
		VerifySendAndProcessed v= new VerifySendAndProcessed(driver);
		v.testVerifySendingEmail();
		
	}
	@Test(priority=2)
	public void testProcessingEmailAllAccount()
	{ 
	VerifySendAndProcessed v= new VerifySendAndProcessed(driver);
	v.TestProcessingOfEmail();
	}
	
	@Test(priority=3)
	public void testUnProcessingEmailAllAccount()
	{ 
	VerifySendAndProcessed v= new VerifySendAndProcessed(driver);
	v.TestUnProcessingOfEmail();
	}
	
	@Test(priority=4)
	public void testBatchProcessingEmailAllAccount()
	{ 
	VerifySendAndProcessed v= new VerifySendAndProcessed(driver);
	v.TestBatchProcessingOfEmail();
	}
	@Test(priority=5)
	public void testBatchUnProcessingEmailAllAccount()
	{ 
	VerifySendAndProcessed v= new VerifySendAndProcessed(driver);
	v.TestBatchUnProcessingOfEmail();
	}
	}
