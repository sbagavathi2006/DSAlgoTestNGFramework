package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import hooks.Hooks;
import utilities.CommonMethods;
import utilities.Constants;
import utilities.ExcelDataProvider;
import utilities.LoggerLoad;
import utilities.TestContext;

public class ArrayTest extends Hooks {
	
	String actualResult;
	
	@Test(groups = "validCredentials")
	public void checkNoOfLinksInArrayPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		int actualCount = TestContext.getPom().getArrayPage().numLinksInArrayPage();
		Assert.assertEquals(actualCount, 4);
		LoggerLoad.info("User should see 4 links in the array page. Actual count is : " + actualCount);
	}
	
	@Test(groups = "validCredentials")
	public void isArrInPythonLinkDisplayed() {		
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		Assert.assertTrue(TestContext.getPom().getArrayPage().isArraySubLinkDisplayed(Constants.ARR_IN_PHYTHON_TITLE),
	                "Expected sublink not displayed: " + Constants.ARR_IN_PHYTHON_TITLE);
		LoggerLoad.info("User should see " + Constants.ARR_IN_PHYTHON_TITLE + " on the array page");		
	    }
	
	@Test(groups = "validCredentials")
	public void isArrUsingListLinkDisplayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		Assert.assertTrue(TestContext.getPom().getArrayPage().isArraySubLinkDisplayed(Constants.ARR_USING_LIST_TITLE),
	                "Expected sublink not displayed: " + Constants.ARR_USING_LIST_TITLE);
		LoggerLoad.info("User should see " + Constants.ARR_USING_LIST_TITLE + " on the array page");				
	}
	
	@Test(groups = "validCredentials")
	public void isBasicOperaInListLinkDisplayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		Assert.assertTrue(TestContext.getPom().getArrayPage().isArraySubLinkDisplayed(Constants.ARR_BASIC_LISTS_TITLE),
	                "Expected sublink not displayed: " + Constants.ARR_BASIC_LISTS_TITLE);
		LoggerLoad.info("User should see " + Constants.ARR_BASIC_LISTS_TITLE + " on the array page");
	}
	
	@Test(groups = "validCredentials")
	public void isApplnOfArrLinkDisplayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		Assert.assertTrue(TestContext.getPom().getArrayPage().isArraySubLinkDisplayed(Constants.ARR_APPLNS_ARR_TITLE),
	                "Expected sublink not displayed: " + Constants.ARR_APPLNS_ARR_TITLE);
		LoggerLoad.info("User should see " + Constants.ARR_APPLNS_ARR_TITLE + " on the array page");
	}
	
	@Test(groups = "validCredentials")
	public void validateArrInPythonLinkClick() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_IN_PHYTHON_TITLE);	
		actualResult = TestContext.getPom().getArrayPage().getTitle();
		Assert.assertEquals(actualResult, Constants.ARR_IN_PHYTHON_TITLE);
		LoggerLoad.info("Expected title is " + Constants.ARR_IN_PHYTHON_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test(groups = "validCredentials")
	public void validateArrUsingListLinkClick() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_USING_LIST_TITLE);	
		actualResult = TestContext.getPom().getArrayPage().getTitle();
		Assert.assertEquals(actualResult, Constants.ARR_USING_LIST_TITLE);
		LoggerLoad.info("Expected title is " + Constants.ARR_USING_LIST_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test(groups = "validCredentials")
	public void validateBasicListsLinkClick() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_BASIC_LISTS_TITLE);	
		actualResult = TestContext.getPom().getArrayPage().getTitle();
		Assert.assertEquals(actualResult, Constants.ARR_BASIC_LISTS_TITLE);
		LoggerLoad.info("Expected title is " + Constants.ARR_BASIC_LISTS_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test(groups = "validCredentials")
	public void validateApplnsOfArrLinkClick() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);	
		actualResult = TestContext.getPom().getArrayPage().getTitle();
		Assert.assertEquals(actualResult, Constants.ARR_APPLNS_ARR_TITLE);
		LoggerLoad.info("Expected title is " + Constants.ARR_APPLNS_ARR_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test(groups = "validCredentials")
	public void isTryHereBtnDisplayedInArrInPythonPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_IN_PHYTHON_TITLE);	
		Assert.assertTrue(TestContext.getPom().getArrayPage().isTryHereBtnDisplayed());
		LoggerLoad.info("User should see Try Here btn on Arrays in python page");		
	}

	@Test(groups = "validCredentials")
	public void validateTryHereBtnClickInArrInPythonPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_IN_PHYTHON_TITLE);	
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		actualResult = 	TestContext.getPom().getArrayPage().getTitle();
		Assert.assertEquals(actualResult, Constants.TRY_HERE_BTN_TITLE);
		LoggerLoad.info("Expected title is " + Constants.TRY_HERE_BTN_TITLE + ". Actual Title is " + actualResult);		
	}

	@Test(groups = "validCredentials")
	public void isTryHereBtnDisplayedInArrUsingListPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_USING_LIST_TITLE);	
		Assert.assertTrue(TestContext.getPom().getArrayPage().isTryHereBtnDisplayed());
		LoggerLoad.info("User should see Try Here Btn on Array Using List page");		
	}

	@Test(groups = "validCredentials")
	public void validateTryHereBtnClickInArrUsingListPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_USING_LIST_TITLE);	
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		actualResult = 	TestContext.getPom().getArrayPage().getTitle();
		Assert.assertEquals(actualResult, Constants.TRY_HERE_BTN_TITLE);
		LoggerLoad.info("Expected title is " + Constants.TRY_HERE_BTN_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test(groups = "validCredentials")
	public void isTryHereBtnDisplayedInBasicOperaPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_BASIC_LISTS_TITLE);	
		Assert.assertTrue(TestContext.getPom().getArrayPage().isTryHereBtnDisplayed());
		LoggerLoad.info("User should see Try Here Btn on Basic Operations In List page");		
	}

	@Test(groups = "validCredentials")
	public void validateTryHereBtnClickInBasicOperaPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_BASIC_LISTS_TITLE);	
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		actualResult = 	TestContext.getPom().getArrayPage().getTitle();
		Assert.assertEquals(actualResult, Constants.TRY_HERE_BTN_TITLE);
		LoggerLoad.info("Expected title is " + Constants.TRY_HERE_BTN_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test(groups = "validCredentials")
	public void isTryHereBtnDisplayedInApplnsArrPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);	
		Assert.assertTrue(TestContext.getPom().getArrayPage().isTryHereBtnDisplayed());
		LoggerLoad.info("User should see Try Here Btn on Applications of Array page");		
	}

	@Test(groups = "validCredentials")
	public void validateTryHereBtnClickInApplnsArrPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);	
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		actualResult = 	TestContext.getPom().getArrayPage().getTitle();
		Assert.assertEquals(actualResult, Constants.TRY_HERE_BTN_TITLE);
		LoggerLoad.info("Expected title is " + Constants.TRY_HERE_BTN_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test(groups = "validCredentials")
	public void isRunButtonDisplayed(){
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);	
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		Assert.assertTrue(TestContext.getPom().getTryHerePages().isRunBtnDisplayed());
		LoggerLoad.info("User should see Run Button when user clicks on Try Here button.");		
	}
	
	@Test(groups = "validCredentials", dataProvider = "testDataEmptyCodeEditor", dataProviderClass = ExcelDataProvider.class)
	public void validateTryEditorEmptyCodeForAllArraySublinks(String subLinks, String validationType, String code, String expectedResults){
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(subLinks);		
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		CommonMethods.writeCode(code);
		TestContext.getPom().getTryHerePages().clickRunTryHere();
		Assert.assertNotNull(CommonMethods.getAlertText(driver), "Expected an alert, but no alert was displayed.");
		Assert.assertTrue(CommonMethods.getAlertText(driver).contains(expectedResults), "Expected to contain: " + expectedResults + " but got: " + CommonMethods.getAlertText(driver));
		LoggerLoad.info("User should see an appropriate alert message.");		
	}
	
	@Test(groups = "validCredentials", dataProvider = "testDataInvalidCodeRunEditor", dataProviderClass = ExcelDataProvider.class)
	public void validateTryEditorInvalidCodeRunForAllArraySublinks(String subLinks, String validationType, String code, String expectedResults) {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(subLinks);		
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		CommonMethods.writeCode(code);
		TestContext.getPom().getTryHerePages().clickRunTryHere();	
		Assert.assertTrue(CommonMethods.getAlertText(driver).contains(expectedResults), "Expected to contain: " + expectedResults + " but got: " + CommonMethods.getAlertText(driver));
		LoggerLoad.info("User should see an appropriate alert message.");		
	}
	
	@Test(groups = "validCredentials", dataProvider = "testDataValidCodeRunEditor", dataProviderClass = ExcelDataProvider.class)
	public void validateTryEditorValidCodeRunForAllArraySublinks(String subLinks, String validationType, String code, String expectedResults) {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(subLinks);		
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		CommonMethods.writeCode(code);
		TestContext.getPom().getTryHerePages().clickRunTryHere();	
		Assert.assertTrue(TestContext.getPom().getTryHerePages().isOutputSuccess());
		LoggerLoad.info("Output should be displayed and true. but got: " + TestContext.getPom().getTryHerePages().isOutputSuccess());		
	}
	
	
	@Test(groups = "validCredentials")
	public void isPraticeQnsLinkDisplayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);		
		Assert.assertTrue(TestContext.getPom().getArrayPage().isPraticeQnsLinkDisplayed());
		LoggerLoad.info("User should see pratice Qns link");		
	}		
	
	@Test(groups = "validCredentials")
	public void validatePraticeQnsLinkClick() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		String actualResult = TestContext.getPom().getArrayPage().getTitle();
		Assert.assertEquals(actualResult, Constants.PRACTICE_QNS_LINK_TITLE);
		LoggerLoad.info("Expected title is " + Constants.PRACTICE_QNS_LINK_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test(groups = "validCredentials")
	public void validateNumOfPracticeQns() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		int actualResult = TestContext.getPom().getPraticeQnsPages().numOfPraticeQns();
		Assert.assertEquals(actualResult, 4);
		LoggerLoad.info("Expected number of questions : 4 . Actual number of questions: " + actualResult);		
	}
	
	@Test(groups = "validCredentials")
	public void isPracticeQns1Displayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		boolean actualResult = TestContext.getPom().getPraticeQnsPages().isPracticeQnDisplayed(Constants.PRAC_QN_NUM1);
		Assert.assertEquals(actualResult, true);
		LoggerLoad.info("User should see search the array question link.");		
	}
	
	@Test(groups = "validCredentials")
	public void validatePracticeQns1click() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQnByNumber(Constants.PRAC_QN_NUM1);
		Assert.assertTrue(CommonMethods.getCurrentURL(TestContext.getDriver()).contains("question/" + Constants.PRAC_QN_NUM1));
		LoggerLoad.info("User should be on question 1 page.");		
	}
	
	@Test(groups = "validCredentials")
	public void isPracticeQns2Displayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		boolean actualResult = TestContext.getPom().getPraticeQnsPages().isPracticeQnDisplayed(Constants.PRAC_QN_NUM2); // define the pratice qns as constants and call the common pratice qns link.
		Assert.assertEquals(actualResult, true);
		LoggerLoad.info("User should see Max Consecutive Ones question link.");		
	}
	
	@Test(groups = "validCredentials")
	public void validatePracticeQns2click() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQnByNumber(Constants.PRAC_QN_NUM2);		
		Assert.assertTrue(CommonMethods.getCurrentURL(TestContext.getDriver()).contains("question/" + Constants.PRAC_QN_NUM2));
		LoggerLoad.info("User should be on question 2 page.");		
	}
	
	@Test(groups = "validCredentials")
	public void isPracticeQns3Displayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		boolean actualResult = TestContext.getPom().getPraticeQnsPages().isPracticeQnDisplayed(Constants.PRAC_QN_NUM3);
		Assert.assertEquals(actualResult, true);
		LoggerLoad.info("User should see Find Numbers with Even Number of Digits question link.");		
	}
	
	@Test(groups = "validCredentials")
	public void validatePracticeQns3click() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQnByNumber(Constants.PRAC_QN_NUM3);		
		Assert.assertTrue(CommonMethods.getCurrentURL(TestContext.getDriver()).contains("question/" + Constants.PRAC_QN_NUM3));
		LoggerLoad.info("User should be on question 3 page.");		
	}
	
	@Test(groups = "validCredentials")
	public void isPracticeQns4Displayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		boolean actualResult = TestContext.getPom().getPraticeQnsPages().isPracticeQnDisplayed(Constants.PRAC_QN_NUM4);
		Assert.assertEquals(actualResult, true);
		LoggerLoad.info("User should see Squares of  a Sorted Array question link.");		
	}
	
	@Test(groups = "validCredentials")
	public void validatePracticeQns4click() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQnByNumber(Constants.PRAC_QN_NUM4);		
		Assert.assertTrue(CommonMethods.getCurrentURL(TestContext.getDriver()).contains("question/" + Constants.PRAC_QN_NUM4));
		LoggerLoad.info("User should be on question 4 page.");		
	}
	
	@Test(groups = "validCredentials", dataProvider = "testDataExistingCodSnippet", dataProviderClass = ExcelDataProvider.class)
	public void validateAllPracticeQnsForExistingCodeRun(String questions, String validationType, String code, String expectedResultsRun, String expectedResultsSubmit ) {
		LoggerLoad.info("Validating for Existing Code Run for the question : " + questions);
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQns(questions);
		CommonMethods.writeCode(code);
		TestContext.getPom().getPraticeQnsPages().clickRunBtn();
		Assert.assertNotNull(CommonMethods.getAlertText(driver), "Expected an alert, but no alert was displayed.");
		Assert.assertTrue(CommonMethods.getAlertText(driver).contains(expectedResultsRun));
		LoggerLoad.info("Expected to contain: " + expectedResultsRun + " Actual Alert: " + CommonMethods.getAlertText(driver));
	}
	
	@Test(groups = "validCredentials", dataProvider = "testDataInvalidCodSnippet", dataProviderClass = ExcelDataProvider.class)
	public void validateAllPracticeQnsForInvalidCodeRun(String questions, String validationType, String code, String expectedResultsRun, String expectedResultsSubmit ) {
		LoggerLoad.info("Validating for Invalid Code Run for the question : " + questions);
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQns(questions);
		CommonMethods.writeCode(code);
		TestContext.getPom().getPraticeQnsPages().clickRunBtn();
		Assert.assertNotNull(CommonMethods.getAlertText(driver), "Expected an alert, but no alert was displayed.");
		Assert.assertTrue(CommonMethods.getAlertText(driver).contains(expectedResultsRun));
		LoggerLoad.info("Expected to contain: " + expectedResultsRun + " Actual Alert: " + CommonMethods.getAlertText(driver));
	}
	
	@Test(groups = "validCredentials", dataProvider = "testDataValidCodSnippet", dataProviderClass = ExcelDataProvider.class)
	public void validateAllPracticeQnsForValidCodeRun(String questions, String validationType, String code, String expectedResultsRun, String expectedResultsSubmit ) {
		LoggerLoad.info("Validating for Valid Code Run for the question : " + questions);
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQns(questions);
		CommonMethods.writeCode(code);
		TestContext.getPom().getPraticeQnsPages().clickRunBtn();
		Assert.assertTrue(TestContext.getPom().getPraticeQnsPages().isOutputSuccess());
		LoggerLoad.info("User should see the result for the executed code.");
	}
	
	@Test(groups = "validCredentials", dataProvider = "testDataExistingCodSnippet", dataProviderClass = ExcelDataProvider.class)
	public void validateAllPracticeQnsForExistingCodeSubmit(String questions, String validationType, String code, String expectedResultsRun, String expectedResultsSubmit ) {
		LoggerLoad.info("Validating for Existing Code Run for the question : " + questions);
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQns(questions);
		CommonMethods.writeCode(code);
		TestContext.getPom().getPraticeQnsPages().btnSubmit();
		actualResult = TestContext.getPom().getPraticeQnsPages().getSubmitMsg();
		Assert.assertTrue(actualResult.contains(expectedResultsSubmit));
		LoggerLoad.info("Expected to contain: " + expectedResultsSubmit + " Actual Message: " + actualResult);
	}
	
	@Test(groups = "validCredentials", dataProvider = "testDataInvalidCodSnippet", dataProviderClass = ExcelDataProvider.class)
	public void validateAllPracticeQnsForInvalidCodeSubmit(String questions, String validationType, String code, String expectedResultsRun, String expectedResultsSubmit ) {
		LoggerLoad.info("Validating for Invalid Code Run for the question : " + questions);
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQns(questions);
		CommonMethods.writeCode(code);
		TestContext.getPom().getPraticeQnsPages().btnSubmit();
		actualResult = TestContext.getPom().getPraticeQnsPages().getSubmitMsg();
		Assert.assertTrue(actualResult.contains(expectedResultsSubmit));
		LoggerLoad.info("Expected to contain: " + expectedResultsSubmit + " Actual Message: " + actualResult);
	}
	
	@Test(groups = "validCredentials", dataProvider = "testDataValidCodSnippet", dataProviderClass = ExcelDataProvider.class)
	public void validateAllPracticeQnsForValidCodeSubmit(String questions, String validationType, String code, String expectedResultsRun, String expectedResultsSubmit ) {
		LoggerLoad.info("Validating for Valid Code Run for the question : " + questions);
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQns(questions);
		CommonMethods.writeCode(code);
		TestContext.getPom().getPraticeQnsPages().btnSubmit();
		actualResult = TestContext.getPom().getPraticeQnsPages().getSubmitMsg();
		Assert.assertTrue(actualResult.contains(expectedResultsSubmit));
		LoggerLoad.info("Expected to contain: " + expectedResultsSubmit + " Actual Message: " + actualResult);
	}

}
