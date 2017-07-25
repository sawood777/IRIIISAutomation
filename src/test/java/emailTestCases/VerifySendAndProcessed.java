package emailTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.DashboardPage;
import Pages.MailPage;
import Utility.Reporting;
import Utility.Screenshots;


public class VerifySendAndProcessed {
	WebDriver driver;
	
	public VerifySendAndProcessed(WebDriver driver) {
		this.driver=driver;
	}
	
	
	@Test(priority=1)
	public void testVerifySendingEmail()
	{
		
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		MailPage m= new MailPage(driver);
		d.clickMailCard();
		m.clickComposeIcon();
		//logger.log(LogStatus.INFO, "email opened");
		m.enterToAddreess("devuser1@iriiisdev.com");
		m.enterSubject("String12233");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.enterEmailBody("hey how are you");
		m.clickSendButton();
		//logger.log(LogStatus.INFO, "email send");
		
		m.clickMailFilter();
		m.clickSentFilter();
		
		
		
		List<WebElement> sub=m.GetemailSubjects();
		for(int i=0;i<sub.size();i++)
		{
			
			if(sub.get(i).getText().contains("String12"))
			{
				flag=true;
				break;
			}
		}
		Assert.assertEquals((flag==true), true, "Email not sent");
		
		//logger.log(LogStatus.PASS, "email filter is done");
		
	}
	
//@Test(priority=2)
	/*public void test(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			
		logger.log(LogStatus.FAIL, logger.addScreenCapture(Screenshots.TakeScreenshot(driver, result.getName())));
		}
		report.endTest(logger);
		report.flush();
	}*/
	

	@Test(priority=2)
	public void TestProcessingOfEmail()
	{
		boolean flag=false;
		MailPage m= new MailPage(driver);
		m.clickMailFilter();
		m.clickUnProcessedFilter();
		List<WebElement> sub=m.GetemailSubjects();
		String subj=sub.get(0).getText();
		System.out.println(subj);
		//logger.log(LogStatus.INFO, "Unprossedd page");
		m.clickFirstEmail();
		m.clickProcessUnProcessedIcon();
		m.clickMailFilter();
		m.clickProcessedFilter();
	
		//logger.log(LogStatus.INFO, "Pprossedd page");
		List<WebElement> sub1=m.GetemailSubjects();
		for(int i=0;i<sub1.size();i++)
		{
			
			if(sub1.get(i).getText().equals(subj))
			{
				System.out.println(sub1.get(i));
				flag=true;
				break;
			}
		}
	
		Assert.assertEquals((flag==true), true, "Email processing Failed   "+ subj +"  not found in processed list");
		
		//logger.log(LogStatus.PASS, "Processing is completed");
		
	}
	
	@Test(priority=3)
	public void TestUnProcessingOfEmail()
	{
		

		boolean flag=false;
		MailPage m= new MailPage(driver);
		
		List<WebElement> sub=m.GetemailSubjects();
		String subj=sub.get(0).getText();
		m.clickFirstEmail();
		m.clickProcessUnProcessedIcon();
		m.clickMailFilter();
		m.clickUnProcessedFilter();
		
		
		List<WebElement> sub1=m.GetemailSubjects();
		for(int i=0;i<sub1.size();i++)
		{
			
			if(sub1.get(i).getText().equals(subj))
			{
				flag=true;
				break;
			}
		}
		
		Assert.assertEquals((flag==true), true, "Email Unprocessing Failed   "+ subj +"  not found in processed list");
		
		//logger.log(LogStatus.PASS, "Unprocessed is completed");
	}
	
	@Test(priority=4)
	public void TestBatchProcessingOfEmail()
	{
		int n=0;

		MailPage m= new MailPage(driver);
		m.clickMailFilter();
		m.clickUnProcessedFilter();
		List<WebElement> sub=m.GetemailSubjects();
		String[] myStringArray = new String[4];
		for(int i=0;i<4;i++)
		{
			myStringArray[i]=sub.get(i).getText();
			
		}
		 Actions action = new Actions(driver); 
		 action.moveToElement(m.batchSelection1()).click().build().perform();
		List<WebElement> box = m.getListOfCheckBox();
		for(int i=1;i<4;i++)
		{
			box.get(i).click();
		}
		
		//logger.log(LogStatus.INFO, "All emails are selected");
		m.clickProcessUnProcessedIcon();
		m.clickMailFilter();
		m.clickProcessedFilter();
		
		
		List<WebElement> sub1=m.GetemailSubjects();
		for(int i=0;i<sub1.size();i++)
		{
			for(int j=0;j<myStringArray.length;j++)
			{
			if(sub1.get(i).getText().equals(myStringArray[j]))
			{
				n=n+1;
				break;
			}
		}
		}
		Assert.assertEquals(((n>0)&&(n<=myStringArray.length)), true, "Email Batch processing Failed");
		
		//logger.log(LogStatus.PASS, "batch process is completed");
	}
	
	@Test(priority=5)
	public void TestBatchUnProcessingOfEmail()
	{
		boolean flag=false;

		MailPage m= new MailPage(driver);	
		List<WebElement> sub=m.GetemailSubjects();
		String[] myStringArray = new String[4];
		for(int i=0;i<4;i++)
		{
			myStringArray[i]=sub.get(i).getText();
			
		}
		Actions action = new Actions(driver); 
		 action.moveToElement(m.batchSelection1()).click().build().perform();
		 List<WebElement> box = m.getListOfCheckBox();
			for(int i=1;i<4;i++)
			{
				box.get(i).click();
			}
		 
		// logger.log(LogStatus.INFO, "all mail selected");
		 
		m.clickProcessUnProcessedIcon();
		m.clickMailFilter();
		m.clickUnProcessedFilter();
		
		
		List<WebElement> sub1=m.GetemailSubjects();
		for(int i=0;i<sub1.size();i++)
		{
			for(int j=0;j<myStringArray.length;j++)
			{
			if(sub1.get(i).getText().equals(myStringArray[j]))
			{
				flag=true;
				break;
			}
		}
		}
		
		Assert.assertEquals(flag==true, true, "Email Batch Unprocessing Failed");
		
		//logger.log(LogStatus.PASS, "batch Unprocess is completed");
	}

	}
	


