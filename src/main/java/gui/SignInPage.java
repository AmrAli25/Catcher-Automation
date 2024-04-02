package gui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;
import static utils.Helper.highlightElement;

public class SignInPage {

    // Locators
    private final By signUpBtn = By.cssSelector("a[title=\"Sign up\"]");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By loginBtn = By.cssSelector("button[type='submit']");
    // Variables
    private final WebDriver driver;

    // Constructor
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click Sign up button in the header")
    public SignUpPage clickSignUpBtn() {
        explicitWait(driver, 10).until(ExpectedConditions.elementToBeClickable(signUpBtn));
        driver.findElement(signUpBtn).click();
        return new SignUpPage(driver);
    }

    @Step("Enter valid user credential to login")
    public SignInPage enterLoginCredential(String email, String password) {
        explicitWait(driver, 10).until(ExpectedConditions.elementToBeClickable(emailField));
        highlightElement(driver, driver.findElement(emailField));
        driver.findElement(emailField).sendKeys(email);
        highlightElement(driver, driver.findElement(passwordField));
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Click login button")
    public HomePage clickLoginButton() {
        explicitWait(driver, 5).until(ExpectedConditions.elementToBeClickable(loginBtn));
        highlightElement(driver, driver.findElement(loginBtn));
        driver.findElement(loginBtn).click();
        explicitWait(driver, 10).until(ExpectedConditions.urlToBe("https://staging.catcher.sa/en"));
        return new HomePage(driver);
    }


}
