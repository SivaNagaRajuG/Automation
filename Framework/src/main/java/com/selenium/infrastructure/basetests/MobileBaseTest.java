package com.selenium.infrastructure.basetests;

import com.selenium.infrastructure.utils.AutomationConfigurator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class MobileBaseTest {

    private AndroidDriver androidDriver;
    private IOSDriver iosDriver;

    private static final int DEFAULT_IMPLICIT_WAIT = 30;
    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";

    private DesiredCapabilities capabilities=null;


      /**
     * Method to get the Android Driver by taking the capabilities from properties file in project path
     * @return
     * @throws IOException
     */
    public AndroidDriver getAndroidDriver() throws IOException {

        capabilities = new AutomationConfigurator().setMobileCap();
        androidDriver = new AndroidDriver(new URL(APPIUM_SERVER_URL),capabilities);
        androidDriver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS);
        return androidDriver;

    }

    /**
     * Method to get the IOS driver
     * @return
     * @throws IOException
     */
    public IOSDriver getIOSDriver() throws IOException {
        capabilities = new AutomationConfigurator().setMobileCap();
        iosDriver = new IOSDriver(new URL(APPIUM_SERVER_URL),capabilities);
        iosDriver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS);
        return iosDriver;

    }



}
