package testcases;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.Browserfactory;
import Factory.DataFactory;
import Pages.Loginpage;
import Utility.Screenshots;

public class VerifyLogin {
	

	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeMethod
	public void starup(){
		report=new ExtentReports(".\\Reports\\loginReport.html", true);
		
		logger=report.startTest("verifylogin", "To check login");
		
		driver=Browserfactory.getbrowser("chrome");
		
		driver.get(DataFactory.getconfic().getDevurl());
		
		logger.log(LogStatus.INFO, "login page is displayed");
		
	}
	
	@Test
	public void logintoAppln(){
		
		Loginpage login=PageFactory.initElements(driver, Loginpage.class);
		
		login.ClickLogin(DataFactory.getdata().getDataByIndex(0, 0, 0), DataFactory.getdata().getDataByIndex(0, 0, 1));
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Screenshots.TakeScreenshot(driver, "myscreenshot")));
		
		login.Verifytitle();
		
		logger.log(LogStatus.PASS, "Logged in successfully");
		
		login.Verifytitle25();
		
		//login.singout();
		
		logger.log(LogStatus.INFO, "loggedout successfully");
	}
	
	@AfterMethod
	public void close(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE){
			
			String path=Screenshots.TakeScreenshot(driver, result.getName());
			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		
		Browserfactory.closebrowser(driver);
		report.endTest(logger);
		report.flush();
	}
	

}
