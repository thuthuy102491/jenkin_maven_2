package pageObjects;

import PageObjectsUI.EditCustomerUI;
import PageObjectsUI.NewCustomerUI;
import commons.PageActions;
import org.openqa.selenium.WebDriver;

public class EditCustomerPageObject extends PageActions {
    WebDriver driver;

    public EditCustomerPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterCustomerID(String customerID) {
        waitForElementVisible(driver, EditCustomerUI.CUSTOMER_ID);
        sendkeyToElement(driver, EditCustomerUI.CUSTOMER_ID, customerID);
    }

    public void clickSubmitButton() {
        waitForElementClickable(driver, EditCustomerUI.SUBMIT_BUTTON);
        clickToElement(driver, EditCustomerUI.SUBMIT_BUTTON);
    }
}
