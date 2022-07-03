package com.qaprosoft.carina.demo.mobile.gui.pages.android.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.task.ClockPageBase;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ClockPageBase.class)
public class ClockPage extends ClockPageBase {

	@FindBy(id = "com.android.deskclock:id/fab")
	private ExtendedWebElement startStopwatchButton;

	@FindBy(id = "com.android.deskclock:id/stopwatch_time_text")
	private ExtendedWebElement stopWatchSecondsDisplay;

	@FindBy(id = "com.android.deskclock:id/left_button")
	private ExtendedWebElement resetStopwatchButton;

	@FindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc='Alarm']/android.widget.TextView")
	private ExtendedWebElement alarmButton;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='8:30 AM Alarm']/android.widget.Switch")
	private ExtendedWebElement firstAlarmItem;

	public ClockPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void startStopWatch() {
		startStopwatchButton.click();
	}

	@Override
	public boolean validateStopWatch() {
		startStopwatchButton.assertElementPresent();
		startStopwatchButton.click();
		startStopwatchButton.click();
		resetStopwatchButton.click();
		stopWatchSecondsDisplay.getText();

		return stopWatchSecondsDisplay.getText().equals(R.TESTDATA.get("cero"));
	}

	@Override
	public boolean isPageOpened() {
		return alarmButton.isElementPresent();
	}

	@Override
	public void activateAlarm() {
		alarmButton.click();
		firstAlarmItem.click();
		Assert.assertTrue(firstAlarmItem.isChecked());
	}
}
