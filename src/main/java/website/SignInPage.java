package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SignInPage {

    private WebDriver driver;
    private By signUpBtn = By.cssSelector("a[title=\"Sign up\"]");
    private By catcherLogo = By.xpath("//div[@class='authPage-logo']/a[@title='Catcher']");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage clickSignUpBtn(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.findElement(signUpBtn).click();
        return new SignUpPage(driver);
    }
}
