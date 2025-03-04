package automation.testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automation.resource.extentReport;

public class Listeners extends BaseClass implements ITestListener{
	ExtentTest test;
	ExtentReports extent=extentReport.getReport();
	@Override
	public void onTestStart(ITestResult result)
	{
		test=extent.createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		test.log(Status.FAIL, "Test failed.");
		test.fail(result.getThrowable());
		String filePath = null;
		try {
			filePath = takeScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName() );
		
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}

}
