package websitebase;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.EventListenerManger;
import website.HomePage;

import java.text.SimpleDateFormat;
import java.time.Duration;
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

    // Create a random mail using current time signature
    public String randomEmailByTime(){
        String dateFormat = "yyyyMMddHHmmss";
        String currentTime = new SimpleDateFormat(dateFormat).format(new Date());
        return "test" + currentTime + "@test.com";
    }

    // Create a random mail using Faker package
    public String randomEmailByFaker(){
        Faker faker = new Faker();
        return faker.internet().emailAddress();
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
