package com.qaprosoft.carina.demo.gui.pages.yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class YoutubeVideoPage extends AbstractPage {

	@FindBy(id = "top-bar")
	private ExtendedWebElement cookiesTopBar;

	public YoutubeVideoPage(WebDriver driver) {
		super(driver);
		setUiLoadedMarker(cookiesTopBar);
		setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
	}
}
