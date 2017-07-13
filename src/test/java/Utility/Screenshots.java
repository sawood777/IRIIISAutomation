package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
	public static String TakeScreenshot(WebDriver driver, String screenshtoName){
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String destination="C:\\Users\\Praveen\\git\\IRIIISAutomation\\ScreenShots\\"+screenshtoName+System.currentTimeMillis()+".png";
		
		try {
			FileUtils.copyFile(src,new File(destination));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return destination;
		
	}
	
	

}
