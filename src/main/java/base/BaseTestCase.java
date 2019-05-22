package base;

import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import driver.EventListener;
import driver.GenerateDriver;
import driver.MissingValidMavenArgument;
import utils.ExcelUtil;
import utils.ReportUtil;

@Listeners(listeners.Listeners.class)
public class BaseTestCase {

	public WebDriver driver;
	GenerateDriver gd = new GenerateDriver();
	private String browserName = System.getProperty("browser");
	public EventFiringWebDriver eDriver;
	public EventListener handle;
	protected ExcelUtil ex;
	protected ReportUtil report;

	@BeforeClass
	public void earlyStartup(){
		report = new ReportUtil();
		report.startReport();
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) throws MissingValidMavenArgument {
		ex = new ExcelUtil();
		driver = gd.getDriver(browserName,method.getName());
		eDriver=new EventFiringWebDriver(driver);
		handle = new EventListener();
		eDriver.register(handle);
		report.createTest(method.getName());
	}

	@AfterMethod
	public void afterTest(ITestResult result) {
        report.closeTest(result,driver);
		sauceTestStatus(result);
		eDriver.unregister(handle);
		gd.driverQuit();
	}

	@AfterClass
	public void lateTearDown(){
		report.endReport();
	}

	public void sauceTestStatus(ITestResult result) {
		if (browserName.equals("ChromeSauce")) {
			((JavascriptExecutor) driver)
					.executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
		}
	}
}
