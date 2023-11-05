package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

import static org.example.Utils.*;

public class RegisterPage extends Utils {
    public void verifyThatUserIsOnRegisterPage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/register?returnUrl=%2F"), "User is not on register page.");
    }

    public void enterDetailsForRegistration() {
        typeText(By.id("FirstName"), "J");
        typeText(By.id("LastName"), "G");
        typeText(By.id("Email"), email);
        typeText(By.name("Password"), password);
        typeText(By.name("ConfirmPassword"), password);
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByIndex(3);
        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByIndex(3);
        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByIndex(3);
        waitForClickable(By.id("register-button"), Duration.ofSeconds(3));
        clickElement(By.id("register-button"));
    }

    public void verifyResultTextIsCorrect() {
        System.out.println(getTextFromElement(By.className("result")));
        String actual = getTextFromElement(By.className("result"));
        Assert.assertEquals(actual, "Your registration completed", "Result text is incorrect");
    }

    public void verifySuccessfulRegistration() {
        clickElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a"));
    }
}
