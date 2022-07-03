package com.qaprosoft.carina.demo.mobile.gui.pages.android.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.task.AppsPageBase;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = AppsPageBase.class)
public class AppsPage extends AppsPageBase {

	@FindBy(xpath = "//android.widget.TextView[@content-desc='Clock']")
	private ExtendedWebElement clockButton;

	public AppsPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public ClockPage openClockPage() {
		clockButton.click();
		return new ClockPage(driver);
	}

	@Override
	public boolean isPageOpened() {
		return clockButton.isElementPresent();
	}
}
