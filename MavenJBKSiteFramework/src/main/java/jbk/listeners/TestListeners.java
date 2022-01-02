package jbk.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import jbk.base.TestBase;

public class TestListeners extends TestBase implements ITestListener {

	public void onFinish(ITestContext result) {
		log.info(" Test suite finished");

	}

	public void onStart(ITestContext result) {
		log.info(" Test suite started");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		log.info("test case failed with name " + result.getName());
		takeScreenshot(result.getName());
		log.info("Screenshot capture for failed testcase");

	}

	public void onTestSkipped(ITestResult result) {
		log.info("test case skipped with name " + result.getName());

	}

	public void onTestStart(ITestResult result) {
		log.info("test case starting with name " + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		log.info("test case passed with name " + result.getName());

	}

}
