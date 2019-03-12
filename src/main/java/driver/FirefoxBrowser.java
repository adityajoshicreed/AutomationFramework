package driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import constants.Constants;

public class FirefoxBrowser extends DriverManager {

	@Override
	protected void startBrowser(String methodName) {
		System.setProperty("webdriver.gecko.driver", Constants.firefoxPath);
		FirefoxOptions options = new FirefoxOptions();
		options.setLegacy(true);
		driver = new FirefoxDriver(options);
		driver.get(Constants.url);
	}

}
