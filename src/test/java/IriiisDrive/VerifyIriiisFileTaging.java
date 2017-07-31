

package IriiisDrive;

import org.testng.annotations.Test;

import DocumentTestCases.VerifyFileTaging;
import Pages.DashboardPage;
import Pages.IriiisLogoPage;
import emailTestCases.BaseTest;

public class VerifyIriiisFileTaging extends BaseTest {
	
	@Test(priority=1)
	public void VerifyIriiisTag(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		select.SelectAccount("iriiis");
	}
	
	/*@Test(priority=2)
	public void VerifgoogleTag(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		select.SelectAccount("google");
	}
	
	@Test(priority=3)
	public void VerifboxdriveTag(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		select.SelectAccount("box");
	}

	@Test(priority=4)
	public void VerifdropboxdriveTag(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		select.SelectAccount("dropbox");
	}
	
	@Test(priority=5)
	public void VerifonedriveTag(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		select.SelectAccount("onedrive");
	}

	@Test(priority=1)
	public void VerifyBatchtaging() throws Exception{
		VerifyFileTaging select=new VerifyFileTaging(driver);
		select.DocumentBathcSelection("iriiis");
		Thread.sleep(3000);
	}
	
	@Test(priority=6)
	public void VerifyIriiisSharing(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		select.SharingtoTopic("iriiis");
	}
	
	@Test(priority=7)
	public void VerifyGoogleSharing(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		select.SharingtoTopic("google");
	}
	
	@Test(priority=8)
	public void VerifyboxSharing(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		select.SharingtoTopic("box");
	}
	
	@Test(priority=9)
	public void VerifyDropboxSharing(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		select.SharingtoTopic("dropbox");
	}
	
	@Test(priority=10)
	public void VerifyOnedriveSharing(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		select.SharingtoTopic("onedrive");
	}
	*/
	
}

