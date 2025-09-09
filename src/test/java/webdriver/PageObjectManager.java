package webdriver;

import org.openqa.selenium.WebDriver;

import pagefactory.TryEditorPage;
import pagefactory.ArrayPage;
import pagefactory.ArrayPraticeQnsPage;
import pagefactory.DSAlgoPortalPage;
import pagefactory.GraphPage;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.QueuePage;

public class PageObjectManager {
	private WebDriver driver;
	private DSAlgoPortalPage portalPage;
	private HomePage homePage;
	private LoginPage loginPage;
	private ArrayPage arrayPage;
	private TryEditorPage tryHerePages;
	private ArrayPraticeQnsPage praticeQnsPages;
	private GraphPage graphPage;
	private QueuePage queuePage;
	
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
	
	public LoginPage getLoginPage() {
		if(loginPage == null) {
			loginPage = new LoginPage(driver);
		}
		return loginPage;
	}
	
	public ArrayPage getArrayPage() {
		if(arrayPage == null) {
			arrayPage = new ArrayPage(driver);
		}
		return arrayPage;
	}

	public TryEditorPage getTryHerePages() {
		if(tryHerePages == null) {
			tryHerePages = new TryEditorPage(driver);
		}
		return tryHerePages;		
	}
	
	public ArrayPraticeQnsPage getPraticeQnsPages() {
		if(praticeQnsPages == null) {
			praticeQnsPages = new ArrayPraticeQnsPage(driver);
		}
		return praticeQnsPages;		
	}
	
	public GraphPage getGraphPage() {
		if(graphPage == null) {
			graphPage = new GraphPage(driver);
		}
		return graphPage;		
	}
	
	public QueuePage getQueuePage() {
		if(queuePage == null) {
			queuePage = new QueuePage(driver);
		}
		return queuePage;		
	}
}
