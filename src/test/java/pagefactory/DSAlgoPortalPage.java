package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DSAlgoPortalPage {
	
	@FindBy(className = "btn" ) 	private WebElement getStartedBtn;
	
	public DSAlgoPortalPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void getStartedBtnClick() {
		getStartedBtn.click();
	}

}
