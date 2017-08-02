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
		doc.SleepThreeSec();
		
		doc.hoveronAllAccounts();
		doc.ClickonRequiredAccount(drivename);
		
		String filename=doc.Filename();
		System.out.println("First before trash filename is"+ filename);
		doc.SleepThreeSec();
		
		doc.clickelipse();
		doc.ClickOnTrashFile();
		
		doc.SleepFiveSec();
		
		
		doc.ClickonDrive();
		System.out.println(doc.NavigateToTrash().getText());

		
		Actions action=new Actions(driver);
		action.moveToElement(doc.NavigateToTrash()).build().perform();
		doc.NavigateToTrash().click();
		
		List<WebElement> s = doc.clickonTrashButton2();
		for(int i=0;i<s.size();i++)
		{
			System.out.println(s.get(i).getText());
			if(s.get(i).getText().contains("Trash"))
			{
				s.get(i).click();
			}
		}
		
		
		List<WebElement> NamesofAllfile = doc.GetAllFileNames();
		for(int i=0;i<NamesofAllfile.size();i++)
		{
			if(NamesofAllfile.get(i).getText().equals(filename))
			{
				System.out.println("In Untrash filename is "+ NamesofAllfile.get(i).getText());
				flag=true;
				break;
			}
		}
		
		Assert.assertEquals(flag==true, true, "tras got failed");
		
		String Trashfilename=doc.Filename();
		System.out.println("untrash this file "+ Trashfilename);
		
		doc.clickelipse();
		doc.ClickOnUntrashIcon();
		
		doc.SleepFiveSec();
		
		doc.ClickOnTrashMainBtn();
		doc.SleepThreeSec();
		
		doc.ClickOnSubTrashBtn();
		
		doc.SleepThreeSec();
		
		
		List<WebElement> s1 = doc.clickonTrashButton2();
		for(int i=0;i<s1.size();i++)
		{
			System.out.println(s1.get(i).getText());
			if(s1.get(i).getText().contains("Drive"))
			{
				s1.get(i).click();
			}
		}
		
		
		List<WebElement> NamesofAllfile2 = doc.GetAllFileNames();
		for(int i=0;i<NamesofAllfile2.size();i++)
		{
			if(NamesofAllfile2.get(i).getText().equals(Trashfilename))
			{
				
				System.out.println("After untrash filenmae found "+ NamesofAllfile2.get(i).getText());
				flag=true;
				break;
			}
		}
		
		doc.clickonCloseIcon();
		doc.SleepThreeSec();
		Assert.assertEquals(flag==true, true, "untras got failed");
			
		
	}
	
	
	public void BatchTrash(String drivename){
		
		Boolean flag=false;
		MailPage m= new MailPage(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		d.clickDocumentCard();
		doc.ClickonDrive();
		doc.SleepThreeSec();
		
		doc.hoveronAllAccounts();
		doc.SleepThreeSec();
		doc.ClickonRequiredAccount(drivename);
		doc.SleepThreeSec();
		
		doc.ClickBatchCheck();
		doc.SleepThreeSec();
		
		doc.ClickSelectBacthfiles();
		System.out.println("4 files are selected");
		
		List<WebElement> FilenNames=doc.GetAllFileNames();
		
		String[] myStringArray = new String[5];
		for(int i=0;i<5;i++)
		{
			myStringArray[i]=FilenNames.get(i).getText();
			
		}
		
		doc.ClickOnMoveToTrashBtn();
		doc.SleepFiveSec();
		
		doc.ClickonDrive();
		doc.SleepThreeSec();
		
		doc.clickDrivebutton2();
		doc.SleepThreeSec();
		
		
		
		List<WebElement> s1 = doc.clickonTrashButton2();
		for(int i=0;i<s1.size();i++)
		{
			System.out.println(s1.get(i).getText());
			if(s1.get(i).getText().contains("Trash"))
			{
				s1.get(i).click();
			}
		}
		
		
		List<WebElement> FilenNames1=doc.GetAllFileNames();
		for(int i=0;i<FilenNames1.size();i++)
		{
			for(int j=0;j<myStringArray.length;j++)
			{
			if(FilenNames1.get(i).getText().equals(myStringArray[j]))
			{
				flag=true;
				break;
			}
		}
		}
		
		doc.clickonCloseIcon();
		doc.SleepThreeSec();
		
		Assert.assertEquals(flag==true, true, "Batchuntras got failed");
		
	}
	
	
	public void BatchUnTrash(String drivename){
		
		Boolean flag=false;
		MailPage m= new MailPage(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		d.clickDocumentCard();
		doc.ClickonDrive();
		doc.SleepThreeSec();
		
		doc.hoveronAllAccounts();
		doc.SleepThreeSec();
		doc.ClickonRequiredAccount(drivename);
		doc.SleepThreeSec();
		
		doc.ClickonDrive();
		doc.SleepThreeSec();
		
		doc.clickDrivebutton2();
		doc.SleepThreeSec();
		
		List<WebElement> s1 = doc.clickonTrashButton2();
		for(int i=0;i<s1.size();i++)
		{
			System.out.println(s1.get(i).getText());
			if(s1.get(i).getText().contains("Trash"))
			{
				s1.get(i).click();
			}
		}
		
		
		doc.ClickBatchCheck();
		doc.SleepThreeSec();
		
		doc.ClickSelectBacthfiles();
		System.out.println("4 files are selected");
		
		List<WebElement> FilenNames=doc.GetAllFileNames();
		
		String[] myStringArray = new String[3];
		for(int i=0;i<3;i++)
		{
			myStringArray[i]=FilenNames.get(i).getText();
			
		}
		
		doc.ClickOnUndoBtn();
		doc.SleepFiveSec();
		
		doc.ClickOnTrashMainBtn();
		doc.SleepThreeSec();
		doc.ClickOnSubTrashBtn();
		doc.SleepThreeSec();
		
		List<WebElement> s2 = doc.clickonTrashButton2();
		for(int i=0;i<s1.size();i++)
		{
			System.out.println(s1.get(i).getText());
			if(s2.get(i).getText().contains("Drive"))
			{
				s2.get(i).click();
			}
		}
		
		doc.SleepThreeSec();
		
		List<WebElement> FilenNames1=doc.GetAllFileNames();
		for(int i=0;i<FilenNames1.size();i++)
		{
			for(int j=0;j<myStringArray.length;j++)
			{
			if(FilenNames1.get(i).getText().equals(myStringArray[j]))
			{
				flag=true;
				break;
			}
		}
		}
		
		doc.clickonCloseIcon();
		doc.SleepThreeSec();
		
		Assert.assertEquals(flag==true, true, "Batchuntras got failed");
		
	}

}
