package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import hooks.Hooks;
import utilities.Constants;
import utilities.ExcelDataProvider;
import utilities.LoggerLoad;
import utilities.TestContext;

@Test(groups = "validCredentials")
public class ArrayTest extends Hooks {
	
	String actualResult;

	@Test
	public void checkNoOfLinksInArrayPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		int actualCount = TestContext.getPom().getArrayPage().numLinksInArrayPage();
		Assert.assertEquals(actualCount, 4);
		LoggerLoad.info("User should see 4 links in the array page. Actual count is : " + actualCount);
	}
	
	@Test
	public void isArrInPythonLinkDisplayed() {		
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		Assert.assertTrue(TestContext.getPom().getArrayPage().isArraySubLinkDisplayed(Constants.ARR_IN_PHYTHON_TITLE),
	                "Expected sublink not displayed: " + TestContext.getDriver().getTitle());
		LoggerLoad.info("User should see " + Constants.ARR_IN_PHYTHON_TITLE + " on the array page");		
	    }
	
	@Test
	public void isArrUsingListLinkDisplayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		Assert.assertTrue(TestContext.getPom().getArrayPage().isArraySubLinkDisplayed(Constants.ARR_USING_LIST_TITLE),
				"Expected sublink not displayed: " + TestContext.getDriver().getTitle());
		LoggerLoad.info("User should see " + Constants.ARR_USING_LIST_TITLE + " on the array page");				
	}
	
	@Test
	public void isBasicOperaInListLinkDisplayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		Assert.assertTrue(TestContext.getPom().getArrayPage().isArraySubLinkDisplayed(Constants.ARR_BASIC_LISTS_TITLE),
				"Expected sublink not displayed: " + TestContext.getDriver().getTitle());
		LoggerLoad.info("User should see " + Constants.ARR_BASIC_LISTS_TITLE + " on the array page");
	}
	
	@Test
	public void isApplnOfArrLinkDisplayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		Assert.assertTrue(TestContext.getPom().getArrayPage().isArraySubLinkDisplayed(Constants.ARR_APPLNS_ARR_TITLE),
				"Expected sublink not displayed: " + TestContext.getDriver().getTitle());
		LoggerLoad.info("User should see " + Constants.ARR_APPLNS_ARR_TITLE + " on the array page");
	}
	
	@Test
	public void validateArrInPythonLinkClick() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_IN_PHYTHON_TITLE);	
		actualResult = TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.ARR_IN_PHYTHON_TITLE);
		LoggerLoad.info("Expected title is " + Constants.ARR_IN_PHYTHON_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void validateArrUsingListLinkClick() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_USING_LIST_TITLE);	
		actualResult = TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.ARR_USING_LIST_TITLE);
		LoggerLoad.info("Expected title is " + Constants.ARR_USING_LIST_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void validateBasicListsLinkClick() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_BASIC_LISTS_TITLE);	
		actualResult = TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.ARR_BASIC_LISTS_TITLE);
		LoggerLoad.info("Expected title is " + Constants.ARR_BASIC_LISTS_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void validateApplnsOfArrLinkClick() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);	
		actualResult = TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.ARR_APPLNS_ARR_TITLE);
		LoggerLoad.info("Expected title is " + Constants.ARR_APPLNS_ARR_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void isTryHereBtnDisplayedInArrInPythonPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_IN_PHYTHON_TITLE);	
		Assert.assertTrue(TestContext.getPom().getArrayPage().isTryHereBtnDisplayed());
		LoggerLoad.info("User should see Try Here btn on Arrays in python page");		
	}

	@Test
	public void validateTryHereBtnClickInArrInPythonPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_IN_PHYTHON_TITLE);	
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		actualResult = 	TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.TRY_HERE_BTN_TITLE);
		LoggerLoad.info("Expected title is " + Constants.TRY_HERE_BTN_TITLE + ". Actual Title is " + actualResult);		
	}

	@Test
	public void isTryHereBtnDisplayedInArrUsingListPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_USING_LIST_TITLE);	
		Assert.assertTrue(TestContext.getPom().getArrayPage().isTryHereBtnDisplayed());
		LoggerLoad.info("User should see Try Here Btn on Array Using List page");		
	}

	@Test
	public void validateTryHereBtnClickInArrUsingListPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_USING_LIST_TITLE);	
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		actualResult = 	TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.TRY_HERE_BTN_TITLE);
		LoggerLoad.info("Expected title is " + Constants.TRY_HERE_BTN_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void isTryHereBtnDisplayedInBasicOperaPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_BASIC_LISTS_TITLE);	
		Assert.assertTrue(TestContext.getPom().getArrayPage().isTryHereBtnDisplayed());
		LoggerLoad.info("User should see Try Here Btn on Basic Operations In List page");		
	}

	@Test
	public void validateTryHereBtnClickInBasicOperaPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_BASIC_LISTS_TITLE);	
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		actualResult = 	TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.TRY_HERE_BTN_TITLE);
		LoggerLoad.info("Expected title is " + Constants.TRY_HERE_BTN_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void isTryHereBtnDisplayedInApplnsArrPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);	
		Assert.assertTrue(TestContext.getPom().getArrayPage().isTryHereBtnDisplayed());
		LoggerLoad.info("User should see Try Here Btn on Applications of Array page");		
	}

	@Test
	public void validateTryHereBtnClickInApplnsArrPage() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);	
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		actualResult = 	TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.TRY_HERE_BTN_TITLE);
		LoggerLoad.info("Expected title is " + Constants.TRY_HERE_BTN_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void isRunButtonDisplayedOnArrayTryEditor(){
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);	
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		Assert.assertTrue(TestContext.getPom().getTryHerePages().isRunBtnDisplayed());
		LoggerLoad.info("User should see Run Button when user clicks on Try Here button from Array Page.");		
	}
	
	@Test(dataProvider = "testDataEmptyCodeEditor", dataProviderClass = ExcelDataProvider.class)
	public void validateTryEditorEmptyCodeForAllArraySublinks(String subLinks, String validationType, String code, String expectedResults){
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(subLinks);		
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		cm.writeCode(code);
		TestContext.getPom().getTryHerePages().clickRunTryHere();
		Assert.assertNotNull(cm.getAlertText(driver), "Expected an alert, but no alert was displayed.");
		Assert.assertTrue(cm.getAlertText(driver).contains(expectedResults), "Expected to contain: " + expectedResults + " but got: " + cm.getAlertText(driver));
		LoggerLoad.info("User should see an appropriate alert message.");		
	}
	
	@Test(dataProvider = "testDataInvalidCodeRunEditor", dataProviderClass = ExcelDataProvider.class)
	public void validateTryEditorInvalidCodeRunForAllArraySublinks(String subLinks, String validationType, String code, String expectedResults) {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(subLinks);		
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		cm.writeCode(code);
		TestContext.getPom().getTryHerePages().clickRunTryHere();	
		Assert.assertTrue(cm.getAlertText(driver).contains(expectedResults), "Expected to contain: " + expectedResults + " but got: " + cm.getAlertText(driver));
		LoggerLoad.info("User should see an appropriate alert message.");		
	}
	
	@Test(dataProvider = "testDataValidCodeRunEditor", dataProviderClass = ExcelDataProvider.class)
	public void validateTryEditorValidCodeRunForAllArraySublinks(String subLinks, String validationType, String code, String expectedResults) {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(subLinks);		
		TestContext.getPom().getArrayPage().clickTryHereBtn();
		cm.writeCode(code);
		TestContext.getPom().getTryHerePages().clickRunTryHere();	
		Assert.assertTrue(TestContext.getPom().getTryHerePages().isOutputSuccess());
		LoggerLoad.info("Output should be displayed and true. but got: " + TestContext.getPom().getTryHerePages().isOutputSuccess());		
	}
	
	
	@Test
	public void isPraticeQnsLinkDisplayedForArray(){
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);		
		Assert.assertTrue(TestContext.getPom().getArrayPage().isPraticeQnsLinkDisplayed());
		LoggerLoad.info("User should see pratice Qns link in Array Page.");		
	}		
	
	@Test
	public void validatePraticeQnsLinkClickForArray() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		actualResult = TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.PRACTICE_QNS_LINK_TITLE);
		LoggerLoad.info("Expected title is " + Constants.PRACTICE_QNS_LINK_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void validateNumOfPracticeQnsForArray() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		int actualResult = TestContext.getPom().getPraticeQnsPages().numOfPraticeQns();
		Assert.assertEquals(actualResult, 4);
		LoggerLoad.info("Expected number of questions : 4 . Actual number of questions: " + actualResult);		
	}
	
	@Test
	public void isPracticeQns1Displayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		boolean actualResult = TestContext.getPom().getPraticeQnsPages().isPracticeQnDisplayed(Constants.PRAC_QN_NUM1);
		Assert.assertEquals(actualResult, true);
		LoggerLoad.info("User should see search the array question link.");		
	}
	
	@Test
	public void validatePracticeQns1click() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQnByNumber(Constants.PRAC_QN_NUM1);
		Assert.assertTrue(cm.getCurrentURL(TestContext.getDriver()).contains("question/" + Constants.PRAC_QN_NUM1));
		LoggerLoad.info("User should be on question 1 page.");		
	}
	
	@Test
	public void isPracticeQns2Displayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		boolean actualResult = TestContext.getPom().getPraticeQnsPages().isPracticeQnDisplayed(Constants.PRAC_QN_NUM2); // define the pratice qns as constants and call the common pratice qns link.
		Assert.assertEquals(actualResult, true);
		LoggerLoad.info("User should see Max Consecutive Ones question link.");		
	}
	
	@Test
	public void validatePracticeQns2click() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQnByNumber(Constants.PRAC_QN_NUM2);		
		Assert.assertTrue(cm.getCurrentURL(TestContext.getDriver()).contains("question/" + Constants.PRAC_QN_NUM2));
		LoggerLoad.info("User should be on question 2 page.");		
	}
	
	@Test
	public void isPracticeQns3Displayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		boolean actualResult = TestContext.getPom().getPraticeQnsPages().isPracticeQnDisplayed(Constants.PRAC_QN_NUM3);
		Assert.assertEquals(actualResult, true);
		LoggerLoad.info("User should see Find Numbers with Even Number of Digits question link.");		
	}
	
	@Test
	public void validatePracticeQns3click() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQnByNumber(Constants.PRAC_QN_NUM3);		
		Assert.assertTrue(cm.getCurrentURL(TestContext.getDriver()).contains("question/" + Constants.PRAC_QN_NUM3));
		LoggerLoad.info("User should be on question 3 page.");		
	}
	
	@Test
	public void isPracticeQns4Displayed() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		boolean actualResult = TestContext.getPom().getPraticeQnsPages().isPracticeQnDisplayed(Constants.PRAC_QN_NUM4);
		Assert.assertEquals(actualResult, true);
		LoggerLoad.info("User should see Squares of  a Sorted Array question link.");		
	}
	
	@Test
	public void validatePracticeQns4click() {
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQnByNumber(Constants.PRAC_QN_NUM4);		
		Assert.assertTrue(cm.getCurrentURL(TestContext.getDriver()).contains("question/" + Constants.PRAC_QN_NUM4));
		LoggerLoad.info("User should be on question 4 page.");		
	}
	
	@Test(dataProvider = "testDataExistingCodSnippet", dataProviderClass = ExcelDataProvider.class)
	public void validateAllPracticeQnsForExistingCodeRun(String questions, String validationType, String code, String expectedResultsRun, String expectedResultsSubmit ) {
		LoggerLoad.info("Validating for Existing Code Run for the question : " + questions);
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQns(questions);
		cm.writeCode(code);
		TestContext.getPom().getPraticeQnsPages().clickRunBtn();
		Assert.assertNotNull(cm.getAlertText(driver), "Expected an alert, but no alert was displayed.");
		Assert.assertTrue(cm.getAlertText(driver).contains(expectedResultsRun));
		LoggerLoad.info("Expected to contain: " + expectedResultsRun + " Actual Alert: " + cm.getAlertText(driver));
	}
	
	@Test(dataProvider = "testDataInvalidCodSnippet", dataProviderClass = ExcelDataProvider.class)
	public void validateAllPracticeQnsForInvalidCodeRun(String questions, String validationType, String code, String expectedResultsRun, String expectedResultsSubmit ) {
		LoggerLoad.info("Validating for Invalid Code Run for the question : " + questions);
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQns(questions);
		cm.writeCode(code);
		TestContext.getPom().getPraticeQnsPages().clickRunBtn();
		Assert.assertNotNull(cm.getAlertText(driver), "Expected an alert, but no alert was displayed.");
		Assert.assertTrue(cm.getAlertText(driver).contains(expectedResultsRun));
		LoggerLoad.info("Expected to contain: " + expectedResultsRun + " Actual Alert: " + cm.getAlertText(driver));
	}
	
	@Test(dataProvider = "testDataValidCodSnippet", dataProviderClass = ExcelDataProvider.class)
	public void validateAllPracticeQnsForValidCodeRun(String questions, String validationType, String code, String expectedResultsRun, String expectedResultsSubmit ) {
		LoggerLoad.info("Validating for Valid Code Run for the question : " + questions);
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQns(questions);
		cm.writeCode(code);
		TestContext.getPom().getPraticeQnsPages().clickRunBtn();
		Assert.assertTrue(TestContext.getPom().getPraticeQnsPages().isOutputSuccess());
		LoggerLoad.info("User should see the result for the executed code.");
	}
	
	@Test(dataProvider = "testDataExistingCodSnippet", dataProviderClass = ExcelDataProvider.class)
	public void validateAllPracticeQnsForExistingCodeSubmit(String questions, String validationType, String code, String expectedResultsRun, String expectedResultsSubmit ) {
		LoggerLoad.info("Validating for Existing Code Run for the question : " + questions);
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQns(questions);
		cm.writeCode(code);
		TestContext.getPom().getPraticeQnsPages().btnSubmit();
		actualResult = TestContext.getPom().getPraticeQnsPages().getSubmitMsg();
		Assert.assertTrue(actualResult.contains(expectedResultsSubmit));
		LoggerLoad.info("Expected to contain: " + expectedResultsSubmit + " Actual Message: " + actualResult);
	}
	
	@Test(dataProvider = "testDataInvalidCodSnippet", dataProviderClass = ExcelDataProvider.class)
	public void validateAllPracticeQnsForInvalidCodeSubmit(String questions, String validationType, String code, String expectedResultsRun, String expectedResultsSubmit ) {
		LoggerLoad.info("Validating for Invalid Code Run for the question : " + questions);
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQns(questions);
		cm.writeCode(code);
		TestContext.getPom().getPraticeQnsPages().btnSubmit();
		actualResult = TestContext.getPom().getPraticeQnsPages().getSubmitMsg();
		Assert.assertTrue(actualResult.contains(expectedResultsSubmit));
		LoggerLoad.info("Expected to contain: " + expectedResultsSubmit + " Actual Message: " + actualResult);
	}
	
	@Test(dataProvider = "testDataValidCodSnippet", dataProviderClass = ExcelDataProvider.class)
	public void validateAllPracticeQnsForValidCodeSubmit(String questions, String validationType, String code, String expectedResultsRun, String expectedResultsSubmit ) {
		LoggerLoad.info("Validating for Valid Code Run for the question : " + questions);
		TestContext.getPom().getHomePage().arrayGetStartBtnClick();
		TestContext.getPom().getArrayPage().clickSubLinks(Constants.ARR_APPLNS_ARR_TITLE);
		TestContext.getPom().getArrayPage().clickPracticeQnsLink();
		TestContext.getPom().getPraticeQnsPages().clickPracticeQns(questions);
		cm.writeCode(code);
		TestContext.getPom().getPraticeQnsPages().btnSubmit();
		actualResult = TestContext.getPom().getPraticeQnsPages().getSubmitMsg();
		Assert.assertTrue(actualResult.contains(expectedResultsSubmit));
		LoggerLoad.info("Expected to contain: " + expectedResultsSubmit + " Actual Message: " + actualResult);
	}

}
