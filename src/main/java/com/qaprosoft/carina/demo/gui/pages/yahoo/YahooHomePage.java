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

	@FindBy(xpath = "//*[@id='applet_p_50000503']/div/div/div[2]/div/div/div")
	private List<YahooNewsItem> topMostLookedNewsLinks;

	public YahooHomePage(WebDriver driver) {
		super(driver);
		setPageURL("");
	}

	public ExtendedWebElement getAcceptCookiesButton() {
		return acceptCookiesButton;
	}

	public ExtendedWebElement getViewMoreWeatherLink() {
		return viewMoreWeatherLink;
	}

	public ExtendedWebElement getYahooSearchInput() {
		return yahooSearchInput;
	}

	public ExtendedWebElement getMainNewsH2() {
		return mainNewsH2;
	}

	public ExtendedWebElement getLoginButton() {
		return loginButton;
	}

	public List<YahooNewsItem> getTopMostLookedNewsLinks() {
		return topMostLookedNewsLinks;
	}

	public void acceptCookies() {
		acceptCookiesButton.click();
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

	public YahooWeatherPage openYahooWeatherPage() {
		viewMoreWeatherLink.doubleClick();
		return new YahooWeatherPage(driver);
	}

	public YahooHomeAdd getYahooHomeAdd() {
		return new YahooHomeAdd(driver);
	}

	public void setAcceptCookiesButton(ExtendedWebElement acceptCookiesButton) {
		this.acceptCookiesButton = acceptCookiesButton;
	}

}
