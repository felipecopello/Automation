package com.qaprosoft.carina.demo.gui.pages.yahoo;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.yahoo.YahooHomeAdd;
import com.qaprosoft.carina.demo.gui.components.yahoo.YahooNewsItem;

public class YahooHomePage extends AbstractPage {
	@FindBy(id = "ybar-sbq")
	private ExtendedWebElement yahooSearchInput;

	@FindBy(name = "agree")
	private ExtendedWebElement acceptCookiesButton;

	@FindBy(css = "h2#ntk-title")
	private ExtendedWebElement mainNewsH2;

	@FindBy(css = "div.weather-card-content > a")
	private ExtendedWebElement viewMoreWeatherLink;

	@FindBy(xpath = "//*[@name='crumb']/../a")
	private ExtendedWebElement loginButton;

	@FindBy(css = "div.bd>div>div>div")
	private List<YahooNewsItem> topMostLookedNewsLinks;

	public YahooHomePage(WebDriver driver) {
		super(driver);
		setPageURL("");
	}

	public ExtendedWebElement getAcceptCookiesButton() {
		return acceptCookiesButton;
	}

	public void acceptCookies() {
		YahooHomePage yahooHomePage = new YahooHomePage(driver);
		acceptCookiesButton.click();
		acceptCookiesButton.isElementNotPresent(5);
		yahooHomePage.assertPageOpened();
	}

	public YahooSearchPage openSpecifiedSearchPage() {
		yahooSearchInput.type(R.TESTDATA.get("search"));
		yahooSearchInput.sendKeys(Keys.ENTER);
		return new YahooSearchPage(driver);
	}

	public YahooLoginPage openLoginPage() {
		loginButton.click();
		return new YahooLoginPage(driver);
	}

	public YahooNewsPage openMainNews() {
		mainNewsH2.click();
		return new YahooNewsPage(driver);
	}

	public YahooSearchPage openTrendingNews(int newsRanking) {
		return topMostLookedNewsLinks.get(newsRanking).openNewsPage();
	}

//	Use double click so the weather page opens every time. Otherwise random pop up might appear and page wont open.
	public YahooWeatherPage openYahooWeatherPage() {
		viewMoreWeatherLink.doubleClick();
		return new YahooWeatherPage(driver);
	}

	public void closeYahooHomeAdIfPresent() {
		YahooHomeAdd yahooHomeAd = new YahooHomeAdd(driver);
		yahooHomeAd.closeAdIfPresent();
	}

}
