package Selenium.day23.listerners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {

    public void onTestStart(ITestResult tr) {
        System.out.println("Test method is started");
    }

    public void onTestSuccess(ITestResult tr) {
        System.out.println("Test method passed");
    }

    public void onTestFailure(ITestResult tr) {
        System.out.println("Test method failed");
    }

    public void onTestSkipped(ITestResult tr) {
        System.out.println("Test method skipped");
    }

}