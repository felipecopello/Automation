package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class YahooMailLoginPage extends AbstractPage {

	@FindBy(name = "username")
	private ExtendedWebElement userNameInput;

	@FindBy(name = "signin")
	private ExtendedWebElement nextButton;

	public YahooMailLoginPage(WebDriver driver) {
		super(driver);
	}

	public void testNextButtonWithoutUser() {
		nextButton.click();
	}

}
