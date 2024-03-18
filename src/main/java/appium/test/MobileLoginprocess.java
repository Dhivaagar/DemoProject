package appium.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.Test;
import selenium.test.LoginDataProvider;

import java.net.URL;



public class MobileLoginprocess {

    public AppiumDriver createAndroidDriver() {

        AndroidDriver driver = null;

        try {
            DesiredCapabilities capabilities = getDesiredCapabilities();
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (Exception e) {
            System.out.println("Error in creating driver: " + e.getMessage());
        }

        return driver;
    }

    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "3f484ecf");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "");
        capabilities.setCapability("appPackage", "com.mysunpower");
        capabilities.setCapability("appActivity", "com.mysunpower.MainActivity");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("fullReset", "false");
        capabilities.setCapability("region", "us");
        capabilities.setCapability("newCommandTimeout", 3000);
        return capabilities;
    }

    @Test(dataProvider = "excelLogin", dataProviderClass = LoginDataProvider.class)
    public void process(String email, String pass) throws InterruptedException {

        AppiumDriver driver = this.createAndroidDriver();

    }


}