package websitebase;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import website.HomePage;

import java.time.Duration;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        goToHomePage();
        homePage = new HomePage(driver);


    }

    @BeforeMethod
    public void goToHomePage(){
        driver.get("https://staging.catcher.sa/en");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public String randomEmail(){
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

}
