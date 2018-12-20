package com.selenium.amazon.flows;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.amazon.pages.HomePage;
import com.selenium.amazon.pages.ShopByCategoryPage;
import com.selenium.infrastructure.ExtentReports.ExtentManager;
import com.selenium.infrastructure.ExtentReports.ExtentTestManager;
import com.selenium.infrastructure.datahandler.DataReader;
import com.selenium.infrastructure.datahandler.DataRecord;
import com.selenium.infrastructure.datahandler.ExcelReader;
import com.selenium.infrastructure.utils.AndroidHelper;
import io.appium.java_client.android.AndroidDriver;

public class KindleFlow {

    private AndroidDriver driver;
    private DataRecord dataRecord;

    private String value1=null;
    private String value2=null;

    public KindleFlow(AndroidDriver driver, DataRecord dataRecord)
    {
        this.driver = driver;
        this.dataRecord = dataRecord;
    }

    /**
     * Method to verify whether Kindle E book link is present
     * @return
     */
    public boolean verifyKindleEBookLink()
    {
        getData();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickOnMenu();
            homePage.clickOnShopByCategory();
            ExtentTestManager.getTest().log(LogStatus.PASS,"Home Page Actions");

            ShopByCategoryPage shopByCategoryPage = new ShopByCategoryPage(driver);
            shopByCategoryPage.clickOnKindleEReadersLink();
            ExtentTestManager.getTest().log(LogStatus.PASS,"Shop Category Page Actions");

            return shopByCategoryPage.isKindleEBookDisplayed();
        }catch(Exception e)
        {
            AndroidHelper.takeScreenshot(driver);
            ExtentTestManager.getTest().log(LogStatus.FAIL,"Kindle Flow");
            return false;
        }

    }

    public void getData()
    {
        value1=dataRecord.get("data1");
    }


}
