package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class SearchPage extends Utils {

    //Creates a static string to search and for a verification point
    static String search = "apple";

    //Seaarches for the product
    public void searchForProduct() {
        // Turns the string into array of characters
        char[] charArray = search.toCharArray();

        //Makes the first character uppercase
        charArray[0] = Character.toUpperCase(charArray[0]);

        //Turns the array back into string
        search = String.valueOf(charArray);

        //Searches for product using the static string
        typeText(By.id("small-searchterms"), search);
        clickElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));
    }

    //Verifies that all the results have the keyword in them
    public void verifyRelevantSearchResults() {
        //returnList iterates through items
        String productList = returnList(By.cssSelector("div.item-grid"));

        //Makes sure all products have the search word in them
        Assert.assertTrue(productList.contains(search), "No relevant results");
    }
}
