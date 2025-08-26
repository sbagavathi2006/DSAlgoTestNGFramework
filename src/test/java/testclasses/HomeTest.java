package testclasses;

import org.testng.annotations.Test;

import hooks.Hooks;

import org.testng.Assert;

import utilities.ExcelDataProvider;
import utilities.ExcelReaderFillo;
import utilities.LoggerLoad;

public class HomeTest extends Hooks{
	
	@Test
	public void HomePageLinksDisplayed() {
		boolean actualResult = pom.getHomePage().linksDisplayed();
		Assert.assertTrue(actualResult, "Links are not displayed on Home Page");
		LoggerLoad.info("Home Page should have the links(NumpyNinja, SignIn and Registration) displayed");
	}
	
	@Test
	public void NumpyNinjaLinkClick() {
		pom.getHomePage().clickNumpyNinja();
		Assert.assertEquals(driver.getTitle(), "Numpyinja");
		LoggerLoad.info("DSAlgo Home Page should be reloaded. Page Title is " + driver.getTitle());
	}
	
	@Test
	public void RegisterLinkClick() {
		pom.getHomePage().clickRegisterLink();
		Assert.assertEquals(driver.getTitle(),"Registration");
		LoggerLoad.info("User should land on registration page. The page title is " + driver.getTitle());		
	}
	
	@Test
	public void SignInLinkClick() {
		pom.getHomePage().clickSignInLink();
		Assert.assertEquals(driver.getTitle(),"Login");
		LoggerLoad.info("User should land on registration page. The page title is " + driver.getTitle());		
	}
	
	@Test
	public void DataStructuresDropdownClick() {
		pom.getHomePage().clickDataStructuresDropdown();
		int actualCount = pom.getHomePage().getDsDropdownOptionsCount();
		Assert.assertEquals(actualCount, 6);
		LoggerLoad.info("User should see 6 options from the dropdown list. No. of options in the list is " + actualCount);		
	}
	
	@Test(dataProvider = "homeDDTestData", dataProviderClass = ExcelDataProvider.class)
	public void DSSelectionFromDropDownList(String DDOptions) {		
		pom.getHomePage().clickDataStructuresDropdown();
		pom.getHomePage().selectFromDropdown(DDOptions);
		Assert.assertEquals(pom.getHomePage().isErrMsgDisplayed(), true);
		LoggerLoad.info("User should see error message that you are not logged in");		
	}
	
	@Test
	public void NumOfFlexesInHome() {
		int actualCount = pom.getHomePage().getFlexCount();
		Assert.assertEquals(actualCount, 7);
		LoggerLoad.info("User should see 7 cards in the home. No. of cards is " + actualCount);
	}
	
	@Test(dataProvider = "homeFlexTestData", dataProviderClass = ExcelDataProvider.class)
	public void VerifyGetStartedViaFlexBeforeLogin(String Flexes) {
		pom.getHomePage().clickFlexGetStarted(Flexes);
		}
}
