package org.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.page.LoginPage.driver;


public class CheckoutPage {
    // Locators for checkout page elements
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    protected static By lblPaymentInformation = By.xpath("//div[text()='SauceCard #31337']");
    protected static By lblShippingInformation = By.xpath("//div[text()='Free Pony Express Delivery!']");
    protected static By txtTax = By.xpath("//div[text()='Tax: $']");
    protected static By txtTotal = By.xpath("//div[text()='Total: $']");
    protected static By txtMsgSuccess = By.xpath("//h2[text()='Thank you for your order!']");

    protected static By btnFinish = By.xpath("//button[@id='finish']\n");

    // Return the payment information displayed on the checkout page
    public static String getPaymentInformation() {
        String paymentInformation = driver.findElement(lblPaymentInformation).getText();
        logger.info("Get Payment Information : " + paymentInformation);
        return paymentInformation;


    }

    // Return the shipping information displayed on the checkout page
    public static String getShippingInformation() {
        String shippingInformation = driver.findElement(lblShippingInformation).getText();
        logger.info("Get Shipping Information : " + shippingInformation);
        return shippingInformation;


    }

    // Return the tax amount displayed on the checkout page
    public static String getTax() {
        String tax = driver.findElement(txtTax).getText();
        logger.info("Get Item Tax : " + tax);
        return tax;


    }

    // Return the total amount displayed on the checkout page
    public static String getTotal() {
        String Total = driver.findElement(txtTotal).getText();
        logger.info("Get Item Total : " + Total);
        return Total;


    }

    // Return the success message displayed after a successful order
    public static String getSuccessMessage() {
        String msg = driver.findElement(txtMsgSuccess).getText();
        logger.info("Get The Success Message  : " + msg);
        return msg;


    }

    // Click the Finish button
    public static void clickFinishButton() {

        driver.findElement(btnFinish).click();
        logger.info("Clicked Finish Button");


    }

    // Close and quit the browser
    public static void closeBrowser() {

        driver.close();
        driver.quit();
        logger.info("Close The Browser");

    }
}
