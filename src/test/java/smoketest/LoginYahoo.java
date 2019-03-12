package smoketest;

import org.testng.annotations.Test;

import base.BaseTestCase;
import io.qameta.allure.Feature;
import pageobjects.LoginPageObject;

public class LoginYahoo extends BaseTestCase
{

	@Feature("LoginTest")
	@Test(testName="Creed",description = "enter username")
	public void login() {
		new LoginPageObject(driver).enterUsername("adi");
	}
	
}
