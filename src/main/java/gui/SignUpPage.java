package gui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;

public class SignUpPage {

    // Locators
    private final By firstNameField = By.id("fname");
    private final By lastNameField = By.id("lname");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By termsCheckbox = By.id("terms");
    private final By signUpBtn = By.cssSelector("button[type='submit']");
    // Variables
    private WebDriver driver;

    // Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter valid user credential to Sign up")
    public SignUpPage enterSignUpCredentials(String fName, String lName, String email, String password) {
        explicitWait(driver, 10).until(ExpectedConditions.elementToBeClickable(firstNameField));
        driver.findElement(firstNameField).sendKeys(fName);
        driver.findElement(lastNameField).sendKeys(lName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(termsCheckbox).click();
        return this;
    }


    @Step("Click submit button")
    public OtpPage clickSubmitBtn() {
        driver.findElement(signUpBtn).click();
        return new OtpPage(driver);
    }
}
