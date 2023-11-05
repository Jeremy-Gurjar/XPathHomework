package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;


public class LogInPage extends Utils {
    public void verifyThatUserIsOnLoginPage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/login?returnUrl=%2F"), "User is not on login page.");
    }

    public void enterDetailsForLogin () {
        typeText(By.id("Email"), email);
        typeText(By.id("Password"), password);
        clickElement(By.cssSelector("button.button-1.login-button"));
    }

    public void verifyThatLoginIsSuccessful() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/"), "User has not logged in successfully");
    }
}
