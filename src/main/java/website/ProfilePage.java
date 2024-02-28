package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static utils.Helper.explicitWait;

public class ProfilePage {

    private WebDriver driver;
    private By firstName = By.id("fname");
    private By lastName = By.id("lname");
    private By email = By.id("email");
    private By signOutBtn = By.cssSelector("a[title='Sign out']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }



    public String getFirstName(){
        return driver.findElement(firstName).getAttribute("value");
    }
    public String getLastName(){
        return driver.findElement(lastName).getAttribute("value");
    }
    public String getEmail(){
        return driver.findElement(email).getAttribute("value");
    }
    public void clickSignOut(){
       explicitWait(driver,1).until(ExpectedConditions.elementToBeClickable(signOutBtn));
        driver.findElement(signOutBtn).click();
    }
}
