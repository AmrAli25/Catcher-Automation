package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static java.lang.System.in;

public class OtpPage {

    private WebDriver driver;
    private By otpInput = By.cssSelector("input[type='number']");
    private By submitBtn = By.cssSelector("button[type='submit']");

    public OtpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterOtp(String otp){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        List<WebElement> otpFields = driver.findElements(otpInput);
        int i = 0;
        for(WebElement otpField : otpFields){
            char digit = otp.charAt(i);
            otpField.sendKeys(String.valueOf(digit));
            i++;
        }
        clickSubmitBtn();

    }

    public HomePage clickSubmitBtn(){
        driver.findElement(submitBtn).click();
        return new HomePage(driver);
    }
}
