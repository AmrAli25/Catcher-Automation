package websitebase;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.TestngListener;

@Epic("Catcher Website")
@Feature("User Management")
@Story("Register")
@Listeners(TestngListener.class)
public class SignUpTests extends BaseTest {
    SoftAssert softAssert = new SoftAssert();


    @Test(description = "Sign up using valid credentials")
    @Description("new user enters his valid credentials, then enter the OTP send on his email provided then successfully redirected to homepage after verifying his email")
    public void successfulSignupAndSignOut() {
        var signInPage = homePage.clickLoginBtn();
        var signUpPage = signInPage.clickSignUpBtn();

        String firstName = "Amr";
        String lastName = "Ali";
        String email = randomEmailByTime();
        String password = "123456789a";

        signUpPage.enterSignUpCredentials(firstName, lastName, email, password)
                .clickSubmitBtn()
                .enterOtp("1234");

        var profilePage = homePage.clickProfilePage();
        softAssert.assertEquals(profilePage.getEmail(), email, "Wrong email address");
        softAssert.assertEquals(profilePage.getFirstName(), firstName, "Wrong first name ");
        softAssert.assertEquals(profilePage.getLastName(), lastName, "Wrong last name ");
        softAssert.assertAll();
    }


}
