package websitebase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.EventListenerManger;
import website.HomePage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        driver = createWebDriverWithListener(new ChromeDriver(getChromeOptions()));

        homePage = goToHomePage();
    }


    public HomePage goToHomePage(){
        driver.get("https://staging.catcher.sa/en");
        return new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

//    @Test                              // this for testing relative locators using selenium 4
//    public void testRelativeLocators(){
//        homePage.getPaymentMethodsFromFooter();
//    }

    // Create a random mail using current time signature
    public String randomEmailByTime(){
        String dateFormat = "yyyyMMddHHmmss";
        String currentTime = new SimpleDateFormat(dateFormat).format(new Date());
        return "test" + currentTime + "@test.com";
    }


    // Add options to chrome before starting
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }

    private WebDriver createWebDriverWithListener(WebDriver driver){
        EventListenerManger eventListener = new EventListenerManger();
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(eventListener);
        return decorator.decorate(driver);
    }



}
