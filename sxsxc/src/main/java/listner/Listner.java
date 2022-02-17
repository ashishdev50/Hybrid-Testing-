package listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import base.Base;


public class Listner extends Base  implements ITestListener     {

	public void onFinish(ITestContext result) {
	
		
	}

	public void onStart(ITestContext result) {
		
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Testcase failed with name"+result.getName());
		test.addScreenCaptureFromPath(takesScreenshot(result.getName()));
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "testcase is skipped with name "+result.getName());
	
	}

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "testcase is Passed with name "+result.getName());
	}
	
	
	
	
	
	
	

}
