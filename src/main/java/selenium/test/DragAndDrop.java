package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragAndDrop {
    public static void main(String[] args) {
//        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By cookies_Close = By.xpath("(//button[@aria-label='Close'])[2]");

        driver.manage().window().maximize();
        driver.get("https://open.spotify.com/");
        driver.findElement(By.xpath("//span[text()='Log in'] | //span[text()='login']")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("login-username")));
        driver.findElement(By.id("login-username")).sendKeys("dhivaagarjb@gamil.com");
        driver.findElement(By.id("login-password")).sendKeys("dhivaagar02");
        driver.findElement(By.xpath("//span[text()='Log In']/..")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement((By.xpath("//div[text()='Latest Tamil']"))));
        driver.findElement(By.xpath("//div[text()='Latest Tamil']")).click();
        driver.findElement(By.xpath(
                "(//button[@data-testid='play-button'])[2]")).click();

        System.out.println(driver.findElement(cookies_Close).isDisplayed());
        if (driver.findElement(cookies_Close).isDisplayed()) {
            driver.findElement(cookies_Close).click();
        }

        driver.findElement(By.xpath("//button[@data-testid='control-button-queue']/span")).click();
        WebElement from = driver.findElement(By.xpath("(//div[@data-testid='tracklist-row'])[4]/div"));
        WebElement to = driver.findElement(By.xpath("(//div[@data-testid='tracklist-row'])[3]/div"));
        System.out.println(from.getText());
        System.out.println(to.getText());
        new Actions(driver).clickAndHold(from).perform();
        System.out.println(from.getText());
        System.out.println(to.getText());
    }
}
