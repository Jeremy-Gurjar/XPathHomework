package org.example;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.testng.Assert;

public class NopCommerceNewReleaseDetails extends Utils {
    //Creates static string title using timestamp
    static String title = "test1" + timeStamp();

    //Creates static string comment using timestamp
    static String comment = "testcomment" + timeStamp();

    //Fills in the comment
    public void fillInComment() {
        typeText(By.id("AddNewComment_CommentTitle"), title);
        typeText(By.id("AddNewComment_CommentText"), comment);
        clickElement(By.cssSelector("button.button-1.news-item-add-comment-button"));
    }

    //Verifies result text is correct
    public void verifyCorrectResultText () {
        String actual = getTextFromElement(By.cssSelector("div.result"));
        Assert.assertEquals(actual, "News comment is successfully added.", "Result text is incorrect");
    }

    //Verifies the comment is seen below
    public void verifyCommentIsSeenBelow() {
        //List iterates through comments
        String actual = returnList(By.cssSelector("div.comments"));

        //Make sure at least one comment has the inputted title and comment
        Assert.assertTrue(actual.contains(title), "Comment title is not seen below");
        Assert.assertTrue(actual.contains(comment), "Comment text is not seen below");
    }
}
