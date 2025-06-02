package ui.base;

import org.common.Constants;
import org.function.CheckoutFunction;
import org.page.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUITest {
    // Launch the browser and navigates to the application URL before each test
    @BeforeMethod(alwaysRun = true)
    public void browserLaunch()  {
        LoginPage.navigateToTheURL(Constants.APP_URL);
    }

    // Close the browser after each test
    @AfterMethod(alwaysRun = true)
    public void browserClouser() throws InterruptedException {
        CheckoutFunction.closeTheBrowser();
    }
}
