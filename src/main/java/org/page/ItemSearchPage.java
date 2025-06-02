package org.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.utils.UtilHelper;

import java.util.List;
import java.util.stream.Collectors;

import static org.page.LoginPage.driver;

public class ItemSearchPage {

    private static final Logger logger = LogManager.getLogger(ItemSearchPage.class);

    // Locators for  elements on the item search page
    protected static By btnCart = By.id("shopping_cart_container");

    protected static By btnCheckout = By.id("checkout");
    protected static By txtFldFirstName = By.id("first-name");
    protected static By txtFldLastName = By.id("last-name");
    protected static By txtFldPostalCode = By.id("postal-code");

    protected static By btnContinue = By.id("continue");

    protected static By btnDropDown = By.className("product_sort_container");

    protected static By listInventory = By.className("inventory_item_name");

    // Get the locator for the add to cart button of a specific product
    private static By getProductAddToCartButton(String productName) {
        String formattedName = UtilHelper.toDataTestFormat(productName);
        return By.xpath("//button[@data-test='add-to-cart-" + formattedName + "']");
    }

    // Clicks add to cart for the first product
    public static void selectTheItem1(String productName1) {
        driver.findElement(getProductAddToCartButton(productName1)).click();
        ;
        logger.info("Select the Item 1:- Sauce Labs Backpack");
    }

    // Click add to cart for the second product
    public static void selectTheItem2(String productName2) {

        driver.findElement(getProductAddToCartButton(productName2)).click();
        ;
        logger.info("Select the Item 2:- Sauce Labs Bike Light");
    }

    // Click add to cart for the third product
    public static void selectTheItem3(String productName3) {

        driver.findElement(getProductAddToCartButton(productName3)).click();
        logger.info("Select the Item 3:- Sauce Labs Fleece Jacket");
    }

    // Click the cart button
    public static void clickCart() {

        driver.findElement(btnCart).click();
        logger.info("Click the Cart Button");
    }

    // Scroll and click the checkout button
    public static void clickCheckout() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement checkoutButton = driver.findElement(btnCheckout);
        js.executeScript("arguments[0].scrollIntoView(true);", checkoutButton);
        checkoutButton.click();
        logger.info("Click the Checkout Button");
    }

    //Enter the user first name
    public static void enterFirstName(String fName) {

        WebElement firstName = driver.findElement(txtFldFirstName);
        firstName.clear();
        firstName.sendKeys(fName);

        logger.info("Typed First Name: " + fName);
    }

    // Enter the user last name
    public static void enterLastName(String lName) {

        WebElement lastName = driver.findElement(txtFldLastName);
        lastName.clear();
        lastName.sendKeys(lName);

        logger.info("Typed Last Name: " + lastName);
    }

    // Enter the user zip code
    public static void enterZipCode(String zCode) {

        WebElement zipCode = driver.findElement(txtFldPostalCode);
        zipCode.clear();
        zipCode.sendKeys(zCode);

        logger.info("Typed Zip COde : " + zCode);
    }

    // Click the Continue button
    public static void clickBtnContinue() {

        driver.findElement(btnContinue).click();
        logger.info("Click the continue Button");

    }

    // Select a sorting option from the filter dropdown
    public static void selectDropDownElement(String fType) {

        WebElement dropdownElement = driver.findElement(btnDropDown);
        Select sortDropdown = new Select(dropdownElement);
        sortDropdown.selectByVisibleText(fType);
        logger.info("Selected filter from dropdown: " + fType);
    }

    // get a list of product names displayed on the page
    public static List<String> getDisplayedProductNames() {
        List<WebElement> productElements = driver.findElements(listInventory);
        return productElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}

