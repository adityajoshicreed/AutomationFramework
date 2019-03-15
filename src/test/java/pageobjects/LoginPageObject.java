package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePageObject;
import io.qameta.allure.Step;

public class LoginPageObject extends BasePageObject{

	@FindBy(id="login-username")
	private WebElement username;
	
	public LoginPageObject(WebDriver driver) {
		super(driver);
	}

	@Step("Entering username")
	public LoginPageObject enterUsername(String username1) {	
		enterText(username, username1, "Entering text in usernamebox");
		return this;
	}
	
}
