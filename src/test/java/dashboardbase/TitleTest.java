package dashboardbase;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TitleTest extends BaseTests {

    @Test
    public void getPageTitle(){
        dashboardSignInPage.enterSignInCredential("superadmin", "superadmin");
        var dashboardHomePage = dashboardSignInPage.clickLoginBtn();
        String title = dashboardHomePage.getHomePageTitle();
        assertEquals(title,"Vendure", "Wrong title is found");
    }
}
