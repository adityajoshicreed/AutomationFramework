/**
 * 
 */
package constants;

/**
 * @author Aditya
 *
 *
 *<p>
 *	 Have all the constants related to all utils
 *</p>
 */
public class Constants {

		
		public final static String browserName = System.getProperty("browser");
		public final static String chromePath = getDriverPath();
		public final static String firefoxPath = "C:/AutomationDrivers/geckodriver.exe";
		public final static String url = "https://login.yahoo.com/";
		public final static int wait = 10;
		
		public final static String mailStatus = System.getProperty("mail");
		public final static String senderEmail = "";
		public final static String senderPass = "";
		public final static String recipientEmail = "";
		public final static String smtpHost = "smtp.gmail.com";
		
		public static String getDriverPath() {
			String os = System.getProperty("os.name").toLowerCase();
			String path = null;
			if(os.contains("win")) {
				path = System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
			}
			else{
				path = System.getProperty("user.dir")+"/Drivers/chromedriver";
			}
			return path;
		}

}
