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

    public String getProductName(){
        explicitWait(driver,5).until(ExpectedConditions.elementToBeClickable(product));
        return driver.findElement(product).getAttribute("title");
    }
}
