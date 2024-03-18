package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AppiumTest{
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //URL launch
        driver.get("https://www.tutorialspoint.com/index.htm");
        WebElement n=driver.findElement(By.className("mui-btn"));
        n.click();
        // explicit wait
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(8));
        // elementToBeClickable expected criteria
        wt.until(ExpectedConditions.elementToBeClickable (By.className("s-buy")));
        System.out.println("Current page title:" + driver.getTitle());
        driver.close();
    }
}