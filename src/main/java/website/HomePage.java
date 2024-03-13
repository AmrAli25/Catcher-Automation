package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static utils.Helper.explicitWait;
import static utils.Helper.highlightElement;

public class HomePage {

    private static WebDriver driver;
    private final By loginBtn = By.cssSelector("a[title=\"Login\"]");
    private final By profileBtn = By.cssSelector("a[title='Profile']");
    private final By product = By.xpath("//*[@id=\"top-of-page\"]/div[2]/div/section[7]/div/div[3]/div/div[1]/div[3]/div/a");
    private final By wishListBtnForProduct = By.xpath("//div[@class='home pb-4xl']/section[7]/div/div[3]/div/div/div[3]/div/div[1]/div[3]"); // xpath for product heart
    private final By wishListBtn = By.xpath("//a[@title='Wishlist']");
    private final By topPage = By.cssSelector("section[class='pt-2xl']");


    public HomePage(WebDriver driver) {
        HomePage.driver = driver;
    }

    public SignInPage clickLoginBtn() {
        explicitWait(driver, 10).until(ExpectedConditions.elementToBeClickable(loginBtn));
        highlightElement(driver, driver.findElement(loginBtn));
        clickElement(loginBtn);
        return new SignInPage(driver);
    }

    public ProfilePage clickProfilePage() {
        explicitWait(driver, 10).until(ExpectedConditions.elementToBeClickable(profileBtn));
        clickElement(profileBtn);
        return new ProfilePage(driver);
    }

    public Boolean checkSignInIcon() {
        explicitWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(loginBtn));
        return driver.findElement(loginBtn).isDisplayed();
    }

    public void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        explicitWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
        actions.scrollToElement(element).perform();
    }

    public String addToWishList() {
        explicitWait(driver, 5).until(ExpectedConditions.elementToBeClickable(topPage));
        scrollToElement(driver.findElement(product));
        highlightElement(driver, driver.findElement(product));
        explicitWait(driver, 5).until(ExpectedConditions.elementToBeClickable(product));
        highlightElement(driver, driver.findElement(wishListBtnForProduct));
        driver.findElement(wishListBtnForProduct).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(product).getAttribute("title");
    }

    public WishListPage clickWishListBtn() {
        scrollToElement(driver.findElement(topPage));
        highlightElement(driver, driver.findElement(wishListBtn));
        driver.findElement(wishListBtn).click();
        return new WishListPage(driver);
    }

    private void clickElement(By element) {
        driver.findElement(element).click();
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
