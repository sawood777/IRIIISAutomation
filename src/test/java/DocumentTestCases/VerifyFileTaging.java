package DocumentTestCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Pages.DashboardPage;
import Pages.DocumentsPage;
import Pages.IriiisLogoPage;
import Pages.MailPage;


public class VerifyFileTaging {
	
WebDriver driver;
	
	public  VerifyFileTaging(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void SelectAccount(String drivename)  
	{
		Boolean flag=false;
		MailPage m= new MailPage(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		d.clickDocumentCard();
		doc.ClickonDrive();
		doc.hoveronAllAccounts();
		doc.ClickonRequiredAccount(drivename);
		System.out.println("successfully clicked on link");
		String filename=doc.Filename();
		System.out.println(filename);
		try {
			Thread.sleep(3000);
		} catch (Exception e1) {

		}
		
		doc.clickelipse();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e1) {
		}
		
		doc.clickTagtoTopic();
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
		d.clickDocumentCard();
		
		List<WebElement> NamesofAllfile = doc.GetAllFileNames();
		for(int i=0;i<NamesofAllfile.size();i++)
		{
			if(NamesofAllfile.get(i).getText().equals(filename))
			{
				flag=true;
				break;
			}
		}
		
		Assert.assertEquals(flag==true, true, "Tag to Topic got failed");
		
		
		
	}

}
