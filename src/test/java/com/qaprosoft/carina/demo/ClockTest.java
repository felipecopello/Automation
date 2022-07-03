package com.qaprosoft.carina.demo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.task.AppsPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.task.ClockPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.task.WelcomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;

public class ClockTest implements IAbstractTest, IMobileUtils {

	@Test()
	@MethodOwner(owner = "qpsdemo")
	@TestLabel(name = "feature", value = { "mobile", "regression" })
	public void testClockStopwatch() {
		SoftAssert softAssert = new SoftAssert();

		WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
		softAssert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");

		ClockPage clockPage = welcomePage.openClockPage();
		softAssert.assertTrue(clockPage.isPageOpened(), "Welcome page isn't opened");

		softAssert.assertTrue(clockPage.validateStopWatch());
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	@TestLabel(name = "feature", value = { "mobile", "regression" })
	public void testClockAlarm() {
		SoftAssert softAssert = new SoftAssert();

		WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
		softAssert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");

		AppsPage appsPage = welcomePage.openAppsPage();
		softAssert.assertTrue(appsPage.isPageOpened(), "Apps page isn't opened");

		ClockPage clockPage = appsPage.openClockPage();
		softAssert.assertTrue(clockPage.isPageOpened(), "Apps page isn't opened");

		clockPage.activateAlarm();
	}
}
