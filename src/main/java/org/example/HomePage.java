package org.example;

import org.openqa.selenium.By;

public class HomePage extends Utils {

    //Clicks on register button to direct to home page
    public void clickOnRegisterButton() {
        clickElement(By.className("ico-register"));;
    }

    //Login button to direct to login page
    public void clickOnLoginButton() {
        clickElement(By.className("ico-login"));
    }

    public void clickOnElectronicsButton() {
        clickElement(By.xpath("//div[@class = 'header-menu']/ul[contains(@class,'notmobile')]/li/a[@href='/electronics']"));
    }

    //CLicks on details button on nopcommerce new releases
    public void clickOnDetailsButton() {
        clickElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[5]/div[2]/div[2]/div[3]/a"));
    }
}
