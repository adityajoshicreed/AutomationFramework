package base;

import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import driver.DriverFactory;
import driver.DriverManager;
import driver.EventListener;
import driver.MissingValidMavenArgument;
import utils.ExcelUtil;

@Listeners(listeners.Listeners.class)
public class BaseTestCase {

	DriverManager driverManager;
	public WebDriver driver;
	DriverFactory df = new DriverFactory();
	private String browserName = System.getProperty("browser");
	public EventFiringWebDriver eDriver;
	public EventListener handle;
	protected ExcelUtil ex = new ExcelUtil();

	@BeforeMethod
	public void beforeMethod(Method method) throws MissingValidMavenArgument {
		driverManager = df.getManager(browserName);
		driverManager.setMethodName(method.getName());
		driver = driverManager.getDriver();
		eDriver=new EventFiringWebDriver(driver);
		handle = new EventListener();
		eDriver.register(handle);
	}

	@AfterMethod
	public void afterTest(ITestResult result) {
		sauceTestStatus(result);
		driverManager.quitDriver();
	}

	public void sauceTestStatus(ITestResult result) {
		if (browserName.equals("ChromeSauce")) {
			((JavascriptExecutor) driver)
					.executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
		}
	}
}
