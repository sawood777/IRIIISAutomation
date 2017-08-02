package DocumentTestCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Pages.DashboardPage;
import Pages.DocumentsPage;

public class VerifyBasicFileActivity {
	
	WebDriver driver;
	
	public VerifyBasicFileActivity(WebDriver driver){
		
		this.driver=driver;
	}
	
	
	public void RenameFile(String driveanme, String EnterFileName){
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		
		d.clickDocumentCard();
		doc.ClickonDrive();
		doc.SleepFiveSec();
		doc.hoveronAllAccounts();
		doc.SleepThreeSec();
		doc.ClickonRequiredAccount(driveanme);
		
		String filename=doc.Filename();
		System.out.println("before refilename is "+ filename);
		doc.SleepThreeSec();
		
		doc.clickelipse();
		doc.ClickOnRename();
		doc.EnterFileName(EnterFileName);
		String newfilename=EnterFileName;
		doc.ClickOnFilesave();
		doc.SleepFiveSec();
		
		String FilenameAfterRename=doc.Filename();
		System.out.println("After rename filename is "+ FilenameAfterRename);
		
		
		if(FilenameAfterRename.startsWith(newfilename)){
			System.out.println("File rename is scuccessfull");
			flag=true;
		}
		
		doc.clickonCloseIcon();
		
		Assert.assertEquals(flag==true, true, "failed to rename the file");
		
	}
	
	public void UpdateDesc(String driveanme, String EnterFileDesc){
		
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		
		d.clickDocumentCard();
		doc.ClickonDrive();
		doc.SleepFiveSec();
		doc.hoveronAllAccounts();
		doc.SleepThreeSec();
		doc.ClickonRequiredAccount(driveanme);
		
		//String filename=doc.Filename();
		//System.out.println("before refilename is "+ filename);
		doc.SleepThreeSec();
		
		doc.clickelipse();
		
		doc.ClickOnUpdateDesc();
		doc.EnterFileDesc(EnterFileDesc);
		String filedesc=EnterFileDesc;
		System.out.println("My Description is "+ filedesc);
		doc.ClickOnFilesave();
		doc.SleepFiveSec();
		doc.clickelipse();
		doc.ClickOnViewDetails();
		
		String MyEnteredDesc=doc.GetDescDetails();
		
		if(MyEnteredDesc.contains(filedesc)){
			System.out.println("File Desc is updated scuccessfull"+ MyEnteredDesc);
			flag=true;
		}
		
		doc.clickonCloseIcon();
		doc.SleepThreeSec();
		
		Assert.assertEquals(flag==true, true, "failed to rename the file");
	}
	
	public void VeryFileRemove(String driveanme){
		
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		
		d.clickDocumentCard();
		doc.ClickonDrive();
		doc.SleepFiveSec();
		doc.hoveronAllAccounts();
		doc.SleepThreeSec();
		doc.ClickonRequiredAccount(driveanme);
		
		doc.SleepThreeSec();
		
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
		
		String filename=doc.Filename();
		System.out.println("File name is "+ filename);
		
		doc.clickelipse();
		doc.ClickOnRemove();
		doc.SleepFiveSec();
		
		List<WebElement> NamesofAllfile = doc.GetAllFileNames();
		for(int i=0;i<NamesofAllfile.size();i++)
		{
			if(NamesofAllfile.get(i).getText().equals(filename))
			{
				System.out.println("After Remove filenmae found "+ NamesofAllfile.get(i).getText());
				flag=true;
				break;
			}
		}
		//doc.clickonCloseIcon();
		doc.SleepThreeSec();
		
		Assert.assertEquals(flag==true, false, "File Remove got failed");
		
	}
	
	public void VeryFileRemove2(String drivename){
		Boolean flag=false;
		DocumentsPage doc=new DocumentsPage(driver);
		doc.ClickOnTrashMainBtn();
		doc.SleepThreeSec();
		doc.ClickonChangeAccount();
		doc.SleepThreeSec();
		doc.ClickonRequiredAccount(drivename);
		doc.SleepThreeSec();
		
		String filename=doc.Filename();
		System.out.println("File name is "+ filename);
		
		doc.clickelipse();
		doc.ClickOnRemove();
		doc.SleepFiveSec();
		
		List<WebElement> NamesofAllfile = doc.GetAllFileNames();
		for(int i=0;i<NamesofAllfile.size();i++)
		{
			if(NamesofAllfile.get(i).getText().equals(filename))
			{
				System.out.println("After Remove filenmae found "+ NamesofAllfile.get(i).getText());
				flag=true;
				break;
			}
		}
		//doc.clickonCloseIcon();
		doc.SleepThreeSec();
		
		Assert.assertEquals(flag==true, false, "File Remove got failed");
		
	}
	
	public void VeryBatchDelete(String driveanme){
		
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		
		d.clickDocumentCard();
		doc.ClickonDrive();
		doc.SleepFiveSec();
		doc.hoveronAllAccounts();
		doc.SleepThreeSec();
		doc.ClickonRequiredAccount(driveanme);
		doc.SleepThreeSec();
		
		
		doc.ClickonDrive();
		doc.SleepThreeSec();
		doc.clickDrivebutton2();
		doc.SleepThreeSec();
		
		List<WebElement> s = doc.clickonTrashButton2();
		for(int i=0;i<s.size();i++)
		{
			System.out.println(s.get(i).getText());
			if(s.get(i).getText().contains("Trash"))
			{
				s.get(i).click();
			}
		}
		
		
		doc.ClickBatchCheck();
		doc.ClickBatchCheck1();
		doc.ClickOnSelectAllBtn();
		doc.ClickOnDeleteForeverBtn();
		doc.SleepFiveSec();
		
		String TextAfterTrash=doc.GetTextAfterTrash();
		doc.clickonCloseIcon();
		doc.SleepThreeSec();
		
		Assert.assertEquals(TextAfterTrash, "No files or folders in Trash.");
		
	}

}
