package pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArrayPage {
	
private WebDriver driver;

	@FindBy(className = "list-group-item") 
	private List<WebElement> arrayPageLinks;	
	@FindBy(xpath = "//a[@href='arrays-in-python']") 
	private WebElement arraysInPython;
	@FindBy(xpath = "//a[@href='arrays-using-list']") 
	private WebElement arraysUsingList;
	@FindBy(xpath = "//a[@href='basic-operations-in-lists']") 
	private WebElement basicOperaInLists;
	@FindBy(xpath = "//a[@href='applications-of-array']") 
	private WebElement applnOfArray;
	@FindBy(linkText = "Try here>>>") 
	private WebElement btnTryHere;
	@FindBy (xpath = "//a[text()='Practice Questions']")
	private WebElement practiceQnsLink;
	
	public ArrayPage (WebDriver driver) {
		this.driver = driver; 
        PageFactory.initElements(driver, this); 
	}
	
	public int numLinksInArrayPage() {
		return arrayPageLinks.size();
	}
	
	public boolean isArraySubLinkDisplayed(String linkText) {
	    for (WebElement e : arrayPageLinks) {
	        if (e.getText().trim().equalsIgnoreCase(linkText)) {
	            return e.isDisplayed();
	        }
	    }
	    throw new RuntimeException("SubLink not found: " + linkText);
	}
		
	public TryEditorPage clickSubLinks(String linkText) {
		for(WebElement e: arrayPageLinks) {
			if(e.getText().trim().equalsIgnoreCase(linkText)) {
				e.click();
				return new TryEditorPage(driver);
			}
		}
		throw new RuntimeException("Link not found: " + linkText);
	}	
	
	public boolean isTryHereBtnDisplayed() {
		return btnTryHere.isDisplayed();
	}
	
	public void clickTryHereBtn() {
		btnTryHere.click();
	}
	
	public boolean isPraticeQnsLinkDisplayed() {
		return practiceQnsLink.isDisplayed();
	}
	
	public void clickPracticeQnsLink() {
		practiceQnsLink.click();
	}
}