package wrapper;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class reportertwo {

	
	public ExtentReports extent;
	ExtentTest Test;
	

	@BeforeSuite
	public void startResults() {
		ExtentReports extent = new ExtentReports("./reports/result.html", true);

	}
	@BeforeMethod
	public void startTestCase() {
		ExtentTest Test = extent.startTest("TC001 create lead", "create a new lead in leaf taps");
		Test.assignAuthor("Rakesh");
		Test.assignCategory("smoke");
		
	}
	@AfterMethod
	public void endTestCase() {
		extent.endTest(Test);
	}
	
	public void endReport() {
		extent.flush();
	}
	
	public void logsLogic(String desc , String status) {
		if(status.equals("Pass")) {
			Test.log(LogStatus.PASS, desc+ Test.addScreenCapture(""));
		}
		else if (status.equals("Fail")) {
			Test.log(LogStatus.FAIL, desc+ Test.addScreenCapture(""));
		
	}
		else if (status.equals("Warning")) {
			Test.log(LogStatus.WARNING, desc+ Test.addScreenCapture(""));
	
}
		else if (status.equals("Info")) {
			Test.log(LogStatus.INFO, desc+ Test.addScreenCapture(""));

			
		}}}