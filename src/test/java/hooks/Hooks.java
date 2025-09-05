package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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

		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		TestContext.getPom().getHomePage().clickSignInLink();
		TestContext.getPom().getLoginPage().loginTODSAlgo();
	}
//	
//	@AfterMethod()	//execute before closing the browser
//	public void tearDown(Scenario scenario){ 	//Take a screenshot automatically if a scenario fails
//		if(scenario.isFailed()) {
//			LoggerLoad.error("Scenario failed: " + scenario.getName() + " — capturing screenshot.");
//			String screenshotName = scenario.getName().replaceAll("", "_");
//			byte [] sourcePath=((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES); 
//			scenario.attach(sourcePath, "image/png", screenshotName);
//			LoggerLoad.info("Screenshot attached to scenario: " + screenshotName);
//			Allure.addAttachment("failedScreenshot", new ByteArrayInputStream(sourcePath));
//		}
//	}
	
	@AfterMethod	// execute last
	public void quitBrowser() { 	//Quits the browser and removes the thread-local WebDriver instance
		 if (TestContext.getDriver() != null) {
			 TestContext.getDriver().quit(); 	// Close the browser
			 TestContext.clear(); 	// Clean up ThreadLocal driver
				LoggerLoad.info("Browser closed and WebDriver instance removed.");
		    }
    }

}
