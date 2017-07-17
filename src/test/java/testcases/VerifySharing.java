package testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.IriiisLogoPage;
import Pages.MailPage;

public class VerifySharing extends BaseTest{
	
	@Test(priority=21)
	public void testTagToTopic()
	{
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		MailPage m= new MailPage(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		m.clickmailCard();
		List<WebElement> sub = m.GetemailSubjects();
		String s = sub.get(0).getText();
		m.clickFirstEmail();
		m.clickShareIcon();
		List<WebElement> topics = m.getTopicListInTagToTopic();
		String s1=topics.get(0).getText();
		topics.get(0).click();
		m.clickTopicSave();
		iriiis.clickIriiisLog();
		iriiis.clickTopicPicker();
		m.clickSearchBox();
		m.inputTopicname(s1);
		List<WebElement> r = m.getTopicSearchResults();
		for(int i=0;i<r.size();i++)
		{
			if(r.get(i).getText().equals(s1))
			{
				r.get(i).click();
				break;
			}
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.clickmailCard();
		List<WebElement> sub2 = m.GetemailSubjects();
		for(int i=0;i<sub2.size();i++)
		{
			if(sub2.get(i).getText().equals(s))
			{
				flag=true;
				break;
			}
		}
		Assert.assertEquals(flag==true, true, "Tag to Topic got failed");
		
	}

}
