package com.qaprosoft.carina.demo.gui.pages.yahoo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.yahoo.YahooVideoItem;

public class YahooVideoSearchPage extends AbstractPage {

	@FindBy(id = "search")
	private ExtendedWebElement searchSection;

	@FindBy(css = "li.vr")
	private List<YahooVideoItem> searchResultVideos;

	public YahooVideoSearchPage(WebDriver driver) {
		super(driver);
		setUiLoadedMarker(searchSection);
		setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
	}

	public YahooVideoItem getSearchResultVideos() {
		return searchResultVideos.get(Integer.valueOf(R.TESTDATA.get("video_number")));
	}
}
