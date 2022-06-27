package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class MailLoginPage extends AbstractPage {

	@FindBy(name = "username")
	private ExtendedWebElement userNameInput;

	@FindBy(name = "signin")
	private ExtendedWebElement nextButton;

	public MailLoginPage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
	}

	public void testNextButtonWithoutUser() {
		nextButton.click();
	}

}
