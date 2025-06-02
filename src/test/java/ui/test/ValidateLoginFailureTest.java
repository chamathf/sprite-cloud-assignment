package ui.test;

import org.assertj.core.api.SoftAssertions;
import org.common.Constants;
import org.function.LoginFunction;
import org.testng.annotations.Test;
import ui.base.BaseUITest;

public class ValidateLoginFailureTest extends BaseUITest {

    /**
     * This test verifies that the login functionality with invalid credentials
     * by displaying the correct error message.
     */
    @Test
    public void ValidateLoginFailureTest() throws InterruptedException {
        SoftAssertions softAssertions = new SoftAssertions();

        LoginFunction.enterUserName(Constants.INVALID_USER_NAME);
        LoginFunction.enterPassword(Constants.INVALID_PASSWORD);
        LoginFunction.clickLoginButton();
        LoginFunction.getInvalidLoginErrorMessage();
        String InvalidLoginErrorMessage = LoginFunction.getInvalidLoginErrorMessage();
        softAssertions.assertThat(InvalidLoginErrorMessage).isEqualTo(Constants.LOGIN_ERROR_MESSAGE);
    }

}