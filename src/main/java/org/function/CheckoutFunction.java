package org.function;

import org.page.CheckoutPage;


public class CheckoutFunction {

    // Get the payment information from the checkout page
    public static String PaymentInformation() {

        String paymentInformation = CheckoutPage.getPaymentInformation();
        return paymentInformation;
    }

    // Get the shipping information from the checkout page
    public static String ShippingInformation() {

        String shippingInformation = CheckoutPage.getShippingInformation();
        return shippingInformation;
    }

    // Get the item total from the checkout page
    public static String ItemTotal() {

        String itemTotal = CheckoutPage.getTotal();
        return itemTotal;
    }


    // Get the tax from the checkout page
    public static String Tax() {

        String tax = CheckoutPage.getTax();
        return tax;
    }

    // Get total from the checkout page
    public static String getTotal() {

        String total = CheckoutPage.getTotal();
        return total;
    }

    // Get the success message  from the checkout page
    public static String getSuccessMessage() {

        String msg = CheckoutPage.getSuccessMessage();
        return msg;
    }

    // Get the click finish button from the checkout page
    public static void clickFinishButton() throws InterruptedException {

        CheckoutPage.clickFinishButton();

    }

    public static void closeTheBrowser() throws InterruptedException {

        CheckoutPage.closeBrowser();

    }

}
