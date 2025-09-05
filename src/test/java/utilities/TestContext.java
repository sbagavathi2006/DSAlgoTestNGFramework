package utilities;

import org.openqa.selenium.WebDriver;

import webdriver.PageObjectManager;

//Thread-safe Singleton pattern to access run time objects driver and pom globally 

public class TestContext {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<PageObjectManager> pom = new ThreadLocal<>();

	public static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
		pom.set(new PageObjectManager(driverInstance));
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static PageObjectManager getPom() {
	        return pom.get();
	}

	public static void clear() {
	        driver.remove();
	        pom.remove();
	}
}
