package utils;

import org.openqa.selenium.WebDriver;

public class WindowManger {

    private final WebDriver driver;

    public WindowManger(WebDriver driver) {
        this.driver = driver;
    }

    public void goBack(){
        driver.navigate().back();
    }
    public void goForward(){
        driver.navigate().forward();
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
    public void goTo(String url){
        driver.navigate().to(url);
    }
    public void switchToTab(String tabTitle){
        var windows = driver.getWindowHandles();
        for(String window : windows){
            driver.switchTo().window(window);
            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }

    }

}
