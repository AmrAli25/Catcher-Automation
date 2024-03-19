package website;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;

public class ProfilePage {

    // Locators
    private final By firstName = By.id("fname");
    private final By lastName = By.id("lname");
    private final By email = By.id("email");
    private final By signOutBtn = By.cssSelector("a[title='Sign out']");
    // Variables
    private final WebDriver driver;

    // Constructor
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Validate First Name")
    public String getFirstName() {
        return driver.findElement(firstName).getAttribute("value");
    }

    @Step("Validate Last Name")
    public String getLastName() {
        return driver.findElement(lastName).getAttribute("value");
    }

    @Step("Validate Email address")
    public String getEmail() {
        return driver.findElement(email).getAttribute("value");
    }

    @Step("Click sign out button")
    public void clickSignOut() {
        explicitWait(driver, 1).until(ExpectedConditions.elementToBeClickable(signOutBtn));
        driver.findElement(signOutBtn).click();
    }
}
