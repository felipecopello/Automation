package com.qaprosoft.carina.demo.mobile.gui.pages.common.task;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class AppsPageBase extends AbstractPage {

	public AppsPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract ClockPageBase openClockPage();
}
