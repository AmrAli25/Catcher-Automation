package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SignUpPage {

    private final WebDriver driver;
    private final By firstNameField = By.id("fname");
    private final By lastNameField = By.id("lname");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By termsCheckbox = By.id("terms");
    private final By signUpBtn = By.cssSelector("button[type='submit']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSignUpCredentials(String fName, String lName, String email, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.findElement(firstNameField).sendKeys(fName);
        driver.findElement(lastNameField).sendKeys(lName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        setTermsCheckbox();

    }

    public void setTermsCheckbox() {
        driver.findElement(termsCheckbox).click();
    }

    public OtpPage clickSubmitBtn() {
        driver.findElement(signUpBtn).click();
        return new OtpPage(driver);
    }
}
