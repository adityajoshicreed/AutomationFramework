package driver;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import constants.Constants;

public class GridManager extends DriverManager{

	public final String URL = "http://192.168.6.65:4444/wd/hub";
	
	@Override
	protected void startBrowser(String methodName) {
		ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PLATFORM, org.openqa.selenium.Platform.WINDOWS);           
        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		try {
			driver = new RemoteWebDriver(new URL(URL), options);
			driver.get(Constants.url);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
