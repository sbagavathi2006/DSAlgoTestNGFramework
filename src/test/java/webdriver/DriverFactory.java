package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ThreadGuard;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
		public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>(); //each thread gets its own instance for parallel testing
		
		public WebDriver init_driver(String browserName) {
		    switch (browserName.toLowerCase()) {
		    
		 // Added driver mgr to avoid jenkins error since selenium manager kicks in and tries to auto-download drivers
		    
		        case "chrome":
		        	WebDriverManager.chromedriver().setup();  
		            tlDriver.set(ThreadGuard.protect(new ChromeDriver()));
		            break;
		        case "edge":
		        	WebDriverManager.edgedriver().setup();  
		            tlDriver.set(ThreadGuard.protect(new EdgeDriver()));
		            break;
		        default:
		            throw new IllegalArgumentException("Browser not supported: " + browserName);
		    }
		    getDriver().manage().window().maximize();
		    return getDriver();
		}
		   
		public static WebDriver getDriver() { // Returns the WebDriver instance for the current thread
			return tlDriver.get();
		}
	}
