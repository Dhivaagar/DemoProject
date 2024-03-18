package appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class MobileTest {
    static AppiumDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName", "Android");
        cap.setCapability("no", "true");
        cap.setCapability("fullReset", "false");
        cap.setCapability("appPackage", "com.wdiodemoapp");
        cap.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
        cap.setCapability("noReset", "true");
        cap.setCapability("newCommandTimeout", "3000");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Swipe']")).click();
        By viewPort = By.xpath("//android.widget.ScrollView[@content-desc=\"Swipe-screen\"]");
        Assert.assertTrue(driver.findElement(viewPort).isDisplayed());
        By toFind = By.xpath("//android.widget.ImageView[@content-desc=\"WebdriverIO logo\"]");
//        Assert.assertTrue(SwipeAction.scroll(driver, null, toFind, SwipeAction.ScrollDirection.DOWN,
//                0.75, 15, Duration.ofSeconds(5)).isDisplayed());

    }
}