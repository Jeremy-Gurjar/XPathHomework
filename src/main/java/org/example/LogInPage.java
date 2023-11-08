package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;


public class LogInPage extends Utils {

    //Verifies that the user is on login page
    public void verifyThatUserIsOnLoginPage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/login?returnUrl=%2F"), "User is not on login page.");
    }

    //Enters details for login
    public void enterDetailsForLogin () {
        //Enters email and password
        typeText(By.id("Email"), email);
        typeText(By.id("Password"), password);

        //Confirms login
        clickElement(By.cssSelector("button.button-1.login-button"));
    }

    //Verifies login is successful
    public void verifyThatLoginIsSuccessful() {
        //When logged in, you are redirect to the home page so if login was successful, you will be redirected to the home page.
        Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/"), "User has not logged in successfully");
    }
}
