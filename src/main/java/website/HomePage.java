package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private By loginBtn = By.cssSelector("a[title=\"Login\"]");
    private By profileBtn = By.cssSelector("a[title='Profile']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }



    public SignInPage clickLoginBtn(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        clickElement(loginBtn);
        return new SignInPage(driver);
    }
    public ProfilePage clickProfilePage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));
        clickElement(profileBtn);
        return new ProfilePage(driver);
    }

    public Boolean checkSignOut(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        return driver.findElement(loginBtn).isDisplayed();
    }

    private void clickElement(By element){
        driver.findElement(element).click();
    }

}
