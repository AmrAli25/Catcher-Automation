package dashboardbase;

import dashboard.DashboardSignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTests {
    private WebDriver driver;
    protected DashboardSignInPage dashboardSignInPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        goToSignInPage();
        dashboardSignInPage = new DashboardSignInPage(driver);
    }

    @BeforeMethod
    public void goToSignInPage(){
        driver.get("https://staging-api.catcher.sa/admin/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
