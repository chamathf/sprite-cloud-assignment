package ui.test;

import org.assertj.core.api.SoftAssertions;
import org.common.Constants;
import org.function.CheckoutFunction;
import org.function.ItemSearchFunction;
import org.function.LoginFunction;
import org.testng.annotations.Test;
import ui.base.BaseUITest;

public class LoginAndCheckoutTest extends BaseUITest {

    /**
      This test verifies the complete workflow of login,selecting multiple products,checkout process,
      validate the payment,shipping,item total,tax and success message
     */

    @Test
    public void LoginPurchaseAndValidateTest() throws InterruptedException {


        SoftAssertions softAssertions = new SoftAssertions();

        LoginFunction.enterUserName(Constants.USER_NAME);
        LoginFunction.enterPassword(Constants.PASSWORD);
        LoginFunction.clickLoginButton();
        ItemSearchFunction.selectTheProduct1(Constants.PRODUCT_NAME_1);
        ItemSearchFunction.selectTheProduct2(Constants.PRODUCT_NAME_2);
        ItemSearchFunction.selectTheProduct3(Constants.PRODUCT_NAME_3);
        ItemSearchFunction.clickCart();
        ItemSearchFunction.clickBtnCheckout();
        ItemSearchFunction.clickBtnContinue();
        ItemSearchFunction.enterFirstName(Constants.FIRST_NAME);
        ItemSearchFunction.enterLastName(Constants.LAST_NAME);
        ItemSearchFunction.enterZipCode(Constants.ZIP_CODE);
        ItemSearchFunction.clickBtnContinue();
        String paymentInformation = CheckoutFunction.PaymentInformation();
        softAssertions.assertThat(paymentInformation).isEqualTo(Constants.PAYMENT_INFORMATION);
        String shippingInformation = CheckoutFunction.ShippingInformation();
        softAssertions.assertThat(shippingInformation).isEqualTo(Constants.SHIPPING_INFORMATION);
        String itemTotal = CheckoutFunction.ItemTotal();
        softAssertions.assertThat(itemTotal).isEqualTo(Constants.ITEM_TOTAL);
        String tax = CheckoutFunction.Tax();
        softAssertions.assertThat(tax).isEqualTo(Constants.TAX);
        String total = CheckoutFunction.getTotal();
        softAssertions.assertThat(total).isEqualTo(Constants.TOTAL);
        CheckoutFunction.clickFinishButton();
        String successMessage = CheckoutFunction.getSuccessMessage();
        softAssertions.assertThat(successMessage).isEqualTo(Constants.SUCCESS_MESSAGE);

    }


}
