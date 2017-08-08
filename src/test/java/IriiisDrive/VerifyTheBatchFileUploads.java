package IriiisDrive;

import org.testng.annotations.Test;

import DocumentTestCases.Uploaddoc;
import Factory.DataFactory;
import emailTestCases.BaseTest;

public class VerifyTheBatchFileUploads extends BaseTest {
	int i = 0;
	@Test(priority=1)
	public void IriiisBathcFileuploads(){
		
		Uploaddoc upload=new Uploaddoc(driver);
		upload.multifileupload("iriiis", "iriiis", "//LAPTOP-1D78PSH8//Shared folder//Autoit//AttacheFile.exe", DataFactory.getdata().getDataByIndex(1, i, 0));
		
	}
	
	//@Test(priority=2)
	public void googledirveBathcFileuploads(){
		
		Uploaddoc upload=new Uploaddoc(driver);
		upload.multifileupload("google", "google", "\\LAPTOP-1D78PSH8\\Shared folder\\Autoit\\GoogleFile.exe", DataFactory.getdata().getDataByIndex(1, i, 1));
		
	}
	
	//@Test(priority=3)
	public void boxBathcFileuploads(){
		
		Uploaddoc upload=new Uploaddoc(driver);
		upload.multifileupload("box", "boxrive", "//LAPTOP-1D78PSH8//Shared folder//Autoit//BoxdriveFile.exe", DataFactory.getdata().getDataByIndex(1, i, 2));
		
	}
	
	
	//@Test(priority=4)
	public void dropboxBathcFileuploads(){
		
		Uploaddoc upload=new Uploaddoc(driver);
		upload.multifileupload("dropbox", "dropbox", "//LAPTOP-1D78PSH8//Shared folder//Autoit//DropboxFile.exe", DataFactory.getdata().getDataByIndex(1, i, 3));
		
	}
	
	//@Test(priority=5)
	public void onedropboxBathcFileuploads(){
		
		Uploaddoc upload=new Uploaddoc(driver);
		upload.multifileupload("onedrive", "onedrive", "//LAPTOP-1D78PSH8//Shared folder//Autoit//OnedriveFile.exe", DataFactory.getdata().getDataByIndex(1, i, 4));
		
	}
	


}
