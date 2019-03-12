/**
 * 
 */
package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Aditya 
 *
 *<p>
 *	   Methods of different types of waits in selenium
 *</p>
 */
public class WaitUtil{
	
	public void waitForElementToVisible(WebDriver driver, int time, WebElement element) throws InterruptedException {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
	}

}
