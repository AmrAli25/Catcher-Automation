package gui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static utils.Helper.explicitWait;

public class OtpPage {

    // Locators
    private final By otpInput = By.cssSelector("input[type='number']");
    private final By submitBtn = By.cssSelector("button[type='submit']");
    // Variables
    private final WebDriver driver;

    // Constructor
    public OtpPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter Valid OTP")
    public HomePage enterOtp(String otp) {
        explicitWait(driver, 10).until(ExpectedConditions.elementToBeClickable(otpInput));
        List<WebElement> otpFields = driver.findElements(otpInput);
        int i = 0;
        for (WebElement otpField : otpFields) {
            char digit = otp.charAt(i);
            otpField.sendKeys(String.valueOf(digit));
            i++;
        }
        return clickSubmitBtn();

    }

    @Step("Click submit button")
    public HomePage clickSubmitBtn() {
        driver.findElement(submitBtn).click();
        return new HomePage(driver);
    }
}
