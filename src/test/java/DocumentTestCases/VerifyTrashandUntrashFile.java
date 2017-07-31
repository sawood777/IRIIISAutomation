package DocumentTestCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Pages.DashboardPage;
import Pages.DocumentsPage;
import Pages.IriiisLogoPage;
import Pages.MailPage;

public class VerifyTrashandUntrashFile {
	
	WebDriver driver;
	
	public VerifyTrashandUntrashFile(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void VerifyTrashFile(String drivename){
		
		Boolean flag=false;
		MailPage m= new MailPage(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		d.clickDocumentCard();
		doc.ClickonDrive();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
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
		doc.ClickOnTrashFile();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		
		doc.ClickonDrive();
		
		System.out.println("Drive clicked");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Actions action1=new Actions(driver);
				action1.moveToElement(doc.NavigateToTrash()).build().perform();
				try {
					Thread.sleep(5000);
				} catch (Exception e1) {

				}
				//doc.NavigateToTrash().click();
				
				
		
		System.out.println("trash shows up");
		
		doc.clickonTrashButton2();
		System.out.println("navigated to trash sucessfully");
		
		List<WebElement> NamesofAllfile = doc.GetAllFileNames();
		for(int i=0;i<NamesofAllfile.size();i++)
		{
			if(NamesofAllfile.get(i).getText().equals(filename))
			{
				flag=true;
				break;
			}
		}
		doc.clickonCloseIcon();
		
		Assert.assertEquals(flag==true, true, "tras got failed");
		
		
	}

}
