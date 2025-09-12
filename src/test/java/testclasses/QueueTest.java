package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import hooks.Hooks;
import utilities.Constants;
import utilities.ExcelDataProvider;
import utilities.LoggerLoad;
import utilities.TestContext;

@Test(groups = "validCredentials")
public class QueueTest extends Hooks {
	String actualResult;
	
	@Test
	public void checkNoOfLinksInQueuePage() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		int actualCount = TestContext.getPom().getQueuePage().numLinksInPage();
		Assert.assertEquals(actualCount, 4);
		LoggerLoad.info("User should see 4 links in the array page. Actual count is : " + actualCount);
	}
	
	@Test
	public void isImpQueInPythonLinkDisplayed() {		
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		Assert.assertTrue(TestContext.getPom().getQueuePage().isSubLinksDisplayed(Constants.QUEUE_IMP_OF_QUE_IN_PYTHON),
				"Expected sublink not displayed: " + TestContext.getDriver().getTitle());
		LoggerLoad.info("User should see " + Constants.QUEUE_IMP_OF_QUE_IN_PYTHON + " on the queue page");		
	    }
	
	@Test
	public void isImpUsingCollectLinkDisplayed() {		
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		Assert.assertTrue(TestContext.getPom().getQueuePage().isSubLinksDisplayed(Constants.QUEUE_IMP_USING_COLLE),
				"Expected sublink not displayed: " + TestContext.getDriver().getTitle());
		LoggerLoad.info("User should see " + Constants.QUEUE_IMP_USING_COLLE + " on the queue page");		
	    }
	
	@Test
	public void isImpUsingArrLinkDisplayed() {		
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		Assert.assertTrue(TestContext.getPom().getQueuePage().isSubLinksDisplayed(Constants.QUEUE_IMP_USING_ARR),
				"Expected sublink not displayed: " + TestContext.getDriver().getTitle());
		LoggerLoad.info("User should see " + Constants.QUEUE_IMP_USING_ARR + " on the queue page");		
	    }
	
	@Test
	public void isQueOperaLinkDisplayed() {		
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		Assert.assertTrue(TestContext.getPom().getQueuePage().isSubLinksDisplayed(Constants.QUEUE_QUEUE_OPER),
				"Expected sublink not displayed: " + TestContext.getDriver().getTitle());
		LoggerLoad.info("User should see " + Constants.QUEUE_QUEUE_OPER + " on the queue page");		
	    }
			
	@Test
	public void validateImpQueInPythonLinkClick() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_IMP_OF_QUE_IN_PYTHON);	
		actualResult = TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.QUEUE_IMP_OF_QUE_IN_PYTHON);
		LoggerLoad.info("Expected title is " + Constants.QUEUE_IMP_OF_QUE_IN_PYTHON + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void validateImpUsingCollectLinkClick() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_IMP_USING_COLLE);	
		actualResult = TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.QUEUE_IMP_USING_COLLE);
		LoggerLoad.info("Expected title is " + Constants.QUEUE_IMP_USING_COLLE + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void validateImpUsingArrLinkClick() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_IMP_USING_ARR);	
		actualResult = TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.QUEUE_IMP_USING_ARR);
		LoggerLoad.info("Expected title is " + Constants.QUEUE_IMP_USING_ARR + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void validateQueOperaLinkClick() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_QUEUE_OPER);	
		actualResult = TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.QUEUE_QUEUE_OPER);
		LoggerLoad.info("Expected title is " + Constants.QUEUE_QUEUE_OPER + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void isTryHereBtnDisplayedInImpQueInPythonPage() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_IMP_OF_QUE_IN_PYTHON);	
		Assert.assertTrue(TestContext.getPom().getQueuePage().isTryHereBtnDisplayed());
		LoggerLoad.info("User should see Try Here btn on " + Constants.QUEUE_IMP_OF_QUE_IN_PYTHON +" page");		
	}

	@Test
	public void validateTryHereBtnClickInImpQueInPythonPage() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_IMP_OF_QUE_IN_PYTHON);	
		TestContext.getPom().getQueuePage().clickTryHereBtn();
		actualResult = 	TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.TRY_HERE_BTN_TITLE);
		LoggerLoad.info("Expected title is " + Constants.TRY_HERE_BTN_TITLE + ". Actual Title is " + actualResult);		
	}

	@Test
	public void isTryHereBtnDisplayedInImpUsingCollectPage() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_IMP_USING_COLLE);	
		Assert.assertTrue(TestContext.getPom().getQueuePage().isTryHereBtnDisplayed());
		LoggerLoad.info("User should see Try Here btn on " + Constants.QUEUE_IMP_USING_COLLE +" page");		
	}

	@Test
	public void validateTryHereBtnClickInImpUsingCollectPage() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_IMP_USING_COLLE);	
		TestContext.getPom().getQueuePage().clickTryHereBtn();
		actualResult = 	TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.TRY_HERE_BTN_TITLE);
		LoggerLoad.info("Expected title is " + Constants.TRY_HERE_BTN_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void isTryHereBtnDisplayedInImpUsingArrCollectPage() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_IMP_USING_ARR);	
		Assert.assertTrue(TestContext.getPom().getQueuePage().isTryHereBtnDisplayed());
		LoggerLoad.info("User should see Try Here btn on " + Constants.QUEUE_IMP_USING_ARR +" page");		
	}

	@Test
	public void validateTryHereBtnClickInImpUsingArrPage() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_IMP_USING_ARR);	
		TestContext.getPom().getQueuePage().clickTryHereBtn();
		actualResult = 	TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.TRY_HERE_BTN_TITLE);
		LoggerLoad.info("Expected title is " + Constants.TRY_HERE_BTN_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void isTryHereBtnDisplayedInQueOperaPage() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_QUEUE_OPER);	
		Assert.assertTrue(TestContext.getPom().getQueuePage().isTryHereBtnDisplayed());
		LoggerLoad.info("User should see Try Here btn on " + Constants.QUEUE_QUEUE_OPER +" page");		
	}

	@Test
	public void validateTryHereBtnClickInQueOperaPage() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_QUEUE_OPER);	
		TestContext.getPom().getQueuePage().clickTryHereBtn();
		actualResult = 	TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.TRY_HERE_BTN_TITLE);
		LoggerLoad.info("Expected title is " + Constants.TRY_HERE_BTN_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void isRunButtonDisplayedOnQueueTryEditor(){
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_QUEUE_OPER);	
		TestContext.getPom().getQueuePage().clickTryHereBtn();
		Assert.assertTrue(TestContext.getPom().getTryHerePages().isRunBtnDisplayed());
		LoggerLoad.info("User should see Run Button when user clicks on Try Here button from Queue Page.");		
	}
	
	@Test(dataProvider = "testDataQueueEmptyCodeEditor", dataProviderClass = ExcelDataProvider.class)
	public void validateTryEditorEmptyCodeForAllQueueSublinks(String subLinks, String validationType, String code, String expectedResults){
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(subLinks);		
		TestContext.getPom().getQueuePage().clickTryHereBtn();
		cm.writeCode(code);
		TestContext.getPom().getTryHerePages().clickRunTryHere();
		Assert.assertNotNull(cm.getAlertText(driver), "Expected an alert, but no alert was displayed.");
		Assert.assertTrue(cm.getAlertText(driver).contains(expectedResults), "Expected to contain: " + expectedResults + " but got: " + cm.getAlertText(driver));
		LoggerLoad.info("User should see an appropriate alert message.");		
	}
	
	@Test(dataProvider = "testDataQueueInvalidCodeRunEditor", dataProviderClass = ExcelDataProvider.class)
	public void validateTryEditorInvalidCodeRunForAllQueueSublinks(String subLinks, String validationType, String code, String expectedResults) {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(subLinks);		
		TestContext.getPom().getQueuePage().clickTryHereBtn();
		cm.writeCode(code);
		TestContext.getPom().getTryHerePages().clickRunTryHere();	
		Assert.assertTrue(cm.getAlertText(driver).contains(expectedResults), "Expected to contain: " + expectedResults + " but got: " + cm.getAlertText(driver));
		LoggerLoad.info("User should see an appropriate alert message.");		
	}
	
	@Test(dataProvider = "testDataQueueValidCodeRunEditor", dataProviderClass = ExcelDataProvider.class)
	public void validateTryEditorValidCodeRunForAllQueueSublinks(String subLinks, String validationType, String code, String expectedResults) {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(subLinks);		
		TestContext.getPom().getQueuePage().clickTryHereBtn();
		cm.writeCode(code);
		TestContext.getPom().getTryHerePages().clickRunTryHere();	
		Assert.assertTrue(TestContext.getPom().getTryHerePages().isOutputSuccess());
		LoggerLoad.info("Output should be displayed and true. but got: " + TestContext.getPom().getTryHerePages().isOutputSuccess());		
	}
	
	
	@Test
	public void isPraticeQnsLinkDisplayedForQueue() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_QUEUE_OPER);		
		Assert.assertTrue(TestContext.getPom().getQueuePage().isPracticeQnsLinkDisplayed());
		LoggerLoad.info("User should see pratice Qns link in Queue Page.");		
	}		
	
	@Test
	public void validatePraticeQnsLinkClickForQueue() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_QUEUE_OPER);
		TestContext.getPom().getQueuePage().clickPracticeQnsLink();
		actualResult = TestContext.getDriver().getTitle();
		Assert.assertEquals(actualResult, Constants.PRACTICE_QNS_LINK_TITLE);
		LoggerLoad.info("Expected title is " + Constants.PRACTICE_QNS_LINK_TITLE + ". Actual Title is " + actualResult);		
	}
	
	@Test
	public void isPracticeQnsDisplayedForQueue() {
		TestContext.getPom().getHomePage().queueGetStartBtnClick();
		TestContext.getPom().getQueuePage().clickSubLinks(Constants.QUEUE_QUEUE_OPER);
		TestContext.getPom().getQueuePage().clickPracticeQnsLink();
		boolean actualResult = TestContext.getPom().getQueuePage().isPracticeQnDisplayed(Constants.PRAC_QN_NUM1);
		Assert.assertTrue(actualResult, 
		        "Expected at least one practice question to be displayed, but none found.");
		LoggerLoad.info("Expected-true. Atleast one pratice question is displayed for Queue Page. Actual: " + actualResult );		
	}

}
