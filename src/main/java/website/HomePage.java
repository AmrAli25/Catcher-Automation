package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;

public class HomePage {

    private static WebDriver driver;
    private final By loginBtn = By.cssSelector("a[title=\"Login\"]");
    private final By profileBtn = By.cssSelector("a[title='Profile']");
    private final By product = By.xpath("//*[@id=\"top-of-page\"]/div[2]/div/section[7]/div/div[3]/div/div[1]/div[3]/div/a");
    private final By wishListBtnForProduct = By.xpath("//div[@class='home pb-4xl']/section[7]/div/div[3]/div/div/div[3]/div/div[1]/div[2]"); // xpath for product heart
    private final By wishListBtn = By.xpath("//a[@title='Wishlist']");
    private final By topPage = By.cssSelector("section[class='pt-2xl']");


    public HomePage(WebDriver driver) {
        HomePage.driver = driver;
    }

    public SignInPage clickLoginBtn(){
        explicitWait(driver,10).until(ExpectedConditions.elementToBeClickable(loginBtn));
        clickElement(loginBtn);
        return new SignInPage(driver);
    }
    public ProfilePage clickProfilePage(){
        explicitWait(driver,10).until(ExpectedConditions.elementToBeClickable(profileBtn));
        clickElement(profileBtn);
        return new ProfilePage(driver);
    }

    public Boolean checkSignInIcon(){
        explicitWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(loginBtn));
        return driver.findElement(loginBtn).isDisplayed();
    }
    public Boolean checkSignInSuccessful(){
        explicitWait(driver,10).until(ExpectedConditions.elementToBeClickable(profileBtn));
        return driver.findElement(profileBtn).isDisplayed();
    }
    public void scrollToElement(WebElement element){
        Actions actions = new Actions(driver);
        explicitWait(driver,30).until(ExpectedConditions.elementToBeClickable(element));
        actions.scrollToElement(element).perform();
    }
    public void addToWishList(){
        explicitWait(driver,5).until(ExpectedConditions.elementToBeClickable(topPage));
        scrollToElement(driver.findElement(product));
        explicitWait(driver,5).until(ExpectedConditions.elementToBeClickable(product));
        driver.findElement(wishListBtnForProduct).click();
    }
    public WishListPage clickWishListBtn(){
        scrollToElement(driver.findElement(topPage));
        driver.findElement(wishListBtn).click();
        return new WishListPage(driver);
    }
    private void clickElement(By element){
        driver.findElement(element).click();
    }


}
