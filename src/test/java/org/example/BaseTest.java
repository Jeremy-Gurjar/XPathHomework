package org.example;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BrowserManager {

    //Opens browser before method
    @BeforeMethod
    //open browser method
    public void setUp() {
        openBrowser();
    }

    @AfterMethod
    //close browser after method
    public void tearDown(ITestResult result) {
        if (!(result.isSuccess())) {
            captureScreenshot(result.getName());
        }
        closeBrowser();
        }
}
