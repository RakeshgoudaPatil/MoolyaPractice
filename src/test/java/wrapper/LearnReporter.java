package wrapper;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LearnReporter {
	@Test
	public void reporter() {
		ExtentReports extent = new ExtentReports("./reports/result.html", true);
		ExtentTest Test = extent.startTest("TC001 create lead", "create a new lead in leaf taps");
		Test.assignAuthor("Rakesh");
		
		
		Test.log(LogStatus.PASS, "username is entered is successfully"); 
		Test.log(LogStatus.PASS, "unable to enter username" + Test.addScreenCapture("./../snaps/img1.png"));
		Test.log(LogStatus.FAIL, "this is the fails");
		Test.log(LogStatus.FAIL, "this is the failsasas");
		extent.endTest(Test);
		extent.flush();
		
		
	}
	
	
	

}
