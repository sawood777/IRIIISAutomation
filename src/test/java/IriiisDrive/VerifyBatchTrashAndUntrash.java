package IriiisDrive;

import org.testng.annotations.Test;

import DocumentTestCases.VerifyTrashandUntrashFile;
import emailTestCases.BaseTest;

public class VerifyBatchTrashAndUntrash extends BaseTest {
	
		@Test(priority=1)
		public void VerifyIriiisBatchFileTrash(){
			
			VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
			Trash.BatchTrash("iriiis");	
		}
		
		@Test(priority=2)
		public void VerifyIgoogleBatchFileTrash(){
			
			VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
			Trash.BatchTrash("google");	
		}
		
		@Test(priority=3)
		public void VerifyBoxdriveBatchFileTrash(){
			
			VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
			Trash.BatchTrash("box");	
		}
		
		@Test(priority=4)
		public void VerifyDropboxBatchFileTrash(){
			
			VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
			Trash.BatchTrash("dropbox");	
		}
		
	//	@Test(priority=5)
		public void VerifyOneDriveBatchFileTrash(){
			
			VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
			Trash.BatchTrash("onedrive");	
		}
		
		@Test(priority=6)
		public void VerifyOIriiisBatchFileUnTrash(){
			
			VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
			Trash.BatchUnTrash("iriiis");	
		}
		
		@Test(priority=7)
		public void VerifygoogleBatchFileUnTrash(){
			
			VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
			Trash.BatchUnTrash("google");	
		}
		
		@Test(priority=8)
		public void VerifyboxBatchFileUnTrash(){
			
			VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
			Trash.BatchUnTrash("box");	
		}
		
		@Test(priority=9)
		public void VerifyBoxdriveBatchFileUnTrash(){
			
			VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
			Trash.BatchUnTrash("dropbox");	
		}
		
		//@Test(priority=10)
		public void VerifyonedriveBatchFileUnTrash(){
			
			VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
			Trash.BatchUnTrash("onedrive");	
		}
		

}
