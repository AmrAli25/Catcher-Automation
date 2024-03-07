package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;
import static utils.Helper.highlightElement;

public class SignInPage {

    private WebDriver driver;
    private By signUpBtn = By.cssSelector("a[title=\"Sign up\"]");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage clickSignUpBtn(){
        explicitWait(driver,5).until(ExpectedConditions.elementToBeClickable(signUpBtn));
        driver.findElement(signUpBtn).click();
        return new SignUpPage(driver);
    }

    public void enterLoginCredential(String email, String password){
        explicitWait(driver,10).until(ExpectedConditions.elementToBeClickable(emailField));
        highlightElement(driver, driver.findElement(emailField));
        driver.findElement(emailField).sendKeys(email);
        highlightElement(driver, driver.findElement(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage clickLoginButton(){
        explicitWait(driver,5).until(ExpectedConditions.elementToBeClickable(loginBtn));
        highlightElement(driver, driver.findElement(loginBtn));
        driver.findElement(loginBtn).click();
        explicitWait(driver,10).until(ExpectedConditions.urlToBe("https://staging.catcher.sa/en"));
        return new HomePage(driver);
    }


}
