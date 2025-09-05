package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import hooks.Hooks;
import utilities.ExcelDataProvider;
import utilities.LoggerLoad;
import utilities.TestContext;

public class LoginTest extends Hooks {
	
	String actualMsg;
	boolean actualResult;
	
	@Test (dataProvider = "testDataWrongUserName", dataProviderClass = ExcelDataProvider.class)
	public void checkLoginWithWrongUserName(String validation, String username, String password, String message) {
		LoggerLoad.info("Validate Login feature for - " + validation);
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		TestContext.getPom().getHomePage().clickSignInLink();
		TestContext.getPom().getLoginPage().enterUserName(username);
		TestContext.getPom().getLoginPage().enterPwd(password);
		TestContext.getPom().getLoginPage().loginBtnClick();
		actualResult = TestContext.getPom().getLoginPage().isErrMsgDisplayed();
		actualMsg = TestContext.getPom().getLoginPage().getErrMsg();
		Assert.assertTrue(actualResult);
		LoggerLoad.info("Expected Msg: "+ message + ". But actual Msg is " + actualMsg );
	}
	
	@Test (dataProvider = "testDataWrongPwd", dataProviderClass = ExcelDataProvider.class)
	public void checkLoginWithWrongPwd(String validation, String username, String password, String message) {
		LoggerLoad.info("Validate Login feature for - " + validation);
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		TestContext.getPom().getHomePage().clickSignInLink();
		TestContext.getPom().getLoginPage().enterUserName(username);
		TestContext.getPom().getLoginPage().enterPwd(password);
		TestContext.getPom().getLoginPage().loginBtnClick();
		actualResult = TestContext.getPom().getLoginPage().isErrMsgDisplayed();
		actualMsg = TestContext.getPom().getLoginPage().getErrMsg();
		Assert.assertTrue(actualResult);
		LoggerLoad.info("Expected Msg: "+ message + ". But actual Msg is " + actualMsg );
	}
	
	@Test (dataProvider = "testDataEmptyPwd", dataProviderClass = ExcelDataProvider.class)
	public void checkLoginWithEmptyPwd(String validation, String username, String password, String message) {
		LoggerLoad.info("Validate Login feature for - " + validation);
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		TestContext.getPom().getHomePage().clickSignInLink();
		TestContext.getPom().getLoginPage().enterUserName(username);
		TestContext.getPom().getLoginPage().enterPwd(password);
		TestContext.getPom().getLoginPage().loginBtnClick();
		actualResult = TestContext.getPom().getLoginPage().isAlertForEmptyPasswordDisplayed();
		actualMsg = TestContext.getPom().getLoginPage().getEmptyPasswordAlertMsg();
		Assert.assertTrue(actualResult);
		LoggerLoad.info("Expected Msg: "+ message + ". But actual Msg is " + actualMsg );
	}
	
	@Test (dataProvider = "testDataEmptyUserName", dataProviderClass = ExcelDataProvider.class)
	public void checkLoginWithEmptyUserName(String validation, String username, String password, String message) {
		LoggerLoad.info("Validate Login feature for - " + validation);
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		TestContext.getPom().getHomePage().clickSignInLink();
		TestContext.getPom().getLoginPage().enterUserName(username);
		TestContext.getPom().getLoginPage().enterPwd(password);
		TestContext.getPom().getLoginPage().loginBtnClick();
		actualResult = TestContext.getPom().getLoginPage().isAlertForEmptyUsernameDisplayed();
		actualMsg = TestContext.getPom().getLoginPage().getEmptyUserNameAlertMsg();
		Assert.assertTrue(actualResult);
		LoggerLoad.info("Expected Msg: "+ message + ". But actual Msg is " + actualMsg );
	}
	
	@Test (dataProvider = "validLoginCredentials", dataProviderClass = ExcelDataProvider.class)
	public void checkLoginWithValidCredentials(String validation, String username, String password, String message) {
		LoggerLoad.info("Validate Login feature for - " + validation);
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		TestContext.getPom().getHomePage().clickSignInLink();
		TestContext.getPom().getLoginPage().enterUserName(username);
		TestContext.getPom().getLoginPage().enterPwd(password);
		TestContext.getPom().getLoginPage().loginBtnClick();
		actualResult = TestContext.getPom().getHomePage().isLoginSuccessMsgDisplayed();
		actualMsg = TestContext.getPom().getHomePage().getLoginSuccessMsg();
		Assert.assertTrue(actualResult);
		LoggerLoad.info("Expected Msg: "+ message + ". But actual Msg is " + actualMsg );
	}

}
