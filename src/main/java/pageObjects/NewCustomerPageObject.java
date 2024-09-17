package pageObjects;

import PageObjectsUI.NewCustomerUI;
import commons.PageActions;
import commons.PageGeneratorManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewCustomerPageObject extends PageActions {
    WebDriver driver;

    public NewCustomerPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterCustomerName(String name) {
        waitForElementVisible(driver, NewCustomerUI.CUSTOMER_NAME);
        sendkeyToElement(driver, NewCustomerUI.CUSTOMER_NAME, name);
    }

    public void enterCustomerDateOfBirth(String date) {
        waitForElementVisible(driver, NewCustomerUI.DATE_OF_BIRTH);
        sendkeyToElement(driver, NewCustomerUI.DATE_OF_BIRTH, date);
    }

    public void enterCustomerAddress(String address) {
        waitForElementVisible(driver, NewCustomerUI.CUSTOMER_ADDRESS);
        sendkeyToElement(driver, NewCustomerUI.CUSTOMER_ADDRESS, address);
    }

    public void enterCustomerCity(String city) {
        waitForElementVisible(driver, NewCustomerUI.CUSTOMER_CITY);
        sendkeyToElement(driver, NewCustomerUI.CUSTOMER_CITY, city);
    }

    public void enterCustomerState(String state) {
        waitForElementVisible(driver, NewCustomerUI.CUSTOMER_STATE);
        sendkeyToElement(driver, NewCustomerUI.CUSTOMER_STATE, state);
    }

    public void enterCustomerPIN(String pin) {
        waitForElementVisible(driver, NewCustomerUI.CUSTOMER_PIN);
        sendkeyToElement(driver, NewCustomerUI.CUSTOMER_PIN, pin);
    }

    public void enterCustomerMobileNumber(String mobileNumber) {
        waitForElementVisible(driver, NewCustomerUI.CUSTOMER_MOBILE_NUMBER);
        sendkeyToElement(driver, NewCustomerUI.CUSTOMER_MOBILE_NUMBER, mobileNumber);
    }

    public void enterCustomerEmail(String email) {
        waitForElementVisible(driver, NewCustomerUI.CUSTOMER_EMAIL);
        sendkeyToElement(driver, NewCustomerUI.CUSTOMER_EMAIL, email);
    }

    public void clickSubmitButton() {
        waitForElementClickable(driver, NewCustomerUI.SUBMIT_BUTTON);
        clickToElement(driver, NewCustomerUI.SUBMIT_BUTTON);
    }

    public EditCustomerPageObject clickEditCustomerMenu() {
        waitForElementVisible(driver,NewCustomerUI.EDIT_CUSTOMER_MENU);
        clickToElement(driver,NewCustomerUI.EDIT_CUSTOMER_MENU);
        return new EditCustomerPageObject(driver);
    }

    public void TabAndMoveToNextField() {
        pressKeyToElement(driver, NewCustomerUI.CUSTOMER_ADDRESS, Keys.TAB);
    }

    public void TabAndMoveToNextField(String labelName) {
        pressKeyToElement(driver, NewCustomerUI.INPUT_DYNAMIC, Keys.TAB, labelName);
    }

    public String getErrorMessage(String labelName) {
        return getElementText(driver, NewCustomerUI.LABEL_DYNAMIC, labelName);
    }

    public void enterDataToNameField(String str) {
        sendkeyToElement(driver, NewCustomerUI.CUSTOMER_NAME, str);
    }

    public void enterDataToAddressField(String str) {
        sendkeyToElement(driver, NewCustomerUI.CUSTOMER_ADDRESS, str);
    }

    public void enterDataToCityField(String str) {
        sendkeyToElement(driver, NewCustomerUI.CUSTOMER_CITY, str);
    }

    public void enterDataToStateField(String str) {
        sendkeyToElement(driver, NewCustomerUI.CUSTOMER_STATE, str);
    }

    public void enterDataToPINField(String str) {
        sendkeyToElement(driver, NewCustomerUI.CUSTOMER_PIN, str);
    }

    public void enterDataToMobileField(String str) {
        sendkeyToElement(driver, NewCustomerUI.CUSTOMER_MOBILE_NUMBER, str);
    }

    public String getCustomerFieldName() {
        return getElementText(driver, NewCustomerUI.CUSTOMER_NAME_LABEL);
    }

    public String getGenderFieldName() {
        return getElementText(driver, NewCustomerUI.CUSTOMER_GENDER_LABEL);
    }

    public String getDOBFieldName() {
        return getElementText(driver, NewCustomerUI.DATE_OF_BIRTH_LABEL);
    }

    public String getAddressFieldName() {
        return getElementText(driver, NewCustomerUI.CUSTOMER_ADDRESS_LABEL);
    }

    public String getCityFieldName() {
        return getElementText(driver, NewCustomerUI.CUSTOMER_CITY_LABEL);
    }

    public String getStateFieldName() {
        return getElementText(driver, NewCustomerUI.CUSTOMER_STATE_LABEL);
    }

    public String getPINFieldName() {
        return getElementText(driver, NewCustomerUI.CUSTOMER_PIN_LABEL);
    }

    public String getMobileFieldName() {
        return getElementText(driver, NewCustomerUI.CUSTOMER_MOBILE_NUMBER_LABEL);
    }

    public String getEmailFieldName() {
        return getElementText(driver, NewCustomerUI.CUSTOMER_EMAIL_LABEL);
    }

    public String getPasswordFieldName() {
        return getElementText(driver, NewCustomerUI.CUSTOMER_PASSWORD_LABEL);
    }
}
