package com.qaprosoft.carina.demo.gui.pages.yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class YahooNotARobotLoginPage extends AbstractPage {
	@FindBy(css = "span.column > a > img")
	private ExtendedWebElement yahooLogo;

	public YahooNotARobotLoginPage(WebDriver driver) {
		super(driver);
		setUiLoadedMarker(yahooLogo);
		setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
	}

	public ExtendedWebElement getNotARobotH1() {
		return yahooLogo;
	}

	public void setNotARobotH1(ExtendedWebElement notARobotH1) {
		this.yahooLogo = notARobotH1;
	}
}
