package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonMethods;

public class ArrayPraticeQnsPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//a[@href='/question/1']") 
	private WebElement practiceQn1;	
	@FindBy(xpath = "//a[@href='/question/2']") 
	private WebElement practiceQn2;	
	@FindBy(xpath = "//a[@href='/question/3']") 
	private WebElement practiceQn3;		
	@FindBy(xpath = "//a[@href='/question/4']") 
	private WebElement practiceQn4;	
	@FindBy(className = "list-group-item") 
	private List<WebElement> practiceQns;
	@FindBy(xpath = "//button") 
	private WebElement btnRun;
	@FindBy(xpath = "//input[@class='button']") 
	private WebElement btnSubmit;
	@FindBy(css = ".CodeMirror.cm-s-default")
	private WebElement codeMirror;
	@FindBy(id = "output")
	private WebElement output;
	@FindBy(xpath = "//pre[@id='output']")
	private WebElement outputSubmit;
	
	public ArrayPraticeQnsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public int numOfPraticeQns() {
		return practiceQns.size();
	}
	
//	public boolean isPraticeQnsDisplayed(String linkText) {
//	    for (WebElement e : practiceQns) {
//	        if (e.getText().trim().equalsIgnoreCase(linkText)) {
//	            return e.isDisplayed();
//	        }
//	    }
//	    throw new RuntimeException("SubLink not found: " + linkText);
//	}
	
	public boolean isPracticeQnDisplayed(int qnNumber) {
	    WebElement questionLink = driver.findElement(By.xpath("//a[@href='/question/" + qnNumber + "']"));
	    return questionLink.isDisplayed();
	}
	
	public void clickPracticeQnByNumber(int qnNumber) {
	    WebElement questionLink = driver.findElement(By.xpath("//a[@href='/question/" + qnNumber + "']"));
	    questionLink.click();
	}
	
//	public boolean isPraticeQns1Displayed() {
//	        return practiceQn1.isDisplayed();
//	 }
//	
//	public boolean isPraticeQns2Displayed() {
//        return practiceQn2.isDisplayed();
//	}
//	
//	public boolean isPraticeQns3Displayed() {
//        return practiceQn3.isDisplayed();
//	}
//	
//	public boolean isPraticeQns4Displayed() {
//        return practiceQn4.isDisplayed();
//	}
//	
//	public void clickPraticeQns(String linkText) {
//	    for (WebElement e : practiceQns) {
//	        if (e.getText().trim().equalsIgnoreCase(linkText)) {
//	            e.click();
//	        }
//	    }
//	    throw new RuntimeException("SubLink not found: " + linkText);
//	}
//	
//	public void clickPraticeQns1() {
//        practiceQn1.click();
//	}
//
//	public void clickPraticeQns2() {
//		practiceQn2.click();
//	}
//
//	public void clickPraticeQns3() {
//		practiceQn3.click();
//	}
//
//	public void clickPraticeQns4() {
//		practiceQn4.click();
//	}
	
	public void clickPracticeQns(String linkText) {
		switch (linkText.trim().toLowerCase()) {
		case "search the array":
			practiceQn1.click();
			break;
		case "max consecutive ones":
			practiceQn2.click();
			break;
		case "find numbers with even number of digits":
			practiceQn3.click();
			break;
		case "squares of  a sorted array":
			practiceQn4.click();
			break;
		default:
			throw new IllegalArgumentException("Invalid options name: " + linkText);
		}
	}
//	
//	public boolean isBtnDisplayed(String btn) {
//		switch (btn) {
//		case "run":
//			return btnRun.isDisplayed();
//		case "submit":
//			return btnSubmit.isDisplayed();
//		}
//		return false;
//	}
	
	public void clickRunBtn() {
		btnRun.click();
	}
	
	public void btnSubmit() {
		btnSubmit.click();
	}

	public boolean isOutputSuccess() {
		return output.isDisplayed();
	}
	
	public String getSubmitMsg() {
		CommonMethods.waitForElementToBeVisible(driver, outputSubmit);
		return outputSubmit.getText();
	}
}
