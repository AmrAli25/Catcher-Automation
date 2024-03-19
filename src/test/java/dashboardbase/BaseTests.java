package dashboardbase;

import dashboard.DashboardSignInPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {
    protected DashboardSignInPage dashboardSignInPage;
    private WebDriver driver;

    @Step("Open the dashboard URL")
    public DashboardSignInPage goToSignInPage() {
        driver.get("https://staging-api.catcher.sa/admin/login");
        return new DashboardSignInPage(driver);
    }

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        dashboardSignInPage = goToSignInPage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
