package dashboard;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DashboardHomePage {

    // Variables
    private WebDriver driver;

    // Constructor
    public DashboardHomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate the Dashboard Title")
    public String getHomePageTitle(){
        return driver.getTitle();
    }
}
