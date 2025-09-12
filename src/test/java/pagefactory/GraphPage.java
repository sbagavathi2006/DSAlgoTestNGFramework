package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GraphPage {
	private WebDriver driver;
	
	@FindBy(className = "list-group-item") 
	private List<WebElement> graphPageLinks;
	@FindBy(linkText = "Try here>>>") 
	private WebElement btnTryHere;	
	@FindBy (xpath = "//a[text()='Practice Questions']")
	private WebElement practiceQnsLink;
	
	public GraphPage (WebDriver driver) {
		this.driver = driver; 
        PageFactory.initElements(driver, this); 
	}
	
	public int numLinksInGraphPage() {
		return graphPageLinks.size();
	}
	
	public boolean isGraphSubLinksDisplayed(String linkText) {
	    for (WebElement e : graphPageLinks) {
	        if (e.getText().trim().equalsIgnoreCase(linkText)) {
	            return e.isDisplayed();
	        }
	    }
	    throw new RuntimeException("SubLink not found: " + linkText);
	}
	
	public TryEditorPage clickGraphSubLinks(String linkText) {
		for(WebElement e: graphPageLinks) {
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
	
	public void clickPracticeQnsLink() {
		practiceQnsLink.click();
	}
	
	public boolean isPracticeQnsLinkDisplayed() {
		return practiceQnsLink.isDisplayed();
	}	

	public boolean isPracticeQnDisplayed(int qnNumber) {
	    List<WebElement> questionLinks = driver.findElements(By.xpath("//a[@href='/question/" + qnNumber + "']"));
	    if (questionLinks.isEmpty()) {
	        return false;
	    }
	    return questionLinks.get(0).isDisplayed();	
	}

}