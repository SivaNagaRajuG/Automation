package com.selenium.amazon.tests;

import com.selenium.amazon.flows.KindleFlow;
import com.selenium.infrastructure.basetests.MobileBaseTest;
import com.selenium.infrastructure.datahandler.DataReader;
import com.selenium.infrastructure.datahandler.ExcelReader;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.selenium.infrastructure.Listeners.TestListener.class)
public class Amazon_Test extends MobileBaseTest {

    AndroidDriver driver;
    DataReader dataReader;



@BeforeTest
 public void setUp() throws Exception {

    dataReader= new ExcelReader("../SELENIUM_RESOURCES/TestData/sampleData.xlsx","KindleEBook");
    dataReader.generateDataRecord();

    driver = getAndroidDriver();
 }

 @Test
    public void kindleEBookTest()
 {
     KindleFlow kindleFlow=new KindleFlow(driver,dataReader);
     Assert.assertTrue(kindleFlow.verifyKindleEBookLink(),"Kindle Ebook link is not dislyed");
 }

 @AfterTest
    public void tearDown()
 {
     driverShutDown(driver);
 }

}
