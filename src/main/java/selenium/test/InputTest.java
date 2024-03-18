package selenium.test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.network.model.CachedResource;
import org.openqa.selenium.edge.EdgeDriver;

public class InputTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/edit");
        driver.findElement(By.id("fullName")).sendKeys("Dhivaagar JB");
        driver.findElement(By.id("join")).sendKeys(" person", Keys.TAB);
        String value = driver.findElement(By.id("getMe")).getAttribute("value");
        System.out.println(value);
        driver.findElement(By.id("clearMe")).clear();
        boolean noEdit = driver.findElement(By.id("noEdit")).isEnabled();
        System.out.println(noEdit);
        String read = driver.findElement(By.id("dontwrite")).getAttribute("readonly");
        System.out.println(read);
        driver.quit();
    }
}
