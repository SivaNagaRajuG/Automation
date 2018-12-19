package com.selenium.infrastructure.utils;

import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

public class AndroidHelper {


    /**
     * Method to take the screenshots
     * @param driver
     */
    public static String takeScreenshot(AndroidDriver driver) {
        File scrFile = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/target/screenshots/screenshot.png";

        try {
            FileUtils.copyFile(scrFile, new File(destination));
            //test.log(LogStatus.INFO,"Snapshot : "+test.addScreenCapture(destination));
        } catch (IOException var5) {
            var5.printStackTrace();
        }
        return destination;
    }

    /**
     * Method to wait for element to be present
     * @param driver
     * @param locator
     * @param timeOut
     * @return
     */
    public static WebElement waitForElementToBePresent(AndroidDriver driver,By locator, int timeOut)
    {
        if(driver == null){
            throw new IllegalArgumentException("WebDriver cannot be null");
        }
        WebDriverWait wait=new WebDriverWait(driver,timeOut);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Method to wait for element to be visible
     * @param locator
     * @param timeOut
     * @return
     */
    public static WebElement waitForElementToBeVisible(AndroidDriver driver,By locator, int timeOut)
    {
        if(driver == null){
            throw new IllegalArgumentException("WebDriver cannot be null");
        }
        WebDriverWait wait=new WebDriverWait(driver,timeOut);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Method to wait for element to be clickable
     * @param driver
     * @param locator
     * @param timeOut
     * @return
     */
    public static WebElement waitForElementToBeClickable(AndroidDriver driver,By locator, int timeOut)
    {
        if(driver == null){
            throw new IllegalArgumentException("WebDriver cannot be null");
        }
        WebDriverWait wait=new WebDriverWait(driver,timeOut);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Wait for an expected condition
     * @param elementExpectedCondition
     * @return
     */
    public static WebElement waitForElement(AndroidDriver driver,final ExpectedCondition<WebElement> elementExpectedCondition, int timeOut)
    {
        if(driver == null){
            throw new IllegalArgumentException("WebDriver cannot be null");
        }
        WebDriverWait wait=new WebDriverWait(driver,timeOut);
        return wait.until(ExpectedConditions.refreshed(elementExpectedCondition));
    }


}
