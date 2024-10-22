package testng.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

// Listeners in TestNG allow you to listen to various events during the execution of test cases and can be used to perform actions when certain events occur, such as starting a test, finishing a test, or logging additional information when a test fails.

public class Listner implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Pass");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
