package base;

import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import driver.DriverFactory;
import driver.DriverManager;
import driver.NoDriverException;

@Listeners(listeners.listeners.class)
public class BaseTestCase {

	DriverManager driverManager;
	public WebDriver driver;
	DriverFactory df = new DriverFactory();
	private String browserName = System.getProperty("browser");

	@BeforeMethod
	public void beforeMethod(Method method) throws NoDriverException {
		driverManager = df.getManager(browserName);
		driverManager.setMethodName(method.getName());
		driver = driverManager.getDriver();
	}

	@AfterMethod
	public void afterTest(ITestResult result) {
//		sauceTestStatus(result);
		driverManager.quitDriver();
	}

	public void sauceTestStatus(ITestResult result) {
		if (browserName.equals("ChromeSauce")) {
			((JavascriptExecutor) driver)
					.executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
		}
	}
}
