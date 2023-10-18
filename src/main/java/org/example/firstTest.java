package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class firstTest {
    protected static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com");
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("FirstName")).sendKeys("J");
        driver.findElement(By.id("LastName")).sendKeys("G");
        driver.findElement(By.id("Email")).sendKeys("test123@test.com");
        driver.findElement(By.id("Password")).sendKeys("password");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("password");
        driver.findElement(By.id("register-button")).click();
    }
}
