package commons;

import org.openqa.selenium.WebDriver;

public class PageActions extends BasePage{
    WebDriver driver;

    public PageActions(WebDriver driver) {
        this.driver = driver;
        driver.getCurrentUrl();
    }


}
