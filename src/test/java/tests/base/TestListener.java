package tests.base;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;

@Log4j2
public class TestListener implements ITestListener {

    //TODO CREATE TEST RUN USING API (add test cases too)
    public void onStart(ITestContext context) {
    }

    public void onTestStart(ITestResult result) {
        log.info(String.format("============================STARTING TEST %s===============================", result.getName()));
    }

    //TODO API REQUEST TO SET STATUS OF TEST CASE
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        AllureUtils.takeScreenshot(driver);
        log.error(String.format("============================FAILED TEST %s===============================", result.getName()));
    }

    public void onTestSkipped(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        AllureUtils.takeScreenshot(driver);
        log.error(String.format("============================SKIPPING TEST %s===============================", result.getName()));
    }
}
