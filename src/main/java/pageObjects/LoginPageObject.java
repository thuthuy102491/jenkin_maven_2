package pageObjects;

import PageObjectsUI.LoginPageUI;
import commons.PageActions;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends PageActions {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterUsernameToTextbox(String username) {
        waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, username);
    }

    public void enterPasswordToTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    public HomePageObject loginToThePage(String username, String password) {
        enterUsernameToTextbox(username);
        enterPasswordToTextbox(password);
        clickToLoginButton();
        return PageGeneratorManager.getHomePage(driver);
    }
}
