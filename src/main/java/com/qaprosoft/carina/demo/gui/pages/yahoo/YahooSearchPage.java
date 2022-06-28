package com.qaprosoft.carina.demo.gui.pages.yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class YahooSearchPage extends AbstractPage {

	@FindBy(id = "yschsp")
	private ExtendedWebElement searchInput;

	public YahooSearchPage(WebDriver driver) {
		super(driver);
	}

	public ExtendedWebElement getSearchInput() {
		return searchInput;
	}
}
