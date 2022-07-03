package com.qaprosoft.carina.demo.mobile.gui.pages.common.task;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class ClockPageBase extends AbstractPage {

	public ClockPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract void startStopWatch();

	public abstract boolean validateStopWatch();

	public abstract void activateAlarm();
}
