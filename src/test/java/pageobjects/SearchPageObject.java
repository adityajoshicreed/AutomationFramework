package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePageObject;
import io.qameta.allure.Step;


public class SearchPageObject extends BasePageObject {

	@FindBy(xpath = "//input[@name='q']")
	private WebElement searchBox;

	public SearchPageObject(WebDriver driver) {
		super(driver);
	}

	@Step("Enter {searchText} in search field")
	public SearchPageObject enterKeywods(final String searchText) {
		enterText(searchBox, searchText, "Entering text in searchBox");
		return this;
	}
	
	@Step("Send enter key")
	public SearchPageObject sendEnterKey() {
		sendKey(searchBox, Keys.ENTER, "Pressed Enter Key");
		return this;
	}
	
	@Step("Return current title of page")
	public String returnCurrentTitle() {
		return driver.getTitle();
	}

}
