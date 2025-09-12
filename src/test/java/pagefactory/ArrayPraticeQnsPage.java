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
	private CommonMethods cm;

	
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
		this.cm = new CommonMethods(driver);
	}
	
	public int numOfPraticeQns() {
		return practiceQns.size();
	}
	
	public boolean isPracticeQnDisplayed(int qnNumber) {
	    WebElement questionLink = driver.findElement(By.xpath("//a[@href='/question/" + qnNumber + "']"));
	    return questionLink.isDisplayed();
	}
	
	public void clickPracticeQnByNumber(int qnNumber) {
	    WebElement questionLink = driver.findElement(By.xpath("//a[@href='/question/" + qnNumber + "']"));
	    questionLink.click();
	}
		
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
		cm.waitForElementToBeVisible(driver, outputSubmit);
		return outputSubmit.getText();
	}
}
