package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.DataFactory;
import Utility.Reporting;
import Utility.Screenshots;

public class BaseTest {
	
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeClass
	public void testBrowser()
	{
		System.out.println("Opening the browser");
		System.setProperty("webdriver.chrome.driver","C://Chrome Driver//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.iriiisdev.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		VerifyLogin v= new VerifyLogin();
		v.testLogin(DataFactory.getdata().getDataByIndex(0, 0, 0),DataFactory.getdata().getDataByIndex(0, 0,1 ) ,driver);
	}
	
	//@BeforeTest
	
		public void beforeTest()
		{
		report= new ExtentReports("./Reports/mytest.html", true);
		logger = report.startTest("BaseTest");
		}
	
	//@AfterTest
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, logger.addScreenCapture(Screenshots.TakeScreenshot(driver, result.getName())));
			report.endTest(logger);
			report.flush();
			report.close();
		}
	}
	
	//@AfterTest
	public void endReport(){
		// writing everything to document
		//flush() - to write or update test information to your report. 
               // report.flush();
                //Call close() at the very end of your session to clear all resources. 
                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
                //Once this method is called, calling any Extent method will throw an error.
                //close() - To close all the operation
               // report.close();
    }
		//This is to check if the Git has been sucessfully updated

	@AfterClass
	public void postCondition()
	{
		//VerifyLogin v= new VerifyLogin();
		//v.testLogOut(driver);
		//to check update
		//this is from eclips
		driver.quit();
	}
}
