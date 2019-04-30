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

public class DriverDefine {

	public WebDriver driver;
	public final String USERNAME = "";
	public final String ACCESS_KEY = "";
	public final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	public final String URL_GRID = "http://192.168.6.65:4444/wd/hub";
	
	public WebDriver getChrome() {
		System.setProperty("webdriver.chrome.driver", Constants.chromePath);
		ChromeOptions opt = new ChromeOptions();
//		opt.addArguments("--headless");
		opt.addArguments("--no-sandbox");
		opt.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(opt);
		driver.get(Constants.url);
		return driver;
	}
	
	public WebDriver getFireFox() {
		System.setProperty("webdriver.gecko.driver", Constants.firefoxPath);
		FirefoxOptions options = new FirefoxOptions();
		options.setLegacy(true);
		driver = new FirefoxDriver(options);
		driver.get(Constants.url);
		return driver;
	}
	
	public WebDriver getSauce(String methodName) {
		ChromeOptions caps = new ChromeOptions();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "latest");
		caps.setCapability("name", methodName);

		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
			driver.get(Constants.url);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return driver;
	}
	
	@SuppressWarnings("deprecation")
	public WebDriver getGrid() {
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM, org.openqa.selenium.Platform.WINDOWS);
		options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		try {
			driver = new RemoteWebDriver(new URL(URL_GRID), options);
			driver.get(Constants.url);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return driver;
	}
	
}
