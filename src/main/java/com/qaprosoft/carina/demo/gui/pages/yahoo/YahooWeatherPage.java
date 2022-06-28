package com.qaprosoft.carina.demo.gui.pages.yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class YahooWeatherPage extends AbstractPage {

	@FindBy(css = "div.location-picker > button")
	private ExtendedWebElement locationPickerButton;

	@FindBy(css = "input.search-input")
	private ExtendedWebElement locationPickerInput;

	@FindBy(css = "ul.location > li > div")
	private ExtendedWebElement locationPickerOptionDiv;

	public YahooWeatherPage(WebDriver driver) {
		super(driver);
		setUiLoadedMarker(locationPickerButton);
		setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
	}

	public ExtendedWebElement getLocationPickerButton() {
		return locationPickerButton;
	}

	public ExtendedWebElement getLocationPickerInput() {
		return locationPickerInput;
	}

	public ExtendedWebElement getLocationPickerOptionDiv() {
		return locationPickerOptionDiv;
	}

}
