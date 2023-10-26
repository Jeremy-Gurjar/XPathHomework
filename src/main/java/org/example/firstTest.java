package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class firstTest {
    protected static WebDriver driver;
    public static String timeStamp(){
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return timeStamp;
    }

    public static void clickElement(By by) {
        driver.findElement(by).click();
    }
    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public static void typeText(By by, String string) {
        driver.findElement(by).sendKeys(string);
    }

    public static void waitForInvisible(By by, Duration timeout) {
        Duration timeoutSeconds = Duration.ofSeconds((int) (timeout.toMillis() / 1000));
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitForVisible(By by, Duration timeout) {
        Duration timeoutSeconds = Duration.ofSeconds((int) (timeout.toMillis() / 1000));
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForClickable(By by, Duration timeout) {
        Duration timeoutSeconds = Duration.ofSeconds((int) (timeout.toMillis() / 1000));
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForDisappear(By by, Duration timeout) {
        Duration timeoutSeconds = Duration.ofSeconds((int) (timeout.toMillis() / 1000));
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        wait.until(ExpectedConditions.not(elementToBeClickable(by)));
    }

    public static void waitForURLToBe(String url, Duration timeout) {
        Duration timeoutSeconds = Duration. ofSeconds((int) (timeout.toMillis() / 1000));
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com");
        waitForURLToBe("https://demo.nopcommerce.com/", Duration.ofSeconds(10));
        clickElement(By.className("ico-register"));
        typeText(By.id("FirstName"), "J");
        typeText(By.id("LastName"), "G");
        typeText(By.id("Email"), "test1" + timeStamp() + "@test.com");
        typeText(By.name("Password"), "password");
        typeText(By.name("ConfirmPassword"), "password");
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByIndex(3);
        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByIndex(3);
        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByIndex(3);
        waitForClickable(By.id("register-button"), Duration.ofSeconds(3));
        clickElement(By.id("register-button"));
        waitForDisappear(By.id("register-button"), Duration.ofSeconds(10));
        System.out.println(getTextFromElement(By.className("result")));
        driver.quit();
    }
}
