package websitebase;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUpTests extends BaseTest {


    @Test(testName = "Sign up and check the data in the profile page then logout")
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
        assertEquals(profilePage.getEmail(), email, "Wrong email address");
        assertEquals(profilePage.getFirstName(), firstName, "Wrong first name ");
        assertEquals(profilePage.getLastName(), lastName, "Wrong last name ");
        profilePage.clickSignOut();
         boolean icon = homePage.checkSignInIcon();
        assertTrue(icon, "Something went wrong");
    }
}
