package IriiisDrive;

import org.testng.annotations.Test;

import DocumentTestCases.VerifyBasicFileActivity;
import emailTestCases.BaseTest;

public class VerifyTheFileUpdatedesc extends BaseTest{
	
	//@Test(priority=1)
	public void VerifygoogleFileUpdateDesc(){
		
		VerifyBasicFileActivity Desc=new VerifyBasicFileActivity(driver);
		Desc.UpdateDesc("google", "CheckDescripton porperly");
	}
	
	@Test(priority=2)
	public void VerifyIriiisFileUpdateDesc(){
		
		VerifyBasicFileActivity Desc=new VerifyBasicFileActivity(driver);
		Desc.UpdateDesc("iriiis", "Check Iriiis File Descripton porperly");
	}
	
	@Test(priority=3)
	public void VerifyboxdriveFileUpdateDesc(){
		
		VerifyBasicFileActivity Desc=new VerifyBasicFileActivity(driver);
		Desc.UpdateDesc("box", "Check BoxDrive File Descripton porperly");
	}
	
	@Test(priority=4)
	public void VerifyDropboxdriveFileUpdateDesc(){
		
		VerifyBasicFileActivity Desc=new VerifyBasicFileActivity(driver);
		Desc.UpdateDesc("dropbox", "Check Dropbox File Descripton porperly");
	}
	
	@Test(priority=5)
	public void VerifyOnedriveFileUpdateDesc(){
		
		VerifyBasicFileActivity Desc=new VerifyBasicFileActivity(driver);
		Desc.UpdateDesc("onedrive", "Check Onedrive File Descripton porperly");
	}
	
	

}
