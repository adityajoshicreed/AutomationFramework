package base;

import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import driver.EventListener;
import driver.GenerateDriver;
import driver.MissingValidMavenArgument;
import utils.ExcelUtil;

@Listeners(listeners.Listeners.class)
public class BaseTestCase {

	public WebDriver driver;
	GenerateDriver gd = new GenerateDriver();
	private String browserName = System.getProperty("browser");
	public EventFiringWebDriver eDriver;
	public EventListener handle;
	protected ExcelUtil ex;

	@BeforeMethod
	public void beforeMethod(Method method) throws MissingValidMavenArgument {
		ex = new ExcelUtil();
		driver = gd.getDriver(browserName,method.getName());
		eDriver=new EventFiringWebDriver(driver);
		handle = new EventListener();
		eDriver.register(handle);
	}

	@AfterMethod
	public void afterTest(ITestResult result) {
		sauceTestStatus(result);
		gd.driverQuit();
	}

	public void sauceTestStatus(ITestResult result) {
		if (browserName.equals("ChromeSauce")) {
			((JavascriptExecutor) driver)
					.executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
		}
	}
}
