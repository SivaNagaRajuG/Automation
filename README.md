# Automation APPIUM
This repository contains the project to test the Amazon app functionalities in Android Device.<br>

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
6. Execute the Amazon_Test.xml from "com.selenium.config" package <Br>
7. Script to verify kindle e book link will be executed in Android device (Virtual/Real). <Br>
8. Logs will be displayed in console for debugging purpose.<Br>
9. Html report will be generated in target folder which can be shared to the team.<Br>
 ***
  
  <B> Framework Best practices </B>
  1. Implemented Data Driven Framework to get provide the data from external Excel sheet
  2. Implemented Page Object Model (Design Pattern) for easy maintenace <br>
  3. Logs using Log4j to console for debugging purpose - Low level logging <br>
  4. HTML Reporting using extent reports to share with team<br>
