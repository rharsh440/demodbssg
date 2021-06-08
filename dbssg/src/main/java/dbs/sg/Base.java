package dbs.sg;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	public static final String url = "https://www.dbs.com.sg/personal/default.page";
	public static WebDriver dbsdriver;
	static String filePath = "target/dbs/report";
	public static ExtentReports reports = new ExtentReports(filePath, true);
	public static ExtentTest test;

	
	
	
}
