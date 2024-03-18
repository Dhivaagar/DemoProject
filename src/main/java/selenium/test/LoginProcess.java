package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginProcess {

    @Test(dataProvider = "excelLogin", dataProviderClass = LoginDataProvider.class)
    public static void process(Object[] param) throws InterruptedException {

        System.out.println(param[0]);
//        ChromeDriver driver =new ChromeDriver();
//        driver.get("https://letcode.in/");
//        driver.findElement(By.xpath("//a[text()='Log in']")).click();
//        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
//        driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
//        Thread.sleep(6000);
//        driver.findElement(By.xpath("//a[text()='Sign out']")).click();
    }
}