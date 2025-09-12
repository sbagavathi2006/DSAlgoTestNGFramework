package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TryEditorPage {
	
	private WebDriver driver;
	
	@FindBy(css = ".CodeMirror.cm-s-default")
	private WebElement codeMirror;
	@FindBy(xpath ="//button")
	private WebElement btnRun;	
	@FindBy(id = "output")
	private WebElement output;
	
	public TryEditorPage (WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this); 
	}

	public boolean isRunBtnDisplayed() {
		return btnRun.isDisplayed();
	}
	public void clickRunTryHere() {
		btnRun.click();
	}
	
	public boolean isOutputSuccess() {
		return output.isDisplayed();
	}

}
