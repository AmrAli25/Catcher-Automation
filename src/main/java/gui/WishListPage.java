package gui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static utils.Helper.explicitWait;
import static utils.Helper.highlightElement;

public class WishListPage {

    // Variables
    private final WebDriver driver;
    // Locators
    private final By FavBtn = By.xpath("//div[@class='cardMain-header-fav']");
    private final By listBar = By.xpath("//ul[@class='appBreadcrumbs fs-xs']/li[2]");

    // Constructor
    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate product name ")
    public String getProductName(String productTitle) {
        explicitWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(listBar));
        By product = By.xpath("//a[@title='" + productTitle + "']");
        explicitWait(driver, 10).until(ExpectedConditions.elementToBeClickable(product));


        highlightElement(driver, driver.findElement(product));

        return driver.findElement(product).getAttribute("title");
    }

    @Step("Remove all items form the wishlist ")
    public WishListPage toggleFavBtn() {
        explicitWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(listBar));
        List<WebElement> elements = driver.findElements(FavBtn);
        try {
//            elements.forEach(WebElement::click);
            for (WebElement element : elements) {
                highlightElement(driver, element);
                element.click();
                explicitWait(driver, 10).until(ExpectedConditions.invisibilityOf(element));
            }
        } catch (StaleElementReferenceException e) {
            e.getLocalizedMessage();
        }
        System.out.println("********** All products is removed from the wishlist **********");
        return this;
    }
}
