package com.qaprosoft.carina.demo.gui.pages.yahoo;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class YahooWeatherPage extends AbstractPage {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@FindBy(css = "div.location-picker > button")
	private ExtendedWebElement locationPickerButton;

	@FindBy(css = "input.search-input")
	private ExtendedWebElement locationPickerInput;

	@FindBy(css = "ul.location > li:first-child > div > button")
	private ExtendedWebElement locationPickerOptionButton;

	@FindBy(css = "section.weather-card > div > div > h1")
	private ExtendedWebElement locationH1;

	public YahooWeatherPage(WebDriver driver) {
		super(driver);
		setUiLoadedMarker(locationPickerButton);
		setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
	}

	public boolean checkLocationH1() {
		locationPickerButton.click();
		enterLocationSearchWeather(R.TESTDATA.get("city"));
		locationPickerOptionButton.click();
		locationH1.assertElementWithTextPresent(R.TESTDATA.get("city"), 5);
		LOGGER.info(locationH1.getText());
		return locationH1.getText().equalsIgnoreCase(R.TESTDATA.get("city"));
	}

	public void enterLocationSearchWeather(String city) {
		locationPickerInput.type(city);
	}

}
