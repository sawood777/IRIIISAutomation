package emailTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.IriiisLogoPage;
import Pages.MailPage;

public class VerifyTagToTopic{
	WebDriver driver;
	public VerifyTagToTopic(WebDriver driver) {
		this.driver=driver;
	}
	
	@Test(priority=19)
	public void testTagToTopic()
	{
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		MailPage m= new MailPage(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		//m.clickmailCard();
		List<WebElement> sub = m.GetemailSubjects();
		String s = sub.get(0).getText();
		m.clickFirstEmail();
		m.clickTagToTopic();
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

	@Test(priority=20)
	public void testBatchTagToTopic()
	{
		int n=0;
		DashboardPage d= new DashboardPage(driver);
		MailPage m= new MailPage(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		m.clickmailCard();
		List<WebElement> sub = m.GetemailSubjects();
		String[] subArray = new String[4];
		for(int i=0;i<=3;i++)
		{
			subArray[i]=sub.get(i).getText();
		}
		Actions action = new Actions(driver); 
		action.moveToElement(m.batchSelection1()).click().build().perform();
		List<WebElement> box = m.getListOfCheckBox();
		for(int i=1;i<4;i++)
		{
			box.get(i).click();
		}
		m.clickTagToTopic();
		List<WebElement> topics = m.getTopicListInTagToTopic();
		String s1=topics.get(0).getText();
		System.out.println(topics.get(0).getText());
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
				System.out.println(r.get(i).getText());
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
			for(int j=0;j<subArray.length;j++)
			{
				if(sub2.get(i).getText().equals(subArray[j]))
				{
					n=n+1;
				}
			}
		}
		Assert.assertEquals(((n>0)&&(n<=subArray.length)), true, "Batch Tag to Topic got failed");
		
}
	
	
}
