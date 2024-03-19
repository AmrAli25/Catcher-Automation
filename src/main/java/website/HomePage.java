package website;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static utils.Helper.explicitWait;
import static utils.Helper.highlightElement;

public class HomePage {

    // Variables
    private static WebDriver driver;

    // Locators
    private final By loginBtn = By.cssSelector("a[title=\"Login\"]");
    private final By profileBtn = By.cssSelector("a[title='Profile']");
    private final By product = By.xpath("//*[@id=\"top-of-page\"]/div[2]/div/section[7]/div/div[3]/div/div[1]/div[3]/div/a");
    private final By wishListBtn = By.xpath("//a[@title='Wishlist']");
    private final By topPage = By.cssSelector("section[class='pt-2xl']");
    private By wishListBtnForProduct = By.xpath("//div[@class='home pb-4xl']/section[7]/div/div[3]/div/div/div[3]/div/div[1]/div[2]"); // xpath for product heart

    // Constructor
    public HomePage(WebDriver driver) {
        HomePage.driver = driver;
    }

    @Step("Click on login button located in the header")
    public SignInPage clickLoginBtn() {
        explicitWait(driver, 10).until(ExpectedConditions.elementToBeClickable(loginBtn));
        highlightElement(driver, driver.findElement(loginBtn));
        clickElement(loginBtn);
        return new SignInPage(driver);
    }

    @Step("Click on profile button from the header")
    public ProfilePage clickProfilePage() {
        explicitWait(driver, 10).until(ExpectedConditions.elementToBeClickable(profileBtn));
        clickElement(profileBtn);
        return new ProfilePage(driver);
    }

    @Step("Validate successful login")
    public Boolean checkSignInIcon() {
        explicitWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(loginBtn));
        return driver.findElement(loginBtn).isDisplayed();
    }

    @Step("Scroll to element")
    public void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        explicitWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
        actions.scrollToElement(element).perform();
    }

    @Step("Add item to the wishlist")
    public String addToWishList() {
        explicitWait(driver, 5).until(ExpectedConditions.elementToBeClickable(topPage));
        scrollToElement(driver.findElement(product));
        highlightElement(driver, driver.findElement(product));
        explicitWait(driver, 5).until(ExpectedConditions.elementToBeClickable(product));
        wishListBtnForProduct = offerLabelCheck(wishListBtnForProduct);
        highlightElement(driver, driver.findElement(wishListBtnForProduct));
        driver.findElement(wishListBtnForProduct).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(product).getAttribute("title");
    }

    @Step("Go to the Wishlist")
    public WishListPage clickWishListBtn() {
        scrollToElement(driver.findElement(topPage));
        highlightElement(driver, driver.findElement(wishListBtn));
        driver.findElement(wishListBtn).click();
        return new WishListPage(driver);
    }

    private void clickElement(By element) {
        driver.findElement(element).click();
    }

    @Step("Validate the product added to wishlist")
    private By offerLabelCheck(By wishListBtnForProduct) {
        String text = driver.findElement(wishListBtnForProduct).getText();
        if (text.contains("% Off")) {
            wishListBtnForProduct = By.xpath("//div[@class='home pb-4xl']/section[7]/div/div[3]/div/div/div[3]/div/div[1]/div[3]");
            return wishListBtnForProduct;
        } else return wishListBtnForProduct;
    }

    // this a test to use the relative locators in selenium 4 with footer
//    public void getPaymentMethodsFromFooter(){
//        By catcherLogoFooter = By.xpath("//div[@class='theFooter-logo']");
//        WebElement footerLogo = driver.findElement(catcherLogoFooter);
//        List<WebElement> payments = driver.findElements(RelativeLocator.with(By.tagName("img")).below(footerLogo));
//        payments.forEach(element -> highlightElement(driver,element));
//        payments.forEach(element -> System.out.println(element.getAttribute("alt")));
//
//    }

}
