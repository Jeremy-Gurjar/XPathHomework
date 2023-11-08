package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.example.Utils.*;

public class RegisterPage extends Utils {

    //Verfies user is on register page
    public void verifyThatUserIsOnRegisterPage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/register?returnUrl=%2F"), "User is not on register page.");
    }

    //Enters details for registration
    public void enterDetailsForRegistration() {
        //Enters firstname and lastname
        typeText(By.id("FirstName"), "J");
        typeText(By.id("LastName"), "G");

        //Enter email
        typeText(By.id("Email"), email);

        //Types and confirms password
        typeText(By.name("Password"), password);
        typeText(By.name("ConfirmPassword"), password);

        //Selects date of birth
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByIndex(3);
        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByIndex(3);
        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByIndex(3);

        //Clicks register to confirm register
        waitForClickable(By.id("register-button"), Duration.ofSeconds(3));
        clickElement(By.id("register-button"));
    }

    //Verifies result text is correct
    public void verifyResultTextIsCorrect() {
        System.out.println(getTextFromElement(By.className("result")));
        String actual = getTextFromElement(By.className("result"));
        Assert.assertEquals(actual, "Your registration completed", "Result text is incorrect");
    }

    //Verifies registration is successful
    public void verifySuccessfulRegistration() {
        clickElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a"));
    }
}
