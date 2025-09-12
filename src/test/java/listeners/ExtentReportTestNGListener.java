package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.FileInputStream;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.qameta.allure.Allure;
import utilities.TestContext;

	public class ExtentReportTestNGListener implements ITestListener {
	    private static ExtentReports extent;
	    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

	    @Override
	    public void onStart(ITestContext context) {
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("reports/ExtentReport.html");
            extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("OS", System.getProperty("os.name"));
	        extent.setSystemInfo("Tester", "Bagavathi");
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
	        testThread.set(test);
	        Allure.step("Starting test: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        testThread.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
	        Allure.step("Test Passed: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	 ExtentTest test = testThread.get();
	    	    test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
	    	    test.log(Status.FAIL, result.getThrowable());

	    	    File sourceFile = ((TakesScreenshot) TestContext.getDriver()).getScreenshotAs(OutputType.FILE);
	    	    Date d = new Date();
	    	    String timeStamp = d.toString().replace(":", "_").replace(" ", "_");
	    	    String projectDirectory = System.getProperty("user.dir");
	    	    String screenshotPath = projectDirectory + "/screenshots/" +
	    	            result.getName() + "_" + timeStamp + ".png";

	    	    try {
	    	        FileUtils.copyFile(sourceFile, new File(screenshotPath));
	    	        test.addScreenCaptureFromPath(screenshotPath);  // Extent attach
	    	        Allure.addAttachment("Screenshot", new FileInputStream(screenshotPath)); // Allure attach
	    	    } catch (IOException e) {
	    	        e.printStackTrace();
	    	    }
	    	
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        testThread.get().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
	}
