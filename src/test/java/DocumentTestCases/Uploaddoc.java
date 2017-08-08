package DocumentTestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Factory.DataFactory;
import Pages.DashboardPage;
import Pages.DocumentsPage;
import emailTestCases.BaseTest;

public class Uploaddoc {
	
	
	WebDriver driver;
	
	public Uploaddoc(WebDriver driver){
		
		this.driver=driver;
	}
	
	
	public void SingleFileUpload(String drivername, String NameOfFilename, String Filepath) 
	{
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		d.clickDocumentCard();
		
		doc.ClickonDrive();
		doc.SleepFiveSec();
		doc.hoveronAllAccounts();
		doc.SleepThreeSec();
		doc.ClickonRequiredAccount(drivername);
		
		doc.uploadFile();

			
			try {
				Runtime.getRuntime().exec(Filepath);
				} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			
		doc.SleepFiveSec();
		doc.closebutton();
		
		doc.acceptalert();
		
		doc.SleepThreeSec();
		String Filename=doc.Filename();
		if(Filename.contains(NameOfFilename)){
			flag=true;
		}
		
		doc.SleepThreeSec();
		Assert.assertEquals(flag==true, true, "Fail to upload the file");
		
		//logger.log(LogStatus.PASS, "File is uploaded");	
		
	}
	
	public void SingleFileUpload2(String drivename, String NameOfFilename, String Filepath ){
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		
		doc.ClickonDrive();
		doc.SleepThreeSec();
		doc.ClickonChangeAccount();
		doc.SleepThreeSec();
		doc.ClickonRequiredAccount(drivename);
		
		doc.uploadFile();

		
		try {
			Runtime.getRuntime().exec(Filepath);
			} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
	
		doc.SleepFiveSec();
		doc.closebutton();
		
		doc.acceptalert();
	
	String Filename=doc.Filename();
	if(Filename.contains(NameOfFilename)){
		flag=true;
	}
	
	doc.SleepThreeSec();
	
	Assert.assertEquals(flag==true, true, "Fail to upload the file");
		
	}
	
	
	
	public void multifileupload(String drivername, String Nameoffile, String Filepath, String getdata){
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		d.clickDocumentCard();
		
		doc.ClickonDrive();
		doc.SleepFiveSec();
		doc.hoveronAllAccounts();
		doc.SleepThreeSec();
		doc.ClickonRequiredAccount(drivername);
		
		doc.uploadFile();
		
		for(int i=1; i<=3; i++){
			
			try {
				Runtime.getRuntime().exec(Filepath);
				} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			doc.SleepFiveSec();
			for(int j=i; j<=2; j++){
				doc.clickAddmore();
				break;
			}
			
			
			
		}
		
		
		doc.SleepFiveSec();
		doc.closebutton();
		
		doc.acceptalert();

		doc.SleepThreeSec();
		
		List<WebElement> FilenNames=doc.GetAllFileNames();
		int filesize=FilenNames.size();
		String[] myStringArray = new String[filesize];
		for(int i=0;i<FilenNames.size();i++)
		{
			myStringArray[i]=FilenNames.get(i).getText();
			
		}
		
		String[] myStringArray2 = new String[3];
		for(int i=0;i<3;i++)
		{
			myStringArray2[i]=getdata;
			System.out.println("sheet data "+ myStringArray2[i]);
			
		}
		
		
		
		for(int i=0;i<myStringArray2.length;i++)
		{
			for(int j=0;j<myStringArray.length;j++)
			{
			if(FilenNames.get(i).getText().equals(myStringArray[i]))
			{
				flag=true;
				break;
			}
		}
		}
		
		doc.clickonCloseIcon();
		doc.SleepThreeSec();
		Assert.assertEquals(flag==true, true, "Fail to upload the files");
	}	
		

}
