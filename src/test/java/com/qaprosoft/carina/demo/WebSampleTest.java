/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.pages.YahooHomePage;
import com.qaprosoft.carina.demo.gui.pages.YahooNewsPage;
import com.zebrunner.agent.core.annotation.TestLabel;

/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */
public class WebSampleTest implements IAbstractTest {

	@Test()
	@MethodOwner(owner = "qpsdemo")
	@TestPriority(Priority.P3)
	@TestLabel(name = "feature", value = { "web", "regression" })
	public void testYahooNavBar() {
		YahooHomePage homePage = new YahooHomePage(getDriver());
		homePage.open();
		homePage.acceptCookies();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
		try {
			homePage.selectHeaderLink("finanzas");
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			homePage.selectHeaderLink("finanzas");
		}

	}

//	@Test()
//	@MethodOwner(owner = "qpsdemo")
//	@TestPriority(Priority.P3)
//	@TestLabel(name = "feature", value = { "web", "regression" })
//	public void testMailButton() {
//		YahooHomePage homePage = new YahooHomePage(getDriver());
//		homePage.open();
//		homePage.acceptCookies();
//		MailLoginPage mlp = homePage.clickMailButton();
//		mlp.testNextButtonWithoutUser();
//	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	@TestPriority(Priority.P3)
	@TestLabel(name = "feature", value = { "web", "regression" })
	public void testMainNews() {
		YahooHomePage homePage = new YahooHomePage(getDriver());
		homePage.open();
		homePage.acceptCookies();
		YahooNewsPage yahooNewsPage = homePage.openMainNews();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(yahooNewsPage.getNewsTitle(),
				" María Castro pide normalizar la diástasis abdominal que muchas mujeres sufren tras el embarazo");
	}

}
