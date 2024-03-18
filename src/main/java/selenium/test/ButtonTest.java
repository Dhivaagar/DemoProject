package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonTest {
    public static boolean isClickable(WebElement ele, ChromeDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
            element.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/buttons");


        driver.findElement(By.id("home")).click();
        driver.navigate().back();

        System.out.println("Position of the button : " +driver.findElement(By.id("position")).getLocation().toString());
        System.out.println("Color of the button : " +driver.findElement(By.id("color")).getCssValue("background-color"));

        Rectangle rect = driver.findElement(By.id("property")).getRect();
        System.out.println("Dimension of the button : "+rect.height+" Height and "+rect.width+" Width");

        System.out.println("Is clickable : " + isClickable(driver.findElement(By.id("isDisabled")), driver));

        System.out.println("Is enable : "+driver.findElement(By.id("isDisabled")).isEnabled());
        driver.findElement(By.id("isDisabled")).click();
        ///driver.findElement(By.id("home"))

        driver.quit();
    }
}
