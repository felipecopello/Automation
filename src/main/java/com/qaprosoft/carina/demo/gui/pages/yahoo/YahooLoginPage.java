package com.qaprosoft.carina.demo.gui.pages.yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class YahooLoginPage extends AbstractPage {

	@FindBy(name = "username")
	private ExtendedWebElement userNameInput;

	@FindBy(name = "signin")
	private ExtendedWebElement nextButton;

	public YahooLoginPage(WebDriver driver) {
		super(driver);
		setUiLoadedMarker(userNameInput);
		setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
	}

	public YahooNotARobotLoginPage openNotARobotLoginPage(String username) {
		userNameInput.type(username);
		nextButton.click();

		return new YahooNotARobotLoginPage(driver);
	}

}
