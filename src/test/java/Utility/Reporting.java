package Utility;

import com.relevantcodes.extentreports.ExtentReports;

public class Reporting
{
	static ExtentReports report;
	
	public static ExtentReports startTest()
	{
		 report= new ExtentReports("./Reports/mytest.html", true);
		 
		 return report;
	}

}
