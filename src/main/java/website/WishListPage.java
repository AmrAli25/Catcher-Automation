package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;

public class WishListPage {

    private WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }
    private By product = By.xpath("//a[@title='Cheap product ']");
    private By wishlistProducts = By.cssSelector("div[class='row g-2']");

    public String getProductName(){
        explicitWait(driver,5).until(ExpectedConditions.elementToBeClickable(product));
        return driver.findElement(product).getAttribute("title");
    }
    public boolean checkProductPresence(){
        explicitWait(driver,5).until(ExpectedConditions.visibilityOf(driver.findElement(wishlistProducts)));
        return driver.findElement(product).isDisplayed();
    }
}
