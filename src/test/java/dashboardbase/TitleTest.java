package dashboardbase;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Epic("Catcher Dashboard")
@Feature("Admin management")
@Story("Login")
public class TitleTest extends BaseTests {

    @Test(description = "Login admin Test - GUI Dashboard")
    @Description("Entering valid login credential for admin dashboard and successfully redirected to the homepage of the dashboard ")
    public void getPageTitle() {

        dashboardSignInPage.enterSignInCredential("superadmin", "superadmin");
        var dashboardHomePage = dashboardSignInPage.clickLoginBtn();
        String title = dashboardHomePage.getHomePageTitle();
        assertEquals(title, "Catcher", "Wrong title is found");
    }
}
