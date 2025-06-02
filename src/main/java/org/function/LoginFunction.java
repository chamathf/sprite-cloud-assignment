package org.function;
import org.page.LoginPage;

public class LoginFunction {

    // Enter the username into the username input field
    public static void enterUserName(String userName) throws InterruptedException {

        LoginPage.enterUserName(userName);
    }

    // Enter the password into the password input field
    public static void enterPassword(String password) throws InterruptedException {

        LoginPage.enterPassword(password);
    }

    //Click the login button
    public static void clickLoginButton() throws InterruptedException {

        LoginPage.clickLoginButton();

    }

    // Get the error message displayed for an invalid login
    public static String getInvalidLoginErrorMessage() {

        String msg = LoginPage.getLoginErrorMessage();
        return msg;
    }
}
