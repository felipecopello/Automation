package com.qaprosoft.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.yahoo.YahooHomePage;
import com.qaprosoft.carina.demo.gui.pages.yahoo.YahooWeatherPage;

public class YahooTest implements IAbstractTest {
//
//	@Test()
//	public void testMainNews() {
//		YahooHomePage homePage = new YahooHomePage(getDriver());
//		homePage.open();
//		homePage.acceptCookies();
//		Assert.assertTrue(homePage.isElementNotPresent(homePage.getAcceptCookiesButton()));
//
//		homePage.getYahooHomeAdd().closeAdIfPresent();
//
//		YahooNewsPage yahooNewsPage = homePage.openMainNews();
//		Assert.assertTrue(yahooNewsPage.isPageOpened());
//		String newsTitle = yahooNewsPage.getNewsTitle();
//		Assert.assertTrue(newsTitle.matches(".*"));
//	}
//
//	@Test(dataProvider = "DataProvider")
//	@TestRailCases(testCasesId = "1")
//	@XlsDataSourceParameters(path = "xls/yahooData.xlsx", sheet = "Sheet1", dsUid = "TUID", dsArgs = "a", testRailColumn = "a")
//	public void testTopNews(String a) {
//		int newsNumber = Integer.valueOf(a);
//		YahooHomePage homePage = new YahooHomePage(getDriver());
//		homePage.open();
//		homePage.acceptCookies();
//		Assert.assertTrue(homePage.isElementNotPresent(homePage.getAcceptCookiesButton()));
//
//		YahooSearchPage searchPage = homePage.openTrendingNews(newsNumber);
//		searchPage.isPageOpened();
//		searchPage.getSearchInput().assertElementPresent();
//	}
//
//	@Test()
//	public void testMailLogin() {
//		YahooHomePage homePage = new YahooHomePage(getDriver());
//		homePage.open();
//		homePage.acceptCookies();
//		Assert.assertTrue(homePage.isElementNotPresent(homePage.getAcceptCookiesButton()));
//
//		YahooLoginPage mlp = homePage.openLoginPage();
//		mlp.isPageOpened();
//
//		YahooNotARobotLoginPage notARobotPage = mlp.openNotARobotLoginPage(StringGenerator.generateEmail());
//		notARobotPage.isPageOpened();
//	}

	@Test()
	public void testWeatherPage() {
		YahooHomePage homePage = new YahooHomePage(getDriver());
		homePage.open();
		homePage.acceptCookies();
		Assert.assertTrue(homePage.isElementNotPresent(homePage.getAcceptCookiesButton()));

		YahooWeatherPage yahooWeatherPage = homePage.openYahooWeatherPage();
		yahooWeatherPage.isPageOpened();

		yahooWeatherPage.getLocationPickerButton().click();
		yahooWeatherPage.getLocationPickerInput().type("Buenos Aires");
		yahooWeatherPage.getLocationPickerOptionDiv().click();

	}

}
