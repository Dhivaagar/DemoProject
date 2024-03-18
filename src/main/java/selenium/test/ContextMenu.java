package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ContextMenu {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement element = driver.findElement(By.xpath("(//body[@id='authentication']//child::span)[1]"));
        WebElement element1 = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        Actions builder = new Actions(driver);
        builder.contextClick(element).perform();
        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        builder.doubleClick(element1).perform();
        System.out.println(driver.switchTo().alert().getText());
        driver.quit();
    }
}
