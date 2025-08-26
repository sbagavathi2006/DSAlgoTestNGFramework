package webdriver;

import org.openqa.selenium.WebDriver;

import pagefactory.DSAlgoPortalPage;
import pagefactory.HomePage;

public class PageObjectManager {
	private WebDriver driver;
	
	private DSAlgoPortalPage portalPage;
	private HomePage homePage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public DSAlgoPortalPage getDSAlgoPortalPage() {			
		if(portalPage == null) {
		portalPage = new DSAlgoPortalPage(driver);}
		return portalPage;
		}
	
	public HomePage getHomePage() {		
		if(homePage == null) {
		homePage = new HomePage(driver);}
		return homePage;
	}

}
