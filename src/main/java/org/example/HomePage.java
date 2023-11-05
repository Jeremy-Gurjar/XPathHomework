package org.example;

import org.openqa.selenium.By;

public class HomePage extends Utils {
    public void clickOnRegisterButton()
    {
        clickElement(By.className("ico-register"));;
    }

    // click on login button
    public void clickOnLoginButton()
    {
        clickElement(By.className("ico-login"));
    }

    // click on electronics button
    public void clickOnElectronicsButton()
    {
        clickElement(By.xpath("//div[@class = 'header-menu']/ul[contains(@class,'notmobile')]/li/a[@href='/electronics']"));
    }


}
