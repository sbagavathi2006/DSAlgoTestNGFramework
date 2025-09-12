package testclasses;

import org.testng.annotations.Test;

import hooks.Hooks;

import org.testng.Assert;

import utilities.ExcelDataProvider;
import utilities.LoggerLoad;
import utilities.TestContext;

/* TestContext class is a thread safe singleton design pattern to access runtime objects.
 * When doing this inheritance by extends keyword is not needed.
 * Using extends to inform the testNG to execute @BeforeMethod for each test or else need to call it in the testNG.xml file.
 */

public class HomeTest extends Hooks{
	
	@Test
	public void IsNumpyNinjaLinkDisplayed() {
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		boolean actualResult = TestContext.getPom().getHomePage().isNumpyNinjaLinkDisplayed();
		Assert.assertTrue(actualResult);
		LoggerLoad.info("User should see Numpy Ninja link");	
	}
	
	
	@Test
	public void IsDataStructureDropDownDisplayed() {
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		boolean actualResult = TestContext.getPom().getHomePage().isDropdownOptionsDisplayed();
		Assert.assertTrue(actualResult);
		LoggerLoad.info("User should see Data Structure drop down list");	
	}
	
		
	@Test
	public void IsRegisterLinkDisplayed() {
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		boolean actualResult = TestContext.getPom().getHomePage().isRegisterLinkDisplayed();
		Assert.assertTrue(actualResult);
		LoggerLoad.info("User should see Register link");	
	}
	
	@Test
	public void IsSignInLinkDisplayed() {
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		boolean actualResult = TestContext.getPom().getHomePage().isSignInLinkDisplayed();
		Assert.assertTrue(actualResult);
		LoggerLoad.info("User should see Signin link");	
	}
	
	@Test
	public void IsFlexesDisplayed() {
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		boolean actualResult = TestContext.getPom().getHomePage().isFlexDisplayed();
		Assert.assertTrue(actualResult);
		LoggerLoad.info("User should see flexes on the home page.");	
	}
	
	@Test
	public void DataStructuresDropdownClick() {
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		TestContext.getPom().getHomePage().clickDataStructuresDropdown();
		int actualCount = TestContext.getPom().getHomePage().getDsDropdownOptionsCount();
		Assert.assertEquals(actualCount, 6);
		LoggerLoad.info("User should see 6 options from the dropdown list. Actual No. of options in the list is " + actualCount);		
	}
	
	@Test
	public void NumOfFlexesInHome() {
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		int actualCount = TestContext.getPom().getHomePage().getFlexCount();
		Assert.assertEquals(actualCount, 7);
		LoggerLoad.info("User should see 7 cards in the home. Actual No. of cards in home is " + actualCount);
	}
	
	@Test
	public void NumpyNinjaLinkClick() {
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		TestContext.getPom().getHomePage().clickNumpyNinja();
		Assert.assertEquals(TestContext.getDriver().getTitle(), "NumpyNinja");
		LoggerLoad.info("DSAlgo Home Page should be reloaded. Page Title is " + TestContext.getDriver().getTitle());
	}
	
	@Test
	public void RegisterLinkClick() {
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		TestContext.getPom().getHomePage().clickRegisterLink();
		Assert.assertEquals(TestContext.getDriver().getTitle(),"Registration");
		LoggerLoad.info("User should land on registration page. The page title is " + TestContext.getDriver().getTitle());		
	}
	
	@Test
	public void SignInLinkClick() {
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		TestContext.getPom().getHomePage().clickSignInLink();
		Assert.assertEquals(TestContext.getDriver().getTitle(),"Login");
		LoggerLoad.info("User should land on registration page. The page title is " + TestContext.getDriver().getTitle());		
	}
	
	@Test(dataProvider = "homeDDTestData", dataProviderClass = ExcelDataProvider.class)
	public void DSSelectionFromDropDownListBeforeLogin(String DDOptions, String Title) {	
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		TestContext.getPom().getHomePage().clickDataStructuresDropdown();
		TestContext.getPom().getHomePage().selectFromDropdown(DDOptions);
		Assert.assertEquals(TestContext.getPom().getHomePage().isErrMsgDisplayed(), true);
		LoggerLoad.info("User should see error message that you are not logged in");		
	}
	
	@Test(dataProvider = "homeFlexTestData", dataProviderClass = ExcelDataProvider.class)
	public void VerifyGetStartedViaFlexBeforeLogin(String Flexes, String Title) {
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		TestContext.getPom().getHomePage().clickFlexGetStarted(Flexes);
		Assert.assertEquals(TestContext.getPom().getHomePage().isErrMsgDisplayed(), true);
		LoggerLoad.info("User should see error message that you are not logged in");
		}
	
	@Test(priority = 1, groups = "validCredentials", dataProvider = "validLoginCredentials", dataProviderClass = ExcelDataProvider.class)
	public void VerifyLoggedInUser(String validation, String username, String password, String message) {	
		String actualResult = TestContext.getPom().getHomePage().loggedInUser(cm.strUser(username));
		Assert.assertEquals(actualResult, cm.strUser(username));
		LoggerLoad.info("LoggedIn User name displayed :" + actualResult);
		}
	
	@Test(priority = 2, groups = "validCredentials", dataProvider = "homeDDTestData", dataProviderClass = ExcelDataProvider.class)
	public void DSSelectionFromDropDownListAfterLogin(String DDOptions, String Title){	
		TestContext.getPom().getHomePage().clickDataStructuresDropdown();
		TestContext.getPom().getHomePage().selectFromDropdown(DDOptions);
		String actualResult = TestContext.getPom().getHomePage().getTitle();
		Assert.assertEquals(actualResult, Title );
		LoggerLoad.info("User should see the title :" + Title + "  Acutal Title is :" + actualResult);		
	}
	
	@Test(priority = 3, groups = "validCredentials", dataProvider = "homeFlexTestData", dataProviderClass = ExcelDataProvider.class)
	public void VerifyGetStartedViaFlexAfterLogin(String Flexes, String Title) {
		TestContext.getPom().getHomePage().clickFlexGetStarted(Flexes);
		String actualResult = TestContext.getPom().getHomePage().getTitle();
		Assert.assertEquals(actualResult, Title );
		LoggerLoad.info("User should see the title :" + Title + "  Acutal Title is :" + actualResult);		
		}
	
	
	@Test(priority = 4, groups = "validCredentials")
	public void VerifySignoutLink() {		
		Assert.assertEquals(TestContext.getPom().getHomePage().signoutLinkDisplayed(), true);
		LoggerLoad.info("User is logged into the application and see Signout.");
		}
	
	@Test(priority = 5, groups = "validCredentials")
	public void VerifySignout() {	
		TestContext.getPom().getHomePage().clickSignoutLink();
		Assert.assertTrue(TestContext.getPom().getHomePage().isSignoutSuccessMsgDisplayed());
		LoggerLoad.info("User is logged out and see success msg.");
		}
}
