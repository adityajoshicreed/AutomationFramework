package driver;

import org.openqa.selenium.chrome.ChromeDriver;

import constants.Constants;

public class ChromeBrowser extends DriverManager{

	@Override
	protected void startBrowser(String methodName) {
		  System.setProperty("webdriver.chrome.driver",Constants.chromePath); 
		  driver = new ChromeDriver();
		  driver.get(Constants.url);
	}

}
