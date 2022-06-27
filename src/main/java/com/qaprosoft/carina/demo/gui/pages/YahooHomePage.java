package com.qaprosoft.carina.demo.gui.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class YahooHomePage extends AbstractPage {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@FindBy(name = "agree")
	private ExtendedWebElement acceptCookiesButton;

	@FindBy(css = "h2#ntk-title")
	private ExtendedWebElement mainNews;

	@FindBy(css = "a#ybarMailLink")
	private ExtendedWebElement mailButton;

	@FindBy(xpath = "//div[@id='ybar-navigation']/div/ul/li/a")
	private List<ExtendedWebElement> navBarLinks;

	public YahooHomePage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
	}

	public void acceptCookies() {
		acceptCookiesButton.click();
	}

	public YahooMailLoginPage clickMailButton() {
		mailButton.click();
		return new YahooMailLoginPage(driver);
	}

	public void selectHeaderLink(String option) {
		LOGGER.info("selecting '" + option);

		navBarLinks.forEach((link) -> {
			if (link.getText().equalsIgnoreCase(option)) {
				link.click();
			}
		});
	}

	public YahooNewsPage openMainNews() {
		mainNews.click();
		return new YahooNewsPage(driver);
	}
}
