package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import hooks.Hooks;
import utilities.LoggerLoad;
import utilities.TestContext;

public class DSPortalTest extends Hooks{
	
	@Test
	public void getStartedBtnValidation() {
		TestContext.getPom().getDSAlgoPortalPage().getStartedBtnClick();
		String actualResult = TestContext.getDriver().getTitle();
		Assert.assertTrue(actualResult.contains("NumpyNinja"));
		LoggerLoad.info("PageTitle should be NumpyNinja, but the actual page title is : " + actualResult);	
	}

}
