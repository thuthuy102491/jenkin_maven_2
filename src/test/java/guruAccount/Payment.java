package guruAccount;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Payment extends BaseTest {
    private WebDriver driver;
    private String browserName;
    private String username, password;
    private LoginPageObject loginPage;
    private HomePageObject homePageObject;
    private NewCustomerPageObject newCustomerPageObject;
    private String customerName, dateOfBirth, address, city, state, pin, mobileNumber, email;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        this.browserName = browserName;

        username = "mngr588721";
        password = "AmubAdE";
        customerName = "AUTOMATION TESTING";
        dateOfBirth = "01/01/1989";
        address = "PO Box 911 8331 Duis Avenue";
        city = "Tampa";
        state = "FL";
        pin = "466250";
        mobileNumber = "4555442476";
        email = "auto@gmail.com";
        customerID = "46289";

        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePageObject = loginPage.loginToThePage(username, password);
    }

    @Test
    public void Test_01_Create_Customer_Account(Method method) throws InterruptedException {
        ExtentTestManager.startTest(method.getName() + "Run on" + browserName.toUpperCase(), "Test_01_Create_Customer_Account");
        newCustomerPageObject = homePageObject.openNewCustomerPage();

        newCustomerPageObject.enterCustomerName(customerName);
        newCustomerPageObject.enterCustomerDateOfBirth(dateOfBirth);
        newCustomerPageObject.enterCustomerAddress(address);
        newCustomerPageObject.enterCustomerCity(city);
        newCustomerPageObject.enterCustomerPIN(pin);
        newCustomerPageObject.enterCustomerState(state);
        newCustomerPageObject.enterCustomerMobileNumber(mobileNumber);
        newCustomerPageObject.enterCustomerEmail(email);
        newCustomerPageObject.clickSubmitButton();

        newCustomerPageObject.waitForAlertPresence(driver);
        Assert.assertEquals(newCustomerPageObject.getAlertText(driver), "please fill all fields");
        newCustomerPageObject.acceptAlert(driver);
    }

    @Test
    public void Test_02_Edit_Customer_Account(Method method) throws InterruptedException {
        ExtentTestManager.startTest(method.getName() + " Run on " + browserName.toUpperCase(), "Test_02_Edit_Customer_Account");
        editCustomerPageObject = newCustomerPageObject.clickEditCustomerMenu();
        editCustomerPageObject.enterCustomerID(customerID);
        editCustomerPageObject.clickSubmitButton();

        editCustomerPageObject.acceptAlert(driver);
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

    EditCustomerPageObject editCustomerPageObject;
    private String customerID;
}
