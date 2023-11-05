package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest {

    RegisterPage registerPage = new RegisterPage();
    HomePage homePage = new HomePage();
    LogInPage logInPage = new LogInPage();
    CategoriesPage categoriesPage = new CategoriesPage();

    @Test(priority = 1)
    public void verifyUserShouldBeAbleToRegisterSuccessfully() {
        homePage.clickOnRegisterButton();
        registerPage.verifyThatUserIsOnRegisterPage();
        registerPage.enterDetailsForRegistration();
        registerPage.verifyResultTextIsCorrect();
        registerPage.verifySuccessfulRegistration();
    }

    @Test(priority = 2)
    public void verifyRegisteredUserShouldBeAbleToLoginSuccessfully() {
        homePage.clickOnRegisterButton();
        registerPage.enterDetailsForRegistration();
        homePage.clickOnLoginButton();
        logInPage.verifyThatUserIsOnLoginPage();
        logInPage.enterDetailsForLogin();
        logInPage.verifyThatLoginIsSuccessful();
    }

    @Test(priority = 3)
    public void verifyLoggedInUserShouldBeAbleToReferAProductToAFriendSuccessfully() {
        homePage.clickOnRegisterButton();
        registerPage.enterDetailsForRegistration();
        homePage.clickOnLoginButton();
        logInPage.enterDetailsForLogin();
        homePage.clickOnElectronicsButton();
        categoriesPage.navigateToProductPage();
        categoriesPage.referProductToAFriend();
        categoriesPage.verifyReferringProductToAFriendIsSuccessful();
        categoriesPage.verifyResultTextIsCorrect();
    }
}
