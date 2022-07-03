package com.qaprosoft.carina.demo.mobile.gui.pages.android.example;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.example.MapsPageBase;

import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapsPageBase.class)
public class MapsPage extends MapsPageBase {

    public MapsPage(WebDriver driver) {
        super(driver);
    }

}
