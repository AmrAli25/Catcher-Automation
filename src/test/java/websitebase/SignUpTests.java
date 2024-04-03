package websitebase;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.JsonFileManager;
import utils.TestngListener;

import static org.testng.Assert.assertEquals;
import static utils.Helper.getCurrentTimeStamp;

@Epic("Catcher Website")
@Feature("User Management")
@Story("Register")
@Listeners(TestngListener.class)
public class SignUpTests extends BaseTest {
    private JsonFileManager testData;

    @Test(description = "Sign up using valid credentials")
    @Description("new user enters his valid credentials, then enter the OTP send on his email provided then successfully redirected to homepage after verifying his email")
    public void successfulSignupAndSignOut() {
        var signInPage = homePage.clickLoginBtn();
        var signUpPage = signInPage.clickSignUpBtn();
        String email = testData.getTestData("userSignUp.email") + getCurrentTimeStamp() + "@" + testData.getTestData("userSignUp.emailDomain");

        signUpPage.enterSignUpCredentials(testData.getTestData("userSignUp.firstName"), testData.getTestData("userSignUp.lastName"), email, testData.getTestData("userSignUp.password")).clickSubmitBtn().enterOtp(testData.getTestData("userSignUp.otp"));

        var profilePage = homePage.clickProfilePage();
        assertEquals(profilePage.getEmail(), email, "Wrong email address");

    }

    // Configuration for Test class//


    @BeforeClass
    public void classSetup() {
        testData = new JsonFileManager("src/test/java/resources/testData.json");
    }


}
