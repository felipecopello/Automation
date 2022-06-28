package com.qaprosoft.carina.demo.gui.components.yahoo;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class YahooHomeAdd extends AbstractUIObject {

	@FindBy(id = "label#cbb>svg>path:last-child")
	private ExtendedWebElement closeAddButton;

	public YahooHomeAdd(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

	public YahooHomeAdd(WebDriver driver) {
		super(driver);
	}

	public void closeAdIfPresent() {
		closeAddButton.clickIfPresent();
	}

}
