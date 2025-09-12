package hooks;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.CommonMethods;
import utilities.Constants;
import utilities.ExcelReaderFillo;
import utilities.LoggerLoad;
import utilities.TestContext;
import webdriver.DriverFactory;

public class Hooks {

	protected WebDriver driver;
	private DriverFactory driverFactory;
	protected CommonMethods cm;
	
	@BeforeClass(alwaysRun = true)
	public void loadExcel() {
	    ExcelReaderFillo.loadExcelData();
	}
 
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser") 	//cross browser testing
	public void launchbrowser(@Optional("") String browsername)  throws Throwable{ 	//Launch browser and open the base URL which are fetched from the loaded properties
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
	
	
    @BeforeMethod(alwaysRun = true, dependsOnMethods = "launchbrowser")
    public void initCommonMethods() {
        cm = new CommonMethods(TestContext.getDriver());
    }
	
	@BeforeMethod(onlyForGroups = {"validCredentials"}, dependsOnMethods = "initCommonMethods")
	public void doLogin() {
		 Map<String, String> validCred = ExcelReaderFillo.getRowAsMap("login", "ValidCredential");
		 String username = validCred.get("username");
		 String password = validCred.get("password");
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		TestContext.getPom().getHomePage().clickSignInLink();
		TestContext.getPom().getLoginPage().loginTODSAlgo(username, password);
		LoggerLoad.info("User Logged In");
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
