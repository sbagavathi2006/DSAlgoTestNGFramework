package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonMethods;

public class HomePage {

	private WebDriver driver;
	private CommonMethods cm;
	
	@FindBy(xpath = "//a[text()='NumpyNinja']")
	private WebElement numpyNinjaLink;
	@FindBy(xpath = "//a[contains(text(), 'Sign in')]")
	private WebElement signInLink;
	@FindBy(xpath = "//a[contains(text(), 'Register')]") 
	private WebElement registerLink;
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	private WebElement dsDropdown;
	@FindBy (xpath = "//div[@class='dropdown-menu show']//a")
	private List<WebElement> dsDropdownOptions;
	@FindBy (xpath = "//div[contains(@class, 'card-body')]")
	private List<WebElement> cards;
	@FindBy (xpath = "//div[contains(text(),'You are not logged in')]")
	private WebElement errMsg;
	@FindBy(xpath = "//div[contains(text(), 'You are logged in')]") 
	private WebElement loginSuccessAlert;
	@FindBy(xpath = "//a[contains(text(), 'Sign out')]") 
	private WebElement signout;	
	@FindBy(xpath = "//div[contains(text(), 'Logged out successfully')]")
	private WebElement signoutSuccessMsg;
	@FindBy(xpath = "//a[@href='data-structures-introduction']") 
	private WebElement dsIntroGetStartBtn;	
	@FindBy(xpath = "//a[@href='array']") 
	private WebElement arrayGetStartBtn;	
	@FindBy(xpath = "//a[@href='linked-list']") 
	private WebElement linkedListGetStartBtn;	
	@FindBy(xpath = "//a[@href='stack']") 
	private WebElement stackGetStartBtn;	
	@FindBy(xpath = "//a[@href='queue']") 
	private WebElement queueGetStartBtn;	
	@FindBy(xpath = "//a[@href='tree']") 
	private WebElement treeGetStartBtn;	
	@FindBy(xpath = "//a[@href='graph']") 
	private WebElement graphGetStartBtn;
	
	public HomePage (WebDriver driver) {
		this.driver = driver; 	// Reuses the driver created in Hooks
        PageFactory.initElements(driver, this); 	//initialize all the WebElements that are annotated with @FindBy
        this.cm = new CommonMethods(driver);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean isNumpyNinjaLinkDisplayed() {
		return numpyNinjaLink.isDisplayed();
	}
	
	public boolean isRegisterLinkDisplayed() {
		return registerLink.isDisplayed();
	}
	
	public boolean isSignInLinkDisplayed() {
		return signInLink.isDisplayed();
	}
	
	public boolean isDropdownOptionsDisplayed() {
		return dsDropdown.isDisplayed();
		
	}
	
	public boolean isFlexDisplayed() {
		if(cards.size() >= 1) {
		return true;} else return false;		
	}
	
	public void clickNumpyNinja() {
	    numpyNinjaLink.click();
	}
	
	public void clickRegisterLink() {
        registerLink.click();		
	}

	public void clickSignInLink() {
		signInLink.click();
	}
	
	public void clickDataStructuresDropdown() {
	    dsDropdown.click();
	}
	
	public int getDsDropdownOptionsCount() {
		return dsDropdownOptions.size();
	}
	
	public void selectFromDropdown(String optionText) {
	    for (WebElement e : dsDropdownOptions) {
	        if (e.getText().trim().equalsIgnoreCase(optionText)) {
	            cm.waitForElementToBeVisible(driver, e);
	            e.click();
	            return;
	        }
	    }
	    throw new RuntimeException("Dropdown option not found: " + optionText);
	}
	
	public int getFlexCount() {
		return cards.size();
	}
	
	public void clickFlexGetStarted(String flexTitle) {
	    String xpath = "//a[@href= '"+flexTitle+"']";
	    WebElement getStartedBtn = driver.findElement(By.xpath(xpath));
        cm.waitForElementToBeVisible(driver, getStartedBtn);
	    getStartedBtn.click();
	}
	
	public boolean isErrMsgDisplayed() {
	    return errMsg.isDisplayed();
	}
  
	public String getLoginErrMsg() {
	    return errMsg.getText();
	}
    
	public boolean isLoginSuccessMsgDisplayed() {
		cm.waitForElementToBeVisible(driver, loginSuccessAlert);
		return loginSuccessAlert.isDisplayed();
	}
	
	public String getLoginSuccessMsg() {
		return loginSuccessAlert.getText();
	}
	
	public String loggedInUser(String username) {
	    WebElement loggedInUserName = driver.findElement(By.xpath("//a[contains(text(), ' " + username + " ')]")); 	//to handle dynamic user name
	    return loggedInUserName.getText().trim();
	}
	
	public boolean signoutLinkDisplayed() {
		return signout.isDisplayed();
	}
	
	public void clickSignoutLink() {
		signout.click();
	}
	
	public boolean isSignoutSuccessMsgDisplayed() {
		return signoutSuccessMsg.isDisplayed();
	}
	
	public void dsIntroGetStartBtnClick() {
		dsIntroGetStartBtn.click();
	}
	
	public void arrayGetStartBtnClick() {
		cm.waitForElementToBeVisible(driver, arrayGetStartBtn);
		arrayGetStartBtn.click();
	}
	
	public void linkedListGetStartBtnClick() {
		linkedListGetStartBtn.click();
	}
	
	public void stackGetStartBtnClick() {
		stackGetStartBtn.click();
	}
	
	public void queueGetStartBtnClick() {
		cm.waitForElementToBeVisible(driver, queueGetStartBtn);
		queueGetStartBtn.click();
	}
	
	public void treeGetStartBtnClick() {
		treeGetStartBtn.click();
	}
	
	public void graphGetStartBtnClick() {
		cm.waitForElementToBeVisible(driver, graphGetStartBtn);
		graphGetStartBtn.click();
	}
}
