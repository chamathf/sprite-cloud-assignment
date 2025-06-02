package org.function;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.page.ItemSearchPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemSearchFunction {
    private static final Logger logger = LogManager.getLogger(ItemSearchFunction.class);

    // Select the product item 1 by its name
    public static void selectTheProduct1(String productName1) {

        ItemSearchPage.selectTheItem1(productName1);

    }

    // Select the product item 2 by its name
    public static void selectTheProduct2(String productName2) {

        ItemSearchPage.selectTheItem2(productName2);

    }

    // Select the product item 3 by its name
    public static void selectTheProduct3(String productName3) {

        ItemSearchPage.selectTheItem3(productName3);

    }

    // Click on the cart button
    public static void clickCart() throws InterruptedException {

        ItemSearchPage.clickCart();

    }


    // Click on the checkout button
    public static void clickBtnCheckout() throws InterruptedException {

        ItemSearchPage.clickCheckout();

    }

    // Enter the first name in the form
    public static void enterFirstName(String fName) throws InterruptedException {

        ItemSearchPage.enterFirstName(fName);

    }


    // Enter the last name in the form
    public static void enterLastName(String lName) throws InterruptedException {

        ItemSearchPage.enterLastName(lName);

    }

    // Enter the zip code in the form
    public static void enterZipCode(String zCode) throws InterruptedException {

        ItemSearchPage.enterZipCode(zCode);

    }

    // Click on the continue button
    public static void clickBtnContinue() throws InterruptedException {

        ItemSearchPage.clickBtnContinue();

    }


    // Click on the filter dropdown
    public static void clickFilterDropDown(String filterType) throws InterruptedException {

        ItemSearchPage.selectDropDownElement(filterType);

    }

    // Validate whether the products on the page are sorted in descending (Z to A) order
    public static boolean validateProductsAreSortedDescending() {
        List<String> actualProductNames = ItemSearchPage.getDisplayedProductNames();
        List<String> expectedSorted = new ArrayList<>(actualProductNames);
        expectedSorted.sort(Collections.reverseOrder());

        System.out.println("Products displayed on page:");
        for (String product : actualProductNames) {
            System.out.println(" - " + product);
        }

        if (actualProductNames.equals(expectedSorted)) {
            logger.info("Products are sorted in descending order (Z to A).");
            return true;
        } else {
            logger.info(" Products are NOT sorted in descending order (Z to A).");
            logger.info("Actual Order:   " + actualProductNames);
            logger.info("Expected Order: " + expectedSorted);
            return false;
        }
    }
}

