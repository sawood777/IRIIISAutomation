package IriiisDrive;

import org.testng.annotations.Test;

import DocumentTestCases.VerifyFolder;
import emailTestCases.BaseTest;

public class VerifyDragAndDropFile extends BaseTest {
	
	//@Test(priority=1)
	public void VerifyIriiisFileDragAndDrop(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.VerifyDragandDrop("iriiis");
	}
	
	@Test(priority=2)
	public void VerifygoogleFileDragAndDrop(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.VerifyDragandDrop("google");
	}
	
	@Test(priority=3)
	public void VerifyBoxdriveFileDragAndDrop(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.VerifyDragandDrop("box");
	}
	
	@Test(priority=4)
	public void VerifydropboxFileDragAndDrop(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.VerifyDragandDrop("dropbox");
	}
	
	@Test(priority=5)
	public void VerifyonedriveFileDragAndDrop(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.VerifyDragandDrop("onedrive");
	}
	
	//@Test(priority=6)
	public void testt(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		
	}
	
	
	
	

}
