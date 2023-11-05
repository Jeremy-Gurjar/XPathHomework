package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;


import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Utils {
    static String email = "test1" + timeStamp() + "@test.com";

    static String password = "Password";


    public static void captureScreenshot(String screenShotName)
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("ScreenshotsTS\\" + screenShotName +timeStamp()+ ".png"));
            System.out.println("Screenshot taken");
        } catch (
                IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }

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
}
