package com.selenium.amazon.pages;

import com.selenium.infrastructure.basepages.MobileBasePage;
import com.selenium.infrastructure.utils.AndroidHelper;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ShopByCategoryPage extends MobileBasePage {

    private static final By KINDLEEREADERSLINK=By.xpath("//*[text()='Kindle E-Readers & eBooks']");
    private static final By KINDLEEBOOK=By.xpath("//*[text()='Kindle eBooks']");
    private static Logger LOGGER = Logger.getLogger(ShopByCategoryPage.class);

    public ShopByCategoryPage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Method to click on Kindle E readers and E books link
     */
    public void clickOnKindleEReadersLink()
    {
      AndroidHelper.click(driver,KINDLEEREADERSLINK);
    }

    /**
     * method to verify whether kindle e book is displayed
     * @return true - if present else false
     */
    public boolean isKindleEBookDisplayed()
    {
        try {
            AndroidHelper.waitForElementToBePresent(driver, KINDLEEBOOK, 30);
        }catch(Exception e)
        {
            return false;
        }
        return true;
    }

    /**
     * Wait for Page Load
     * @return
     */
    public boolean waitForPageLoad() {
        try
        {
            AndroidHelper.waitForElementToBePresent(driver,KINDLEEREADERSLINK,30);
        }catch(Exception e)
        {
            return false;
        }

        return true;
    }
}
