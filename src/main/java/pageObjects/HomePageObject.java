package pageObjects;

import PageObjectsUI.HomePageUI;
import commons.PageActions;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends PageActions {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public NewCustomerPageObject openNewCustomerPage() {
        waitForElementVisible(driver, HomePageUI.NEW_CUSTOMER_MENU_ITEM);
        clickToElement(driver, HomePageUI.NEW_CUSTOMER_MENU_ITEM);
        return new NewCustomerPageObject(driver);
    }
}
