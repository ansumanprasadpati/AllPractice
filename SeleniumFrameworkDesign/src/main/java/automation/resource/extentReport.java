package automation.resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
	static ExtentReports extent;
	public static ExtentReports getReport() {
	
	//String path=System.getProperty("user.dir"+"//reports//index.html");
	ExtentSparkReporter reporter=new ExtentSparkReporter("user.dir"+"//reports//index.html");
	reporter.config().setReportName("Placed Order Report");
	reporter.config().setDocumentTitle("Automation");
	
	extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Ansuman");
	return extent;
	
	}
}
