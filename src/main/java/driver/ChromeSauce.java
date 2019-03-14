package driver;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import constants.Constants;

public class ChromeSauce extends DriverManager {

	public final String USERNAME = "";
	public final String ACCESS_KEY = "";
	public final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	@Override
	protected void startBrowser(String MethodName) {

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

	}

}
