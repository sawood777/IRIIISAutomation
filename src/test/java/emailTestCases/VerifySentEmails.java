package emailTestCases;

import org.openqa.selenium.WebDriver;

import Pages.DashboardPage;
import Pages.MailPage;

public class VerifySentEmails {
	
	
WebDriver driver;
	
	public  VerifySentEmails(WebDriver driver) {
		this.driver=driver;
	}

public void VerifyAttachment(){
		
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		MailPage m= new MailPage(driver);
		d.clickMailCard();
		m.clickComposeIcon();
		m.enterToAddreess("devuser1@iriiisdev.com");
		m.enterSubject("String12233");
		m.enterEmailBody("hey test125");
		m.Attacfile();
		m.Selectattachment();
	try {
		Thread.sleep(5000);
	} catch (Exception e) {
		
	}
		m.sendmail();
		
		m.clickMailFilter();
		m.clickSentFilter();
		m.clickFirstEmail();
		m.verifyAttachment();
		
	}


}
