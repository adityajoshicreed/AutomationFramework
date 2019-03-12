package driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	
	protected WebDriver driver;
	protected String methodName;
	protected abstract void startBrowser(String methodName);
	
	public void quitDriver() {
		driver.quit();
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public WebDriver getDriver() {
		startBrowser(methodName);
		return driver;
	}
	
}
