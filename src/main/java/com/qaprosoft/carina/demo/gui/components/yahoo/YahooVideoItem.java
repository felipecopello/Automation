package com.qaprosoft.carina.demo.gui.components.yahoo;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.yahoo.YoutubeVideoPage;

public class YahooVideoItem extends AbstractUIObject {

	@FindBy(css = "a")
	private ExtendedWebElement videoLink;

	public YahooVideoItem(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

	public YoutubeVideoPage playVideo() {
		videoLink.click();
		return new YoutubeVideoPage(driver);
	}
}
