package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import hooks.Hooks;
import utilities.Constants;
import utilities.ExcelDataProvider;
import utilities.LoggerLoad;
import utilities.TestContext;

@Test(groups = "validCredentials")
public class GraphTest extends Hooks{
	
		String actualResult;
		
		@Test
		public void checkNoOfLinksInGraphPage() {
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			int actualCount = TestContext.getPom().getGraphPage().numLinksInGraphPage();
			Assert.assertEquals(actualCount, 2);
			LoggerLoad.info("User should see 2 links in the array page. Actual count is : " + actualCount);
		}
		
		@Test
		public void isGraphLinkDisplayed() {		
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			Assert.assertTrue(TestContext.getPom().getGraphPage().isGraphSubLinksDisplayed(Constants.GRAPH_GRAPH_TITLE),
					"Expected sublink not displayed: " + TestContext.getDriver().getTitle());
			LoggerLoad.info("User should see " + Constants.GRAPH_GRAPH_TITLE + " on the graph page");		
		    }
		
		@Test
		public void isGraphRepLinkDisplayed() {		
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			Assert.assertTrue(TestContext.getPom().getGraphPage().isGraphSubLinksDisplayed(Constants.GRAPH_GRAPH_REP_TITLE),
					"Expected sublink not displayed: " + TestContext.getDriver().getTitle());
			LoggerLoad.info("User should see " + Constants.GRAPH_GRAPH_REP_TITLE + " on the graph page");		
		    }
				
		@Test
		public void validateGraphLinkClick() {
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			TestContext.getPom().getGraphPage().clickGraphSubLinks(Constants.GRAPH_GRAPH_TITLE);	
			actualResult = TestContext.getDriver().getTitle();
			Assert.assertEquals(actualResult, Constants.GRAPH_GRAPH_TITLE);
			LoggerLoad.info("Expected title is " + Constants.GRAPH_GRAPH_TITLE + ". Actual Title is " + actualResult);		
		}
		
		@Test
		public void validateGraphRepLinkClick() {
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			TestContext.getPom().getGraphPage().clickGraphSubLinks(Constants.GRAPH_GRAPH_REP_TITLE);	
			actualResult = TestContext.getDriver().getTitle();
			Assert.assertEquals(actualResult, Constants.GRAPH_GRAPH_REP_TITLE);
			LoggerLoad.info("Expected title is " + Constants.GRAPH_GRAPH_REP_TITLE + ". Actual Title is " + actualResult);		
		}
		
		@Test
		public void isTryHereBtnDisplayedInGraphPage() {
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			TestContext.getPom().getGraphPage().clickGraphSubLinks(Constants.GRAPH_GRAPH_TITLE);	
			Assert.assertTrue(TestContext.getPom().getGraphPage().isTryHereBtnDisplayed());
			LoggerLoad.info("User should see Try Here btn on " + Constants.GRAPH_GRAPH_TITLE +" page");		
		}

		@Test
		public void validateTryHereBtnClickInGraphPage() {
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			TestContext.getPom().getGraphPage().clickGraphSubLinks(Constants.GRAPH_GRAPH_TITLE);	
			TestContext.getPom().getGraphPage().clickTryHereBtn();
			actualResult = 	TestContext.getDriver().getTitle();
			Assert.assertEquals(actualResult, Constants.TRY_HERE_BTN_TITLE);
			LoggerLoad.info("Expected title is " + Constants.TRY_HERE_BTN_TITLE + ". Actual Title is " + actualResult);		
		}

		@Test
		public void isTryHereBtnDisplayedInGraphRepPage() {
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			TestContext.getPom().getGraphPage().clickGraphSubLinks(Constants.GRAPH_GRAPH_REP_TITLE);	
			Assert.assertTrue(TestContext.getPom().getGraphPage().isTryHereBtnDisplayed());
			LoggerLoad.info("User should see Try Here btn on " + Constants.GRAPH_GRAPH_REP_TITLE +" page");		
		}

		@Test
		public void validateTryHereBtnClickInGraphRepPage() {
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			TestContext.getPom().getGraphPage().clickGraphSubLinks(Constants.GRAPH_GRAPH_REP_TITLE);	
			TestContext.getPom().getGraphPage().clickTryHereBtn();
			actualResult = 	TestContext.getDriver().getTitle();
			Assert.assertEquals(actualResult, Constants.TRY_HERE_BTN_TITLE);
			LoggerLoad.info("Expected title is " + Constants.TRY_HERE_BTN_TITLE + ". Actual Title is " + actualResult);		
		}
		
