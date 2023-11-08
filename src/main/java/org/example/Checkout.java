package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Checkout extends Utils {

    //Searches for apple macbook
    public void searchForProduct() {
        typeText(By.id("small-searchterms"), "apple macbook");
        clickElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));
    }

    public void addToCart() {
        //Adds product to cart and goes to cart
        clickElement(By.linkText("Apple MacBook Pro 13-inch"));
        clickElement(By.id("add-to-cart-button-4"));
        clickElement(By.linkText("shopping cart"));
    }

    //Buys item
    public void buyItem() {
        //Goes to checkout
        clickElement(By.id("termsofservice"));
        clickElement(By.id("checkout"));

        //Selects country
        Select selectCountry = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
        selectCountry.selectByIndex(233);

        //Types city, postcode and address
        typeText(By.id("BillingNewAddress_City"), "London");
        typeText(By.id("BillingNewAddress_Address1"), "10 Downing Street");
        typeText(By.id("BillingNewAddress_ZipPostalCode"), "SW1 2AA");

        //Types phone number
        typeText(By.id("BillingNewAddress_PhoneNumber"), "020 7219 4272");

        //Clicks continue to proceed
        clickElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]"));
        clickElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"));
        clickElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button"));
        clickElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button"));

        //Confirms checkout
        clickElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button"));
    }

    //Verifies that selected item is in shopping cart
    public void verifyItemIsInShoppingCart() {
        //Iterates through list of shopping cart
        String actual = returnList(By.cssSelector("table.cart"));

        //Verifies that list contains macbook
        Assert.assertTrue(actual.contains("Apple MacBook Pro 13-inch"), "Item is not visible in cart");
    }

    //Verifies that result text of checkout is correct
    public void verifyCorrectResultText() {
        String actual = getTextFromElement(By.xpath("//*[@class = \"page-body checkout-data\"]/div/div/strong"));
        Assert.assertEquals(actual, "Your order has been successfully processed!");
    }
}
