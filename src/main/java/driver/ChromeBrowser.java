package driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import constants.Constants;

public class ChromeBrowser extends DriverManager{

	@Override
	protected void startBrowser(String methodName) {
		  System.setProperty("webdriver.chrome.driver",Constants.chromePath); 
		  ChromeOptions opt = new ChromeOptions();
		  opt.addArguments("--headless");
		  opt.addArguments("--no-sandbox");
		  opt.addArguments("--disable-dev-shm-usage");
		  driver = new ChromeDriver(opt);
		  driver.get(Constants.url);
	}

}
