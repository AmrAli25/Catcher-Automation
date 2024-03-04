package website;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static utils.Helper.explicitWait;

public class WishListPage {

    private WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }
    private By product = By.xpath("//a[@title='Cheap product ']");
    private By wishlistProducts = By.cssSelector("div[class='row g-2']");
    private By FavBtn = By.xpath("//div[@class='cardMain-header-fav']");

    public String getProductName(){
        explicitWait(driver,10).until(ExpectedConditions.elementToBeClickable(product));
        return driver.findElement(product).getAttribute("title");
    }
    public boolean checkProductPresence(){
        explicitWait(driver,5).until(ExpectedConditions.visibilityOf(driver.findElement(wishlistProducts)));
        return driver.findElement(product).isDisplayed();
    }
    public void toggleFavBtn(){
        explicitWait(driver,10).until(ExpectedConditions.elementToBeClickable(FavBtn));
        List<WebElement> elements = driver.findElements(FavBtn);
        try {
            elements.forEach(WebElement::click);
        }
        catch (StaleElementReferenceException e){
            elements = driver.findElements(FavBtn);
            elements.forEach(WebElement::click);
        }
        System.out.println("********** All products is removed from the wishlist **********");
    }
}
