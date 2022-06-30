package com.qaprosoft.carina.demo.gui.pages.yahoo;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class YahooNewsPage extends AbstractPage {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@FindBy(xpath = "//header[@class='caas-title-wrapper']/h1")
	private ExtendedWebElement newsTitle;

	public YahooNewsPage(WebDriver driver) {
		super(driver);
		setUiLoadedMarker(newsTitle);
		setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
	}

	public String getNewsTitleText() {
		String newsT = newsTitle.getText();
		LOGGER.info(newsT);
		return newsT;
	}

	public boolean titleMatchesRegExp() {
		return newsTitle.getText().matches(R.TESTDATA.get("title_reg_exp"));
	}

}
