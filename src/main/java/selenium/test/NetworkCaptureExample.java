package selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.logging.Level;

public class NetworkCaptureExample {

    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/aximsoft-dhivaagarb/.cache/selenium/chromedriver/win64/120.0.6099.71/chromedriver.exe");

        /*// Enable logging for Chrome
        System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");

        // Disable WebDriver logs
        System.setProperty("webdriver.chrome.silentOutput", "true");
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);*/

        // Start Chrome with remote debugging enabled
        WebDriver driver = new ChromeDriver();

        // Navigate to your website
        driver.get("https://example.com");

        // Perform your Selenium actions here...

        // Close the browser
        driver.quit();
    }
}
