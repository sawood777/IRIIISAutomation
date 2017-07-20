package Factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import DataCollection.Configdata;

public class Browserfactory {
	
	static WebDriver driver;
	
	public static WebDriver getbrowser(String browsername){
		
		if(browsername.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", DataFactory.getconfic().getChromepath());
			driver=new ChromeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("firefox")){
			Configdata config=new Configdata();
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return  driver;
	}
	
	public static void closebrowser(WebDriver Idriver){
		
		driver.quit();
	}

}
