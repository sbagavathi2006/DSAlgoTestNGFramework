package pagefactory;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonMethods;
import utilities.ExcelReaderFillo;

public class LoginPage {
	private WebDriver driver;
	
	@FindBy(id = "id_username") 
	private WebElement userNameSignIn;
	@FindBy(id = "id_password") 
	private WebElement pwdSignIn;
	@FindBy(xpath = "//input[@value='Login']") 
	private WebElement loginBtnClick;
	@FindBy(xpath = "//div[contains(text(), 'Invalid Username and Password')]") 
	private WebElement loginErrMsg;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver; 	// Reuses the driver created in Hooks
        PageFactory.initElements(driver, this); 	//initialize all the WebElements that are annotated with @FindBy
	}
	
	public boolean isLoginPageLoaded() {
		String currentURL = driver.getCurrentUrl();
		if(currentURL.contains("login")) {
			return true;
		}else return false;
	}
	
	public void enterUserName(String userName) {
		userNameSignIn.clear();
		userNameSignIn.sendKeys(userName);
	}
	
	public void enterPwd(String password) {
		pwdSignIn.clear();
		pwdSignIn.sendKeys(password);
	}
	
	public void loginBtnClick() {
		loginBtnClick.click();
	}
	
	public boolean isErrMsgDisplayed() {
		CommonMethods.waitForElementToBeVisible(driver, loginErrMsg);
		return loginErrMsg.isDisplayed();
	}
	
	public String getErrMsg() {
		return loginErrMsg.getText();
	}
	
	public boolean isAlertForEmptyUsernameDisplayed() {
		return userNameSignIn.getDomAttribute("required") != null;
	}
	
	public String getEmptyUserNameAlertMsg() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMsg = (String) js.executeScript(
	    "return arguments[0].validationMessage;", userNameSignIn);
		return 	validationMsg;
	}
	
	public boolean isAlertForEmptyPasswordDisplayed() {
		return pwdSignIn.getDomAttribute("required") != null;
	}
	
	public String getEmptyPasswordAlertMsg() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMsg = (String) js.executeScript(
	    "return arguments[0].validationMessage;", pwdSignIn);
		return 	validationMsg;
	}
	
	public void loginTODSAlgo() {
		Map<String, String> validCred = ExcelReaderFillo.getRowAsMap("login", "ValidCredential");
		userNameSignIn.clear();
		userNameSignIn.sendKeys(validCred.get("username"));
		pwdSignIn.clear();
		pwdSignIn.sendKeys(validCred.get("password"));
		loginBtnClick.click();		
	}
	

}
