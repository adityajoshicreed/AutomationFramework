/**
 * 
 */
package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import constants.Constants;
import driver.MissingValidMavenArgument;
import utils.MailUtil;

/**
 * @author Aditya
 * 
 *         <p>
 *         Custom Listeners with logging
 *         </p>
 */
public class Listeners implements ITestListener {

	public final Logger LOGGER = LogManager.getLogger("Log");
	MailUtil mail = new MailUtil();
	private MissingValidMavenArgument nde = new MissingValidMavenArgument("Missing/Wrong value of argument -Dmail. Set it to Y or N");

	@Override
	public void onTestStart(ITestResult result) {
		LOGGER.info("Started the || " + result.getName() + " ||");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LOGGER.info("Test Passed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		LOGGER.info("Test Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LOGGER.info("Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		LOGGER.info("Started the test on browser " + Constants.browserName);
	}

	@Override
	public void onFinish(ITestContext context) {
		LOGGER.info("Stopping the execution");
		if (Constants.mailStatus.equals("Y")) {
			int passedTestCases = context.getPassedTests().size();
			int failedTestCases = context.getFailedTests().size();
			String message = "Total Passed test case: " + passedTestCases + "\n Test Case Failed: " + failedTestCases;
			mail.sendMail(message);
		}
		else if(Constants.mailStatus.equals("N")) {
			
		}
		else {
			try {
				throw nde;
			} catch (MissingValidMavenArgument e) {
				e.printStackTrace();
			}
		}
	}

}
