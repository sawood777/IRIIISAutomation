package testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.MailPage;

public class VerifyEmail1 extends BaseTest{

		
		@Test(priority=6)
		public void testMoveToSpam()
		{
			Boolean flag=false;
			DashboardPage d= new DashboardPage(driver);
			MailPage m= new MailPage(driver);
			d.clickMailCard();
			List<WebElement> sub=m.GetemailSubjects();
			String subj=sub.get(0).getText();
			m.clickFirstEmail();
			m.clickSpamIcon();
			m.clickMailFilter();
			m.clickSpamFilter();
			List<WebElement> sub1=m.GetemailSubjects();
			for(int i=0;i<sub1.size();i++)
			{
				
				if(sub1.get(i).getText().equals(subj))
				{
					flag=true;
					break;
				}
			}
			Assert.assertEquals((flag==true), true, "Email moved to spam unsucessfully");
			
		}
		@Test(priority=7)
		public void testMarkAsNotSpam()
		{
			Boolean flag=false;
			MailPage m= new MailPage(driver);
			List<WebElement> sub=m.GetemailSubjects();
			String subj=sub.get(0).getText();
			m.clickFirstEmail();
			m.clickNotSpam();
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
			Assert.assertEquals((flag==true), true, "Email moved to inbox unsucessfully");
			
		}
		
		
		@Test(priority=8)
		//Only 3 or less than 3 mails are been batch selected
		public void TestBatchMovetoSpamOfEmail()
		{
			Boolean flag=false;
			
			
			
			MailPage m= new MailPage(driver);
		
			List<WebElement> sub=m.GetemailSubjects();
			String[] myStringArray = new String[sub.size()];
			for(int i=0;i<sub.size();i++)
			{
				myStringArray[i]=sub.get(i).getText();
				
			}
		
			Actions action = new Actions(driver); 
			 action.moveToElement(m.batchSelection()).click().build().perform();
			 m.clickSelectAll();
			m.clickSpamIcon();
			m.clickMailFilter();
			m.clickSpamFilter();
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
			
			Assert.assertEquals(flag==true, true, "Email Batch Operation for Spam failed");
			
		}
		
		@Test(priority=9)
		//Only 3 or less than 3 mails are been batch selected
		public void TestBatchMovetoInboxOfSpamEmail()
		{
			int n=0;
			MailPage m= new MailPage(driver);
			List<WebElement> sub=m.GetemailSubjects();
			String[] myStringArray = new String[sub.size()];
			for(int i=0;i<sub.size();i++)
			{
				myStringArray[i]=sub.get(i).getText();
				
			}
			Actions action = new Actions(driver); 
			action.moveToElement(m.batchSelection()).click().build().perform();
			List<WebElement> box = m.getListOfCheckBox();
			m.clickSelectAll();
			m.clickNotSpam();
			m.clickMailFilter();
			m.clickUnProcessedFilter();
			List<WebElement> sub1=m.GetemailSubjects();
			for(int i=0;i<sub1.size();i++)
			{
				for(int j=0;j<myStringArray.length;j++)
				{
				if(sub1.get(i).getText().equals(myStringArray[j]))
				{
					n= n+1;
					break;
				}
			}
			}
			Assert.assertEquals(((n>0)&&(n<=myStringArray.length)), true, "Email Batch Move to Inbox of Spam email got failed");
			
		}

}

