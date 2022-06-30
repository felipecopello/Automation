package com.qaprosoft.carina.demo.gui.components.yahoo;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.yahoo.YahooSearchPage;

public class YahooNewsItem extends AbstractUIObject {

	@FindBy(xpath = ".//a/span")
	private ExtendedWebElement newsLabel;

	@FindBy(xpath = ".//a")
	private ExtendedWebElement newsLink;

	public YahooNewsItem(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

	public String readNewsLabel() {
		return newsLink.getText();
	}

	public YahooSearchPage openNewsPage() {
		newsLink.click();
		return new YahooSearchPage(driver);
	}

}
