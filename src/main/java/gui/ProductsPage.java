package gui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static utils.Helper.explicitWait;
import static utils.Helper.highlightElement;

public class ProductsPage {

    // Locators
    private final By productCard = By.cssSelector("a[class='cardMain-url']");
    //Variables
    private final WebDriver driver;

    // Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Find all the products in the page and get one")
    public WebElement selectProduct(String productName) {
        explicitWait(driver, 10).until(ExpectedConditions.elementToBeClickable(productCard));
        List<WebElement> products = driver.findElements(productCard);
        for (WebElement product : products) {
            if (product.getAttribute("title").equals(productName)) {
                Actions actions = new Actions(driver);
                actions.scrollToElement(product);
                highlightElement(driver, product);
                return product;
            }
        }
        return products.getFirst();
    }

    @Step("Click the Selected product and go to single product page")
    public SingleProductPage clickSelectedProduct(String productName) {
        selectProduct(productName).click();
        return new SingleProductPage(driver);
    }

     //ToDo: Build a new scenario to choose a filter and apply it to the products and check the products range
}
