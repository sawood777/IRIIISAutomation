package iriiisMailTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifyTagToTopic;

public class VerifyTagToTopicIRIIIS  extends BaseTest{
	
	@Test(priority=19)
	public void testTagToTopicIRIIIS()
	{
		MailPage m= new MailPage(driver);
		VerifyTagToTopic v= new VerifyTagToTopic(driver);
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
		v.testTagToTopic();
		}
	@Test(dependsOnMethods="testTagToTopicIRIIIS")
	public void testBatchTagToTopicGmail()
	{ 
		VerifyTagToTopic v= new VerifyTagToTopic(driver);
		v.testBatchTagToTopic();
	
	}
	
	
	
	
}
