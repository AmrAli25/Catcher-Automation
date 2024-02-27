package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final By loginBtn = By.cssSelector("a[title=\"Login\"]");
    private final By profileBtn = By.cssSelector("a[title='Profile']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage clickLoginBtn(){
        explicitWait(5).until(ExpectedConditions.elementToBeClickable(loginBtn));
        clickElement(loginBtn);
        return new SignInPage(driver);
    }
    public ProfilePage clickProfilePage(){
        explicitWait(7).until(ExpectedConditions.elementToBeClickable(profileBtn));
        clickElement(profileBtn);
        return new ProfilePage(driver);
    }

    public Boolean checkSignInIcon(){
        explicitWait(5).until(ExpectedConditions.presenceOfElementLocated(loginBtn));
        return driver.findElement(loginBtn).isDisplayed();
    }

    private void clickElement(By element){
        driver.findElement(element).click();
    }

    private WebDriverWait explicitWait(long duration){
        return new WebDriverWait(driver,Duration.ofSeconds(duration));
    }
    private void implicitWait(long seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

}
