package websitebase;

import gui.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.EventListenerManger;

public class BaseTest {

    protected HomePage homePage;
    private WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = createWebDriverWithListener(new ChromeDriver(getChromeOptions()));
        homePage = goToHomePage();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Step("Navigate to the HomePage")
    public HomePage goToHomePage() {
        driver.get("http://43.205.206.91/en");
        return new HomePage(driver);
    }

    private WebDriver createWebDriverWithListener(WebDriver driver) {
        EventListenerManger eventListener = new EventListenerManger();
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(eventListener);
        return decorator.decorate(driver);
    }

    // Add options to chrome before starting
    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"/*,"--headless=new"*/);
        return options;
    }

    // Create a random mail using current time signature
//    public String randomEmailByTime() {
//        String dateFormat = "yyyyMMddHHmmss";
//        String currentTime = new SimpleDateFormat(dateFormat).format(new Date());
//        return "test" + currentTime + "@test.com";
//    }


}
