package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.time.Duration;

public class CategoriesPage extends Utils {
    public void navigateToProductPage() {
        clickElement(By.linkText("Camera & photo"));
        clickElement(By.xpath("//*[contains(@src, \"0000039\")]"));
    }

    public void referProductToAFriend () {
        clickElement(By.cssSelector("button.button-2.email-a-friend-button"));
        typeText(By.className("friend-email"), "test1" + timeStamp() + "@test.com");
        clickElement(By.xpath("//*[@action =\"/productemailafriend/16\"]/div[2]/button"));
    }

    public void verifyReferringProductToAFriendIsSuccessful() {
        try {
            waitForVisible(By.cssSelector("div.result"), Duration.ofSeconds(10));
        } catch (NoSuchElementException e) {
            System.out.println("Referring product not successful");
        }
    }

    public void verifyResultTextIsCorrect() {
        String actual = getTextFromElement(By.cssSelector("div.result"));
        Assert.assertEquals(actual, "Your message has been sent.", "Result text is incorrect");
    }
}
