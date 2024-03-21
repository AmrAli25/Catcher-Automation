package dashboardbase;

import dashboard.DashboardSignInPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    protected DashboardSignInPage dashboardSignInPage;
    private WebDriver driver;

    @Step("Open the dashboard URL")
    public DashboardSignInPage goToSignInPage() {
        driver.get("https://staging-api.catcher.sa/admin/login");
        return new DashboardSignInPage(driver);
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver(getChromeOptions());
        dashboardSignInPage = goToSignInPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // Add options to chrome before starting
    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }
}
