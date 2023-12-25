package config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfig {
    public static AppiumDriver<MobileElement> driver;

    @BeforeSuite
    public void setup()  {
//  "platformName": "Android",
//  "deviceName": "Nex6",
//  "platformVersion": "8.0",
//  "appPackage": "com.sheygam.contactapp",
//  "appActivity": ".SplashActivity"

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Nex5");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability("appPackage", "com.sheygam.contactapp");
        capabilities.setCapability("appActivity", ".SplashActivity");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\QA_Auto_Projects\\GitProjects\\Mobile22\\src\\contacts-android.apk");
        try {
            driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }

    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}
