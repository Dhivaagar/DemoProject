package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class TableHandling {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://letcode.in/table");
        List<WebElement> prices = driver.findElements(By.xpath("(//table)[1]/tbody/tr/td[2]"));
        int total = Integer.parseInt(driver.findElement(By.xpath("(//table)[1]/tfoot/td[2]/b")).getText());
        int totalPrice = 0;
        for(WebElement price:prices){
            totalPrice += Integer.parseInt(price.getText());
        }
        System.out.println(totalPrice);
        if(totalPrice==total)
            System.out.println("The total price is correct!!...");
        else
            System.out.println("The total price is incorrect!!...");
        driver.quit();
    }
}
