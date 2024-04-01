package website;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;
import static utils.Helper.highlightElement;

public class SingleProductPage {
    // Variables
    private final WebDriver driver;

    // Locators
    private final By addToCartBtn = By.cssSelector("button[class='btn btn-primary rounded-pill px-4 d-flex align-items-center w-100 h-100 text-nowrap justify-content-center pt-e4 pb-e4']");
    private final By cartBtn = By.cssSelector("li[class='d-none d-md-flex']");
    private final By cartQuantity = By.cssSelector("span[class='theHeader-nav-icon-num']");

    // Constructor
    public SingleProductPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Add item to the cart")
    public SingleProductPage addItemToCart() {
        explicitWait(driver, 10).until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        highlightElement(driver, driver.findElement(addToCartBtn));
        return this;
    }

    @Step("Go to user Cart")
    public CartPage goToCart() {
        explicitWait(driver, 10).until(ExpectedConditions.textToBe(cartQuantity, "1"));
        driver.findElement(cartBtn).click();
        return new CartPage(driver);
    }


}
