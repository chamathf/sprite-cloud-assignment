package org.page;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.HashMap;
import java.util.Map;


public class LoginPage {
    static WebDriver driver;

    // Constructor to initialize the WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for  elements on the login page
    protected static By btnLogin = By.id("login-button");
    protected static By titleUserName = By.id("user-name");
    protected static By txtPassword = By.id("password");

    protected static By txtErrorMessage = By.xpath("//h3[@data-test='error']");

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    // Launches Chrome browser with specific options and navigates to the URL
    public static void navigateToTheURL(String url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--password-store=basic");
        options.addArguments("--disable-features=PasswordManager");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.get(url);

    }


    // Enter the username into the username field
    public static void enterUserName(String userName) {
        WebElement txtFldUserName = driver.findElement(titleUserName);
        txtFldUserName.clear();
        txtFldUserName.sendKeys(userName);
        logger.info("Entered the Email : " + userName);

    }

    // Enter the password into the password field
    public static void enterPassword(String password) {
        WebElement txtFldPassword = driver.findElement(txtPassword); // Corrected locator here
        txtFldPassword.clear();
        txtFldPassword.sendKeys(password);
        logger.info("Entered the Password : " + password);
    }

    // Click the login button
    public static void clickLoginButton() {
        driver.findElement(btnLogin).click();
        logger.info("Click Login Button");


    }

    // Get the error message text displayed on failed login
    public static String getLoginErrorMessage() {
        return driver.findElement(txtErrorMessage).getText();
    }
}
