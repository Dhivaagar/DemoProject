package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class YoutubeTrending {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//yt-icon-button[@id='guide-button'])[position()=1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@title='Trending' and @id='endpoint']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Music']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@id='video-title'])[position()=1]")).click();

    }
}
