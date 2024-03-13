package website;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static utils.Helper.explicitWait;
import static utils.Helper.highlightElement;

public class WishListPage {

    private final WebDriver driver;
    private final By FavBtn = By.xpath("//div[@class='cardMain-header-fav']");
    private final By listBar = By.xpath("//ul[@class='appBreadcrumbs fs-xs']/li[2]");

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName(String productTitle) {
        explicitWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(listBar));
        By product = By.xpath("//a[@title='" + productTitle + "']");
        explicitWait(driver, 10).until(ExpectedConditions.elementToBeClickable(product));


        highlightElement(driver, driver.findElement(product));

        return driver.findElement(product).getAttribute("title");
    }

    public void toggleFavBtn() {
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
            System.out.println("OOOOOOOOOOOoOOOoooooooooooOOOOOOOOOOOoOOOoOOOOOO");
        }
        System.out.println("********** All products is removed from the wishlist **********");
    }
}
