package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/alert");

        driver.findElement(By.id("accept")).click();
        System.out.println("Accept alert text : " +driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirm")).click();
        System.out.println("Dismiss alert text : " +driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        driver.findElement(By.id("prompt")).click();
        System.out.println("Prompt alert text : " +driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Dhivaagar");
        driver.switchTo().alert().accept();
        System.out.println("prompt MyName alert text : " +driver.findElement(By.id("myName")).getText());

        driver.findElement(By.id("modern")).click();
        System.out.println("Dismiss alert text : " +driver.findElement(By.xpath("(//div[@class='card-content']//child::p)[2]")).getText());
        driver.findElement(By.xpath("//button[@aria-label='close']")).click();

        driver.quit();
    }
}
