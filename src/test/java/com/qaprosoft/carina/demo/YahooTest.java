package com.qaprosoft.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.StringGenerator;
import com.qaprosoft.carina.demo.gui.pages.yahoo.YahooHomePage;
import com.qaprosoft.carina.demo.gui.pages.yahoo.YahooLoginPage;
import com.qaprosoft.carina.demo.gui.pages.yahoo.YahooNewsPage;
import com.qaprosoft.carina.demo.gui.pages.yahoo.YahooNotARobotLoginPage;
import com.qaprosoft.carina.demo.gui.pages.yahoo.YahooSearchPage;
import com.qaprosoft.carina.demo.gui.pages.yahoo.YahooVideoSearchPage;
import com.qaprosoft.carina.demo.gui.pages.yahoo.YahooWeatherPage;
import com.qaprosoft.carina.demo.gui.pages.yahoo.YoutubeVideoPage;

public class YahooTest implements IAbstractTest {

	@Test(dataProvider = "DataProvider")
	@TestRailCases(testCasesId = "1")
	@XlsDataSourceParameters(path = "xls/yahooData.xlsx", sheet = "Sheet1", dsUid = "TUID", dsArgs = "a", testRailColumn = "a")
	public void testTopNews(String a) {
		int newsNumber = Integer.valueOf(a);
		YahooHomePage homePage = new YahooHomePage(getDriver());
		homePage.open();

		homePage.acceptCookies();
		Assert.assertTrue(homePage.isElementNotPresent(homePage.getAcceptCookiesButton()),
				"The element is not present");
		Assert.assertTrue(homePage.isPageOpened(), "The page is not opened");

		YahooSearchPage searchPage = homePage.openTrendingNews(newsNumber);
		searchPage.assertPageOpened();
		searchPage.getEraseSearchButton().assertElementPresent();
	}

	@Test()
	public void testWeatherPage() {
		YahooHomePage homePage = new YahooHomePage(getDriver());
		homePage.open();

		homePage.acceptCookies();
		Assert.assertTrue(homePage.isElementNotPresent(homePage.getAcceptCookiesButton()),
				"The element is not present");
		Assert.assertTrue(homePage.isPageOpened(), "The page is not opened");

		YahooWeatherPage yahooWeatherPage = homePage.openYahooWeatherPage();
		yahooWeatherPage.assertPageOpened();

		yahooWeatherPage.lookForWeatherInACity();

		Assert.assertTrue(yahooWeatherPage.checkLocationH1());
	}

	@Test()
	public void testMainNews() {
		YahooHomePage homePage = new YahooHomePage(getDriver());
		homePage.open();

		homePage.acceptCookies();
		Assert.assertTrue(homePage.isElementNotPresent(homePage.getAcceptCookiesButton()),
				"The element is not present");
		Assert.assertTrue(homePage.isPageOpened(), "The page is not opened");

		homePage.getYahooHomeAdd().closeAdIfPresent();

		YahooNewsPage yahooNewsPage = homePage.openMainNews();
		Assert.assertTrue(yahooNewsPage.isPageOpened(), "The page is not opened");

		Assert.assertTrue(yahooNewsPage.titleMatchesRegExp());
	}

	@Test()
	public void testSearchPage() {
		YahooHomePage homePage = new YahooHomePage(getDriver());
		homePage.open();
		homePage.acceptCookies();
		Assert.assertTrue(homePage.isElementNotPresent(homePage.getAcceptCookiesButton()),
				"The element is not present");
		Assert.assertTrue(homePage.isPageOpened(), "The page is not opened");

		YahooSearchPage searchPage = homePage.openSpecifiedSearchPage();
		searchPage.assertPageOpened();

		YahooVideoSearchPage videoSearchPage = searchPage.openYahooVideoSearchPage();
		videoSearchPage.assertPageOpened();

		YoutubeVideoPage ytVideoPage = videoSearchPage.getSearchResultVideos().playVideo();
		ytVideoPage.assertPageOpened();
	}

	@Test()
	public void testMailLogin() {
		YahooHomePage homePage = new YahooHomePage(getDriver());
		homePage.open();

		homePage.acceptCookies();
		Assert.assertTrue(homePage.isElementNotPresent(homePage.getAcceptCookiesButton()),
				"The element is not present");
		Assert.assertTrue(homePage.isPageOpened(), "The page is not opened");

		YahooLoginPage mlp = homePage.openLoginPage();
		mlp.assertPageOpened();

		YahooNotARobotLoginPage notARobotPage = mlp.openNotARobotLoginPage(StringGenerator.generateEmail());
		notARobotPage.assertPageOpened();
	}

}
