package com.qaprosoft.carina.demo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

		YahooSearchPage searchPage = homePage.openTrendingNews(newsNumber);
		searchPage.assertPageOpened();
		searchPage.assertEraseSearchButtonIsPresent();
	}

	@Test()
	public void testWeatherPage() {
		SoftAssert sofAssert = new SoftAssert();
		YahooHomePage homePage = new YahooHomePage(getDriver());
		homePage.open();

		homePage.acceptCookies();

		YahooWeatherPage yahooWeatherPage = homePage.openYahooWeatherPage();
		yahooWeatherPage.assertPageOpened();

		sofAssert.assertTrue(yahooWeatherPage.checkLocationH1(), "Location h1 does not match the entered location");
	}

	@Test()
	public void testMainNews() {
		SoftAssert sofAssert = new SoftAssert();
		YahooHomePage homePage = new YahooHomePage(getDriver());
		homePage.open();

		homePage.acceptCookies();

		homePage.closeYahooHomeAdIfPresent();

		YahooNewsPage yahooNewsPage = homePage.openMainNews();

		yahooNewsPage.assertPageOpened();

		sofAssert.assertTrue(yahooNewsPage.titleMatchesRegExp(), "The title does not match the regular expression.");
	}

	@Test()
	public void testSearchPage() {
		YahooHomePage homePage = new YahooHomePage(getDriver());
		homePage.open();

		homePage.acceptCookies();

		YahooSearchPage searchPage = homePage.openSpecifiedSearchPage();
		searchPage.assertPageOpened();

		YahooVideoSearchPage videoSearchPage = searchPage.openYahooVideoSearchPage();
		videoSearchPage.assertPageOpened();

		YoutubeVideoPage ytVideoPage = videoSearchPage.playSpecifiedVideo();
		ytVideoPage.assertPageOpened();
	}

	@Test()
	public void testMailLogin() {
		YahooHomePage homePage = new YahooHomePage(getDriver());
		homePage.open();

		homePage.acceptCookies();

		YahooLoginPage mlp = homePage.openLoginPage();
		mlp.assertPageOpened();

		YahooNotARobotLoginPage notARobotPage = mlp.openNotARobotLoginPage(StringGenerator.generateEmail());
		notARobotPage.assertPageOpened();
	}

}
