package com.qaprosoft.carina.demo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.YahooNewsPage;

public class YahooNewsItem extends AbstractUIObject {
	@FindBy(xpath = ".//div/ul/li/div/div/h3/a")
	private ExtendedWebElement newsTitle;

	@FindBy(xpath = ".//div/ul/li/div/div/h3/a")
	private ExtendedWebElement newsLink;

	public YahooNewsItem(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

	public String readNewsTitle() {
		return newsTitle.getText();
	}

	public YahooNewsPage openYahooNewsPage() {
		newsLink.click();
		return new YahooNewsPage(driver);
	}

}
