package com.selenium.infrastructure.basetests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class WebBaseTest {

    private static final int default_implicit_wait = 10;

    private static final String DEFAULT_IE_DRIVER_PATH = "../SELENIUM_RESOURCES/drivers/IEDriverServer.exe";
    private static final String DEFAULT_CHROME_DRIVER_PATH = "../SELENIUM_RESOURCES/drivers/chromedriver.exe";
    private static final String DEFAULT_GECKO_DRIVER_PATH="../SELENIUM_RESOURCES/drivers/geckodriver.exe";

    private static final String IE_SYSTEM_PROPERTY = "webdriver.ie.driver" ;
    private static final String CHROME_SYSTEM_PROPERTY = "webdriver.chrome.driver" ;
    private static final String FIREFOX_SYSTEM_PROPERTY = "webdriver.gecko.driver";


    //declare the driver
    WebDriver driver;


    //declare environment variable
    String environment = null;

    //declare the logger for the testclass
    private Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());



    /**
     * Method to get the driver based on the browser
     * @return WebDriver based on the browser
     */
    public WebDriver getDriver(String browser){

        try {

           if(browser.equalsIgnoreCase("IE"))
            {
                driver = getIEDriver();
            }
            else if(browser.equalsIgnoreCase("CHROME"))
            {
                driver = getChromeDriver();
            }
            else if(browser.equalsIgnoreCase("FIREFOX"))
            {
                driver = getFirefoxDriver();
            }
            else
            {
                driver = getIEDriver();
            }
            driver.manage().timeouts().implicitlyWait(default_implicit_wait, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return driver;
    }

    /**
     * Method to get the driver based on the browser
     * @param driverPath
     * @return WebDriver based on the browser
     */
    public WebDriver getDriver(String browser, String driverPath){

        try
        {

        if(browser.equalsIgnoreCase("IE"))
          {
              driver = getIEDriver(driverPath);
          }
          else if(browser.equalsIgnoreCase("CHROME"))
          {
              driver = getChromeDriver(driverPath);
          }
          else if(browser.equalsIgnoreCase("FIREFOX"))
          {
              driver = getFirefoxDriver(driverPath);
          }
          else
          {
              driver = getIEDriver(driverPath);
          }

          driver.manage().timeouts().implicitlyWait(default_implicit_wait, TimeUnit.SECONDS);
        driver.manage().window().maximize();

            } catch (Exception e) {
                e.printStackTrace();
    }

        return driver;
    }

    /**
     * implicit wait function
     */
    public void implicitWait()
    {
        driver.manage().timeouts().implicitlyWait(default_implicit_wait, TimeUnit.SECONDS);

    }

    /**
     * maximize the browser
     */
    public void maximizeBrowser()
    {
        driver.manage().window().maximize();

    }

     /**
     * Method to shut down the driver
     * @param driver
     */
    public  void driverShutDown(WebDriver driver)
    {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
            }
        }catch(Exception e)
        {

        }

    }


    /**
     * Method to close the browser
     * @param driver
     */
    public void closeBrowser(WebDriver driver)
    {
        if(driver!=null)
        {
            driver.close();
        }
    }

    /**
     * Method to get the IE Driver
     * @return
     * @throws FileNotFoundException
     */
    public WebDriver getIEDriver() throws FileNotFoundException {
        return getIEDriver(DEFAULT_IE_DRIVER_PATH);
    }

    /**
     * Method to get the IE driver by providing the IEDriver path
     * @param driverPath
     * @return
     */
    public WebDriver getIEDriver(String driverPath)
    {
        File file = new File(driverPath);
        System.setProperty(IE_SYSTEM_PROPERTY, file.getAbsolutePath());
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
        driver = new InternetExplorerDriver(options);
        implicitWait();
        maximizeBrowser();
        return driver;

    }

    /**
     * Method to get the chrome driver
     * @return
     * @throws FileNotFoundException
     */
    public WebDriver getChromeDriver() throws FileNotFoundException {
        return getChromeDriver(DEFAULT_CHROME_DRIVER_PATH);
    }

    /**
     * Method to get the Chrome driver by providing the driver path
     * @param driverPath
     * @return
     */
    public WebDriver getChromeDriver(String driverPath)
    {
        File file = new File(driverPath);
        System.setProperty(CHROME_SYSTEM_PROPERTY, file.getAbsolutePath());
        driver = new ChromeDriver();
        implicitWait();
        maximizeBrowser();
        return driver;

    }


    /**
     * Method to get the firefox driver
     * @return WebDriver
     */
    public WebDriver getFirefoxDriver()  {

        return getFirefoxDriver(DEFAULT_GECKO_DRIVER_PATH);

    }

    /**
     * Method to get the Firefox driver by providing driver path
     * @param driverPath
     * @return
     */
    public WebDriver getFirefoxDriver(String driverPath)  {

        File file = new File(driverPath);
        System.setProperty(FIREFOX_SYSTEM_PROPERTY, file.getAbsolutePath());
        driver = new FirefoxDriver();
        implicitWait();
        maximizeBrowser();
        return driver;

    }

}
