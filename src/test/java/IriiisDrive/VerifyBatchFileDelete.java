package IriiisDrive;

import org.testng.annotations.Test;

import DocumentTestCases.VerifyBasicFileActivity;
import emailTestCases.BaseTest;

public class VerifyBatchFileDelete extends BaseTest{
	
	@Test(priority=1)
	public void VerifygoogleBatchDelete(){
		
		VerifyBasicFileActivity remove=new VerifyBasicFileActivity(driver);
		remove.VeryBatchDelete("google");
	}
	
	@Test(priority=2)
	public void VerifyIriiisBatchDelete(){
		
		VerifyBasicFileActivity remove=new VerifyBasicFileActivity(driver);
		remove.VeryBatchDelete("iriiis");
	}
	
	@Test(priority=3)
	public void VerifyboxBatchDelete(){
		
		VerifyBasicFileActivity remove=new VerifyBasicFileActivity(driver);
		remove.VeryBatchDelete("box");
	}
	
	//@Test(priority=4)
	public void VerifydropboxBatchDelete(){
		
		VerifyBasicFileActivity remove=new VerifyBasicFileActivity(driver);
		remove.VeryBatchDelete("dropbox");
	}
	
	//@Test(priority=5)
	public void VerifyonedriveBatchDelete(){
		
		VerifyBasicFileActivity remove=new VerifyBasicFileActivity(driver);
		remove.VeryBatchDelete("onedrive");
	}
	

}
