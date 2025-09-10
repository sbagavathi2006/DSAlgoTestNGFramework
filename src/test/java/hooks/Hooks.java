package hooks;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.qameta.allure.Allure;
import utilities.ConfigReader;
import utilities.Constants;
import utilities.ExcelReaderFillo;
import utilities.LoggerLoad;
import utilities.TestContext;
import webdriver.DriverFactory;

public class Hooks {

	protected WebDriver driver;
	private DriverFactory driverFactory;
	
	@BeforeClass(alwaysRun = true)
	public void loadExcel() {
	    ExcelReaderFillo.loadExcelData();
	}
 
	@BeforeMethod(alwaysRun = true)
	public void launchbrowser() throws Throwable{ 	//Launch browser and open the base URL which are fetched from the loaded properties
		String browsername = ConfigReader.getBrowserType(); 
		if (browsername == null || browsername.isEmpty()) {
			browsername = Constants.BROWSER; 
		}
		
		driverFactory = new DriverFactory();  	// Initialize the driver factory
		driver = driverFactory.init_driver(browsername); 	// Launch the browser
		driver.get(Constants.APPURL);
		
		//Thread Safe driver and pom
		TestContext.setDriver(driver);
		
		LoggerLoad.info("Navigated to URL: " + Constants.APPURL + "Browser : " + browsername );
	}
	
	@BeforeMethod(onlyForGroups = {"validCredentials"}, dependsOnMethods = "launchbrowser")
	public void doLogin() {
		 Map<String, String> validCred = ExcelReaderFillo.getRowAsMap("login", "ValidCredential");
		 String username = validCred.get("username");
		 String password = validCred.get("password");
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		TestContext.getPom().getHomePage().clickSignInLink();
		TestContext.getPom().getLoginPage().loginTODSAlgo(username, password);
		LoggerLoad.info("User Logged In");
	}
	
	@AfterMethod()
	public void failedScreenshot(ITestResult result){ 	
		if(result.getStatus() == ITestResult.FAILURE) {
		File sourceFile = ((TakesScreenshot)TestContext.getDriver()).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String timeStamp = d.toString().replace(":", "_").replace(" ", "_");
		String projectDirectory = System.getProperty("user.dir");
		
		try {
			FileUtils.copyFile(sourceFile, new File(projectDirectory + "/screenshots/" + 
					result.getName() + "_" + timeStamp + ".png"));
		} catch ( IOException e) {
			e.printStackTrace();
		}
		}
	}
	
	@AfterMethod	// execute last
	public void quitBrowser() { 	//Quits the browser and removes the thread-local WebDriver instance
		 if (TestContext.getDriver() != null) {
			 TestContext.getDriver().quit(); 	// Close the browser
			 TestContext.clear(); 	// Clean up ThreadLocal driver
				LoggerLoad.info("Browser closed and WebDriver instance removed.");
		    }
    }

}
