package driver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import constants.Constants;

public class GenerateDriver {

	public WebDriver driver;
	private MissingValidMavenArgument nde = new MissingValidMavenArgument("No Driver Manager Specified");
	public final String USERNAME = "";
	public final String ACCESS_KEY = "";
	public final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	public final String URL_GRID = "http://192.168.6.65:4444/wd/hub";
	DriverDefine driverDef = new DriverDefine();

	public WebDriver getDriver(String type, String methodName) throws MissingValidMavenArgument {
		if (type.equals("Chrome")) {
			driver = driverDef.getChrome();
		} else if (type.equals("FireFox")) {
			driver = driverDef.getFireFox();
		} else if (type.equals("ChromeSauce")) {
			driver = driverDef.getSauce(methodName);
		} else if (type.equals("Grid")) {
			driver = driverDef.getGrid();
		} else {
			throw nde;
		}
		return driver;
	}

	public void driverQuit() {
		driver.quit();
	}

}
