package dashboard;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;


public class DashboardSignInPage {
    // Variables
    private WebDriver driver;

    // Locators
    private final By userNameField = By.id("login_username");
    private final By passwordField = By.id("login_password");
    private final By loginBtn = By.cssSelector("button[type='submit']");

    // Constructor
    public DashboardSignInPage(WebDriver driver) {
        this.driver = driver;
    }

    ///////////////////////// Actions \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Step("Enter Sign in credential")
    public void enterSignInCredential(String userName, String password){
        explicitWait(driver, 5).until(ExpectedConditions.elementToBeClickable(userNameField));
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Click login button")
    public DashboardHomePage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return new DashboardHomePage(driver);
    }

}
