package com.qaprosoft.carina.demo.gui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.YahooNewsItem;

public class YahooHomePage extends AbstractPage {

	@FindBy(xpath = "//div/ul/li/div/div/h3/a")
	private List<YahooNewsItem> trendingNewsLinks;

	public YahooHomePage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
	}

	public YahooNewsPage selectNews(String newsName) {
		for (YahooNewsItem news : trendingNewsLinks) {
			if (news.readNewsTitle().equalsIgnoreCase(newsName)) {
				return news.openYahooNewsPage();
			}
		}
		throw new RuntimeException("Unable to open model: " + newsName);
	}
}
