package com.selenium.amazon.pages;

import com.selenium.infrastructure.basepages.MobileBasePage;
import com.selenium.infrastructure.utils.AndroidHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class HomePage extends MobileBasePage {

    private static final By MENU = By.xpath("//*[@text='Show Navigation Menu']");
    private static final By SHOPBYCATEGORY = By.xpath("//*[@text='Shop by Category']");
    private static Logger LOGGER = Logger.getLogger(HomePage.class);

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Method to click on Menu
     */
    public void clickOnMenu(){
        driver.findElement(MENU).click();
    }

    /**
     * Method to click on shop by category
     */
    public void clickOnShopByCategory(){
        AndroidHelper.waitForElementToBeClickable(driver,SHOPBYCATEGORY,30);
        driver.findElement(SHOPBYCATEGORY).click();
    }

    /**
     *
     * wait for page load
     * @return
     */
    public boolean waitForPageLoad() {

        try
        {
            AndroidHelper.waitForElementToBePresent(driver,MENU,30);
        }catch(Exception e)
        {
            return false;
        }

        return true;
    }
}
