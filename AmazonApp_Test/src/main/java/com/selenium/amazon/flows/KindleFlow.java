package com.selenium.amazon.flows;

import com.selenium.amazon.pages.HomePage;
import com.selenium.amazon.pages.ShopByCategoryPage;
import com.selenium.infrastructure.datahandler.DataReader;
import com.selenium.infrastructure.datahandler.ExcelReader;
import com.selenium.infrastructure.utils.AndroidHelper;
import io.appium.java_client.android.AndroidDriver;

public class KindleFlow {

    private AndroidDriver driver;
    private DataReader dataReader;

    private String value1=null;
    private String value2=null;

    public KindleFlow(AndroidDriver driver, DataReader dataReader)
    {
        this.driver = driver;
        this.dataReader = dataReader;
    }

    /**
     * Method to verify whether Kindle E book link is present
     * @return
     */
    public boolean verifyKindleEBookLink()
    {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickOnMenu();
            homePage.clickOnShopByCategory();

            ShopByCategoryPage shopByCategoryPage = new ShopByCategoryPage(driver);
            shopByCategoryPage.clickOnKindleEReadersLink();
            return shopByCategoryPage.isKindleEBookDisplayed();
        }catch(Exception e)
        {
            AndroidHelper.takeScreenshot(driver);
            return false;
        }

    }

    public void getData()
    {
        value1=dataReader.getData("data1");
    }


}
