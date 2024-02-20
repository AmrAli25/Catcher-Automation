package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProfilePage {

    private WebDriver driver;
    private By firstName = By.id("fname");
    private By lastName = By.id("lname");
    private By email = By.id("email");
    private By signOutBtn = By.cssSelector("a[title='Sign out']");
    private By editBtn = By.xpath("//*[@id=\"top-of-page\"]/div[2]/div/section/div/div/div[2]/div/div/div/div");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }



    public String getFirstName(){
        return driver.findElement(firstName).getText();
    }
    public String getLastName(){
        return driver.findElement(lastName).getText();
    }
    public String getEmail(){
        return driver.findElement(email).getText();
    }
    public SignInPage clickSignOut(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.findElement(signOutBtn).click();
        return new SignInPage(driver);
    }
}
