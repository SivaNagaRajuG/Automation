package com.selenium.infrastructure.ExtentReports;


import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    public static String projectpath = System.getProperty("user.dir");

    public synchronized static ExtentReports getReporter() {
        if(extent == null){

            //Set HTML reporting file location
            extent = new ExtentReports(projectpath+"/target/ExtentReports/ExtentReportResults.html", true);
            extent.loadConfig(new File("src/main/resources/extent-config.xml"));

        }
        return extent;
    }
}
