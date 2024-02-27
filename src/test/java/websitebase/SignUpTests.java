package websitebase;

import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUpTests extends BaseTest {

    @Test
    public void successfulSignupAndSignOut() {
        var signInPage = homePage.clickLoginBtn();
        var signUpPage = signInPage.clickSignUpBtn();

        String firstName = "Amr";
        String lastName = "Ali";
        String email = randomEmailByTime();
        String password = "123456789a";

        signUpPage.enterSignUpCredentials(firstName, lastName, email, password);
        var otpPage = signUpPage.clickSubmitBtn();
        otpPage.enterOtp("1234");
        var profilePage = homePage.clickProfilePage();
        profilePage.clickSignOut();
         boolean icon = homePage.checkSignInIcon();
        assertTrue(icon, "Something went wrong");
    }
}