		@Test
		public void isRunButtonDisplayedOnGraphTryEditor(){
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			TestContext.getPom().getGraphPage().clickGraphSubLinks(Constants.GRAPH_GRAPH_REP_TITLE);	
			TestContext.getPom().getGraphPage().clickTryHereBtn();
			Assert.assertTrue(TestContext.getPom().getTryHerePages().isRunBtnDisplayed());
			LoggerLoad.info("User should see Run Button when user clicks on Try Here button from Graph Page.");		
		}
		
		@Test(dataProvider = "testDataGraphEmptyCodeEditor", dataProviderClass = ExcelDataProvider.class)
		public void validateTryEditorEmptyCodeForAllGraphSublinks(String subLinks, String validationType, String code, String expectedResults){
			LoggerLoad.info("Validating try editor appropriate alert for the validation type : " + validationType);
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			TestContext.getPom().getGraphPage().clickGraphSubLinks(subLinks);		
			TestContext.getPom().getGraphPage().clickTryHereBtn();
			cm.writeCode(code);
			TestContext.getPom().getTryHerePages().clickRunTryHere();
			Assert.assertNotNull(cm.getAlertText(driver), "Expected an alert, but no alert was displayed.");
			Assert.assertTrue(cm.getAlertText(driver).contains(expectedResults), "Expected to contain: " + expectedResults + " but got: " + cm.getAlertText(driver));
			LoggerLoad.info("User should see an appropriate alert message.");		
		}
		
		@Test(dataProvider = "testDataGraphInvalidCodeRunEditor", dataProviderClass = ExcelDataProvider.class)
		public void validateTryEditorInvalidCodeRunForAllGraphSublinks(String subLinks, String validationType, String code, String expectedResults) {
			LoggerLoad.info("Validating try editor appropriate alert for for the validation type : " + validationType);
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			TestContext.getPom().getGraphPage().clickGraphSubLinks(subLinks);		
			TestContext.getPom().getGraphPage().clickTryHereBtn();
			cm.writeCode(code);
			TestContext.getPom().getTryHerePages().clickRunTryHere();	
			Assert.assertTrue(cm.getAlertText(driver).contains(expectedResults), "Expected to contain: " + expectedResults + " but got: " + cm.getAlertText(driver));
			LoggerLoad.info("User should see an appropriate alert message.");		
		}
		
		@Test(dataProvider = "testDataGraphValidCodeRunEditor", dataProviderClass = ExcelDataProvider.class)
		public void validateTryEditorValidCodeRunForAllGraphSublinks(String subLinks, String validationType, String code, String expectedResults) {
			LoggerLoad.info("Validating try editor for the validation type : " + validationType);
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			TestContext.getPom().getGraphPage().clickGraphSubLinks(subLinks);		
			TestContext.getPom().getGraphPage().clickTryHereBtn();
			cm.writeCode(code);
			TestContext.getPom().getTryHerePages().clickRunTryHere();	
			Assert.assertTrue(TestContext.getPom().getTryHerePages().isOutputSuccess());
			LoggerLoad.info("Output should be displayed and true. but got: " + TestContext.getPom().getTryHerePages().isOutputSuccess());		
		}
		
		
		@Test
		public void isPraticeQnsLinkDisplayedForGraph() {
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			TestContext.getPom().getGraphPage().clickGraphSubLinks(Constants.GRAPH_GRAPH_REP_TITLE);		
			Assert.assertTrue(TestContext.getPom().getGraphPage().isPracticeQnsLinkDisplayed());
			LoggerLoad.info("User should see pratice Qns link in Graph Page.");		
		}		
		
		@Test
		public void validatePraticeQnsLinkClickForGraph() {
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			TestContext.getPom().getGraphPage().clickGraphSubLinks(Constants.GRAPH_GRAPH_REP_TITLE);
			TestContext.getPom().getGraphPage().clickPracticeQnsLink();
			actualResult = TestContext.getDriver().getTitle();
			Assert.assertEquals(actualResult, Constants.PRACTICE_QNS_LINK_TITLE);
			LoggerLoad.info("Expected title is " + Constants.PRACTICE_QNS_LINK_TITLE + ". Actual Title is " + actualResult);		
		}
		
		@Test
		public void isPracticeQnsDisplayedForGraph() {
			TestContext.getPom().getHomePage().graphGetStartBtnClick();
			TestContext.getPom().getGraphPage().clickGraphSubLinks(Constants.GRAPH_GRAPH_REP_TITLE);
			TestContext.getPom().getGraphPage().clickPracticeQnsLink();
			boolean actualResult = TestContext.getPom().getGraphPage().isPracticeQnDisplayed(Constants.PRAC_QN_NUM1);
			Assert.assertTrue(actualResult, 
			        "Expected at least one practice question to be displayed, but none found.");
			LoggerLoad.info("Expected-true. Atleast one pratice question is displayed for Graph Page. Actual: " + actualResult );		
		}
}
