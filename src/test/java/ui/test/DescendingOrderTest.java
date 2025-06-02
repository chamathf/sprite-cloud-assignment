package ui.test;

import org.assertj.core.api.SoftAssertions;
import org.common.Constants;
import org.function.ItemSearchFunction;
import org.function.LoginFunction;
import org.testng.annotations.Test;
import ui.base.BaseUITest;

public class DescendingOrderTest extends BaseUITest {

    // This test case verifies that products are sorted in descending order (Z to A)

    @Test
    public void ProductDescendingSortValidateTest() throws InterruptedException {

        SoftAssertions softAssertions = new SoftAssertions();
        LoginFunction.enterUserName(Constants.USER_NAME);
        LoginFunction.enterPassword(Constants.PASSWORD);
        LoginFunction.clickLoginButton();
        ItemSearchFunction.clickFilterDropDown(Constants.FILTER_TYPE);
        ItemSearchFunction.validateProductsAreSortedDescending();
        boolean isSorted = ItemSearchFunction.validateProductsAreSortedDescending();
        softAssertions.assertThat(isSorted)
                .as("Verify products are sorted in descending order (Z to A)")
                .isTrue();
        softAssertions.assertAll();


    }

}
