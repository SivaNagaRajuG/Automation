package com.selenium.infrastructure.Listeners;

import com.selenium.infrastructure.ExtentReports.ExtentManager;
import com.selenium.infrastructure.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    //Before starting all tests, below method runs.
    @Override
    public void onStart(ITestContext iTestContext) {
       // System.out.println("I am in onStart method " + iTestContext.getName());
    }

    //After ending all tests, below method runs.
    @Override
    public void onFinish(ITestContext iTestContext) {
        //System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        ExtentManager.getReporter().flush();
        ExtentManager.getReporter().close();

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        //System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getTestClass().getRealClass().getSimpleName(),"");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
        //Extentreports log operation for passed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        ExtentTestManager.endTest();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");

        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Case Failed - Reason "+ iTestResult.getThrowable());
        ExtentTestManager.endTest();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        //System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Case Skipped");
        ExtentTestManager.endTest();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
       // System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
