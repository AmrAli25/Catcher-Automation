package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SignUpPage {

    private WebDriver driver;
    private By firstNameField = By.id("fname");
    private By lastNameField = By.id("lname");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By termsCheckbox = By.id("terms");
    private By signUpBtn = By.cssSelector("button[type='submit']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSignUpCredentials(String fName, String lName, String email, String password){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.findElement(firstNameField).sendKeys(fName);
        driver.findElement(lastNameField).sendKeys(lName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        setTermsCheckbox();

    }
    public void setTermsCheckbox(){
        driver.findElement(termsCheckbox).click();
    }

    public OtpPage clickSubmitBtn(){
        driver.findElement(signUpBtn).click();
        return new OtpPage(driver);
    }
}
