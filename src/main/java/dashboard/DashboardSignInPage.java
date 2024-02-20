package dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardSignInPage {

    private WebDriver driver;
    private By userNameField = By.id("login_username");
    private By passwordField = By.id("login_password");
    private By loginBtn = By.cssSelector("button[type='submit']");

    public DashboardSignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSignInCredential(String userName, String password){
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(password);
    }

    public DashboardHomePage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return new DashboardHomePage(driver);
    }

}
