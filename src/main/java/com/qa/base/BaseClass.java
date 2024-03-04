package com.qa.base;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

/**
 * Base Class - Driver initialization and set desired capabilities
 **/
public class BaseClass {

    private static final Logger logger = LogManager.getLogger(BaseClass.class);

    public AndroidDriver androidDriver;
    URL appiumURL = null;
    public static Properties prop;

    public BaseClass() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com" +
                    "/qa/config/configProperties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AndroidDriver initializeDriver() {
        try {
            appiumURL = new URL(" http://127.0.0.1:4723/wd/hub");
            this.androidDriver = new AndroidDriver(appiumURL, setAndroidAppCapabilities());
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return androidDriver;
    }

    public DesiredCapabilities setAndroidAppCapabilities() {
        logger.debug("Setting desired capabilities");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "sdk_gphone_x86");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("app", System.getProperty("user.dir") + "/application/" + "com.fivemobile.thescore_24.3.0-24030_minAPI24.apk");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("appPackage", "com.fivemobile.thescore");
        cap.setCapability("appActivity", "com.fivemobile.thescore.ui.MainActivity");
        cap.setCapability("automationName", "UiAutomator2");
        return cap;
    }

    public void explicitWait(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }
}
