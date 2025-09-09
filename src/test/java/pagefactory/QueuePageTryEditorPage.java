package pagefactory;

import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonMethods;

public class QueuePageTryEditorPage {
	private WebDriver driver;
	@FindBy(css = ".CodeMirror.cm-s-default")
	private WebElement codeMirror;
	@FindBy(xpath ="//button")
	private WebElement btnRun;
	@FindBy(linkText = "Try here>>>") 
	private WebElement btnTryHere;
	@FindBy(id = "output")
	private WebElement output;	
	@FindBy (xpath = "//a[text()='Practice Questions']")
	private WebElement practiceQnsLink;
	
	public QueuePageTryEditorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	

}
