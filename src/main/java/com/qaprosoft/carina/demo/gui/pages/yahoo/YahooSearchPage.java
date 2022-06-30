package com.qaprosoft.carina.demo.gui.pages.yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class YahooSearchPage extends AbstractPage {

	@FindBy(id = "sbq-clear")
	private ExtendedWebElement eraseSearchButton;

	@FindBy(css = "div>div.compList >ul>li:nth-child(3).fl-l>a")
	private ExtendedWebElement videosSearchResultLink;

	public YahooSearchPage(WebDriver driver) {
		super(driver);
		setUiLoadedMarker(eraseSearchButton);
		setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
	}

	public YahooVideoSearchPage openYahooVideoSearchPage() {
		videosSearchResultLink.click();
		return new YahooVideoSearchPage(driver);
	}

	public void assertEraseSearchButtonIsPresent() {
		eraseSearchButton.assertElementPresent();
	}

}
