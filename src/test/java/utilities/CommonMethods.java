package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class CommonMethods {
	
    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private static final int DEFAULT_TIMEOUT = 5;

    // Constructor
    public CommonMethods(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

	  // Wait for element visibility to avoid StaleElementReferenceException explicit wait
    
    public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getAlertText(WebDriver driver) {
    	try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertMsg = driver.switchTo().alert().getText();  
        
        return alertMsg;
    	} catch (Exception e) {
            System.out.println("No alert found within timeout: "+ DEFAULT_TIMEOUT  + " seconds");
            return null;
        }
    	
    }
    	
    public String strUser(String str) {
    	// Capitalize first letter
    	String str1 = str.substring(0, 1).toUpperCase() + str.substring(1);    	
    	return str1;
    }
    
    public void writeCode(String code) {	    
		//get HTML element document.querySelector('.CodeMirror') & reference to the actual CodeMirror editor instance. Stores code-mirror editor instance to editor variable.
			
		js.executeScript(
		"let editor = document.querySelector('.CodeMirror').CodeMirror;" +
		"editor.setValue(arguments[0]);", code);	//passing code as a parameter rather than hardcoding it inside the JS string.editor.setValue(code);	
	}
    
    public String getCurrentURL(WebDriver driver) {
    	return driver.getCurrentUrl();
    }
      
}
