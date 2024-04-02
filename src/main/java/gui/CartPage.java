package gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;

public class CartPage {
    //Locators
    private final By productName = By.cssSelector("h4[class='cardCart-title mb-3']");
    // Variables
    private final WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return explicitWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(productName)).getText();
    }
}
