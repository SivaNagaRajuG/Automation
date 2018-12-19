package com.selenium.infrastructure.basepages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;

public abstract class MobileBasePage {

    protected final AndroidDriver driver;
    private Logger LOGGER = null;

    /**
     * Constructor for WebBasePage that does the check to make sure page has been loaded
     * @param driver
     */
    public MobileBasePage(AndroidDriver driver)  {

        LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
        this.driver = driver;
        if(!waitForPageLoad())
        {
            LOGGER.error("Expected Page identifier is not loaded");
            throw new NotFoundException(Thread.currentThread().getStackTrace()[2].getClassName()+" is not loaded");

        }
    }

    /**
     * This Abstract method is how each page determines whether it has been loaded
     * It is called in the base page constructor
     * @return True if page has loaded, otherwise False
     */
    public abstract  boolean waitForPageLoad();
}
