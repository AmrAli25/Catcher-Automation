package dashboard;

import org.openqa.selenium.WebDriver;

public class DashboardHomePage {

    private WebDriver driver;

    public DashboardHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }
}
