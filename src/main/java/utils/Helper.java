package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {

    public static WebDriverWait explicitWait(WebDriver driver, long timeInSec){
        return new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
    }
    private void implicitWait(WebDriver driver, long timeInSec){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSec));
    }
}
