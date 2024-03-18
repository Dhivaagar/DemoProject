package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseHover {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//button[.='✕']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement elect = driver.findElement(By.xpath("(//div[@class='eFQ30H'])[4]"));
        Actions builder = new Actions(driver);
        builder.moveToElement(elect).perform();
        driver.findElement(By.xpath("//a[.='Laptop and Desktop']")).click();
    }
}
