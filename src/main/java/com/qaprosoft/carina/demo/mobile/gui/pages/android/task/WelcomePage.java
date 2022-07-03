package com.qaprosoft.carina.demo.mobile.gui.pages.android.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.task.WelcomePageBase;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase implements IMobileUtils {

	@FindBy(id = "com.android.launcher3:id/page_indicator")
	private ExtendedWebElement moreAppsButton;

	@FindBy(id = "com.android.launcher3:id/workspace")
	private ExtendedWebElement container;

	@FindBy(xpath = "//android.widget.TextView[@content-desc='Clock']")
	private ExtendedWebElement clockButton;

	public WelcomePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isPageOpened() {
		return container.isElementPresent();
	}

	@Override
	public AppsPage openAppsPage() {

		swipeUp(1, 100);
		return new AppsPage(driver);
	}

	@Override
	public ClockPage openClockPage() {
		clockButton.click();
		return new ClockPage(driver);
	}

}
