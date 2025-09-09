package pagefactory;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class QueuePage {
	
private WebDriver driver;

	@FindBy(xpath = "//a[@href='implementation-lists']")
    private WebElement ImplementationofQueueinPythonLink;
	@FindBy(xpath = "//a[@href='queue/implementation-collections']")
	private WebElement ImplementationUsingCollectionsLink;
	@FindBy(xpath = "//a[@href='queue/Implementation-array']")
	private WebElement ImplementationUsingArrayLink;
	@FindBy(xpath = "//a[@href='queue/QueueOp']")
	private WebElement QueueOperationsLink;
	@FindBy(className = "list-group-item") 
	private List<WebElement> queuePageLinks;
	@FindBy(linkText = "Try here>>>") 
	private WebElement btnTryHere;	
	@FindBy (xpath = "//a[text()='Practice Questions']")
	private WebElement practiceQnsLink;
	
	public QueuePage (WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}

	public String getGraphPageTitle() {
		return driver.getTitle();
	}
	
	public int numLinksInPage() {
		return queuePageLinks.size();
	}
	
	public boolean isSubLinksDisplayed(String linkText) {
	    for (WebElement e : queuePageLinks) {
	        if (e.getText().trim().equalsIgnoreCase(linkText)) {
	            return e.isDisplayed();
	        }
	    }
	    throw new RuntimeException("SubLink not found: " + linkText);
	}
	
	public TryEditorPage clickSubLinks(String linkText) {
		for(WebElement e: queuePageLinks) {
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
