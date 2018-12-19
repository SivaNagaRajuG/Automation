# Automation APPIUM
This repository contains the following three projects.<br>
<B>1. Framework </B> : Core framework which contains reusable functions and modules which can be used across all the test projects.<br>
<B>2. AmazonApp_Test </B> : Appium test project to verify the Amazon app functinalities in Android device.<br>
<B>3. SELENIUM_RESOUCES </B> : Contains all the files related to drivers , test data and configuration.

<B>PreRequisites : </B><br>
1. Java JDK<Br>
2. Android SDK (Comes with Android Studio)<Br>
3. Appium Desktop for Windows.


<B> Get Started :</B><br>
1. Clone the project to local repository.<Br>
2. Open AmazonApp_Test in Eclipse/Intellij.<Br>
3. Run the Appium server at 127.0.0.0.1:4723<Br>
4. Connect the virtual android device through AVD / connect the real device.<Br>
5. Update the device and app details in Automationconfigurator.properties file.<Br>
6. Execute the Amazon_Test from "com.selenium.amazon.tests" package <Br>
7. Script to verify kindle e book link will be executed in Android device (Virtual/Real). <Br>
8. Logs will be displayed in console for debugging purpose.<Br>
9. Html report will be generated in Target folder which can be shared to the team.<Br>
 ***
  
  <B> Framework Best practices </B>
  1. Data Driven Framework with Page Object Model (Design Pattern) for easy maintenace <br>
  2. Logs using Log4j to console for debugging purpose <br>
  3. HTML Reporting using extent reports to share with team<br>
