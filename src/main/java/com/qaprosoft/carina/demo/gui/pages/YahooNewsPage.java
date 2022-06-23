package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class YahooNewsPage extends AbstractPage {
	@FindBy(xpath = "//header/h1")
	private ExtendedWebElement displayNewsTitle;

	public YahooNewsPage(WebDriver driver) {
		super(driver);
	}

	public String readDisplayNewsTitle() {
		assertElementPresent(displayNewsTitle);
		return displayNewsTitle.getText();
	}

}
