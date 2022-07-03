package com.qaprosoft.carina.demo.mobile.gui.pages.common.task;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.task.AppsPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.task.ClockPage;

public abstract class WelcomePageBase extends AbstractPage {

	public WelcomePageBase(WebDriver driver) {
		super(driver);
	}

	public abstract AppsPage openAppsPage();

	public abstract ClockPage openClockPage();

}
