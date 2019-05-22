/**
 * 
 */
package base;

import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.ReportUtil;

/**
 * @author Aditya
 * 
 *         <p>
 *         Base page object class
 *         </p>
 */
public class BasePageObject {

	protected WebDriver driver;
	protected ReportUtil report;

	public final Logger LOGGER = LogManager.getLogger("Log");

	public BasePageObject(WebDriver driver,ReportUtil report) {
		this.driver = driver;
		this.report = report;
		PageFactory.initElements(driver, this);
	}

	public void click(WebElement element, String message) {
		element.click();
		LOGGER.info(message);
		report.addStep(message);
	}

	public void enterText(WebElement element, String value, String message) {
		element.sendKeys(value);
		LOGGER.info(message+" as "+value);
		report.addStep(message);
	}

	public void sendKey(WebElement element, Keys value, String message) {
		element.sendKeys(value);
		LOGGER.info(message);
		report.addStep(message);
	}
	
}
