package driver;

public class DriverFactory {
	
	private NoDriverException nde = new NoDriverException("No Driver Manager Specified");

	public DriverManager getManager(String type) throws NoDriverException {

        DriverManager driverManager = null;
        if(type.equals("Chrome")) {
        	driverManager = new ChromeBrowser();
        }
        else if(type.equals("ChromeSauce")) {
        	driverManager = new ChromeSauce();
        }
        else if(type.equals("Firefox")) {
        	driverManager = new FirefoxBrowser();
        }
        else if(type.equals("Grid")) {
        	driverManager = new GridManager();
        }
        else {
        	throw nde;
        }
        return driverManager;

    }
	
}
