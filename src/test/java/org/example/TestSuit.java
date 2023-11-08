package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSuit extends BaseTest {
    // Creates objects so methods from other classes can be used
    HomePage homePage = new HomePage();
    NopCommerceNewReleaseDetails nopCommerceNewReleaseDetails = new NopCommerceNewReleaseDetails();

    RegisterPage registerPage = new RegisterPage();

    LogInPage logInPage = new LogInPage();

    Checkout checkout = new Checkout();

    SearchPage searchPage = new SearchPage();

    @Test
    public void acceptAlert() {
        //Clicks search button when search box is empty
        clickElement(By.cssSelector("button.button-1.search-box-button"));

        //Driver focuses on the alert and accepts it
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void getAlertText() {
        //Vote button pressed with no vote selected
        clickElement(By.id("vote-poll-1"));

        //Focuses and gets text from the alert and accepts it.
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();

        //Prints out alert text
        System.out.println(text);
    }

    @Test
    public void verifyThatUserIsAbleToSuccessfullyCommentOnNewReleasePage() {
        homePage.clickOnDetailsButton();
        nopCommerceNewReleaseDetails.fillInComment();
        nopCommerceNewReleaseDetails.verifyCorrectResultText();
        nopCommerceNewReleaseDetails.verifyCommentIsSeenBelow();
    }

    @Test
    public void verifyThatUserIsAbleToSuccessfullyBuyItem() {
        homePage.clickOnRegisterButton();
        registerPage.enterDetailsForRegistration();
        homePage.clickOnLoginButton();
        logInPage.enterDetailsForLogin();
        checkout.searchForProduct();
        checkout.addToCart();
        checkout.verifyItemIsInShoppingCart();
        checkout.buyItem();
        checkout.verifyCorrectResultText();
    }

    @Test
    public void verifyThatRelevantResultAppearsAccordingToSearch() {
        searchPage.searchForProduct();
        searchPage.verifyRelevantSearchResults();
    }


}
