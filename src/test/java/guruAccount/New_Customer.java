package guruAccount;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class New_Customer extends BaseTest {
    private WebDriver driver;
    private String browserName;
    private String username, password;
    private LoginPageObject loginPage;
    private HomePageObject homePageObject;
    private NewCustomerPageObject newCustomerPageObject;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        this.browserName = browserName;

        username = "mngr588721";
        password = "AmubAdE";

        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePageObject = loginPage.loginToThePage(username, password);
    }

    @Test
    public void Test_01_Verify_Name_Field(Method method) {
        ExtentTestManager.startTest(method.getName() + "Run on" + browserName.toUpperCase(), "Test_01_Verify_Name_Field");
        newCustomerPageObject = homePageObject.openNewCustomerPage();
        newCustomerPageObject.TabAndMoveToNextField("Customer Name");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("Customer Name"), "Customer name must not be blank");

        newCustomerPageObject.enterDataToNameField("1234");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("Customer Name"), "Numbers are not allowed");

        newCustomerPageObject.enterDataToNameField("name1234");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("Customer Name"), "Numbers are not allowed");

        newCustomerPageObject.enterDataToNameField("name!@#");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("Customer Name"), "Special characters are not allowed");
        newCustomerPageObject.enterDataToNameField("!@#");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("Customer Name"), "Special characters are not allowed");

        newCustomerPageObject.enterDataToNameField(" ");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("Customer Name"), "First character can not have space");
    }

    @Test
    public void Test_02_Verify_Address_Field(Method method) {
        ExtentTestManager.startTest(method.getName() + "Run on" + browserName.toUpperCase(), "Test_02_Verify_Address_Field");
        newCustomerPageObject.TabAndMoveToNextField();
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("Address"), "Address Field must not be blank");

        newCustomerPageObject.enterDataToAddressField(" ");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("Address"), "First character can not have space");
    }

    @Test
    public void Test_03_Verify_City_Field(Method method) {
        ExtentTestManager.startTest(method.getName() + "Run on" + browserName.toUpperCase(), "Test_03_Verify_City_Field");
        newCustomerPageObject.TabAndMoveToNextField("City");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("City"), "City Field must not be blank");

        newCustomerPageObject.enterDataToCityField("1234");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("City"), "Numbers are not allowed");

        newCustomerPageObject.enterDataToCityField("city1234");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("City"), "Numbers are not allowed");

        newCustomerPageObject.enterDataToCityField("city!@#");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("City"), "Special characters are not allowed");

        newCustomerPageObject.enterDataToCityField("!@#");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("City"), "Special characters are not allowed");

        newCustomerPageObject.enterDataToCityField(" ");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("City"), "First character can not have space");
    }

    @Test
    public void Test_04_Verify_State_Field(Method method) {
        ExtentTestManager.startTest(method.getName() + "Run on" + browserName.toUpperCase(), "Test_04_Verify_State_Field");
        newCustomerPageObject.TabAndMoveToNextField("State");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("State"), "State Field must not be blank");

        newCustomerPageObject.enterDataToStateField("1234");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("State"), "Numbers are not allowed");

        newCustomerPageObject.enterDataToStateField("State1234");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("State"), "Numbers are not allowed");

        newCustomerPageObject.enterDataToStateField("State!@#");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("State"), "Special characters are not allowed");

        newCustomerPageObject.enterDataToStateField("!@#");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("State"), "Special characters are not allowed");

        newCustomerPageObject.enterDataToStateField(" ");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("State"), "First character can not have space");
    }

    @Test
    public void Test_05_Verify_PIN_Field(Method method) {
        ExtentTestManager.startTest(method.getName() + "Run on" + browserName.toUpperCase(), "Test_05_Verify_PIN_Field");
        newCustomerPageObject.enterDataToPINField("1234PIN");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("PIN"), "Characters are not allowed");

        newCustomerPageObject.TabAndMoveToNextField("PIN");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("PIN"), "PIN Code must not be blank");

        newCustomerPageObject.enterDataToPINField("123");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("PIN"), "PIN Code must have 6 Digits");

        newCustomerPageObject.enterDataToPINField("12346789");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("PIN"), "PIN Code must have 6 Digits");

        newCustomerPageObject.enterDataToPINField("!@#");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("PIN"), "Special characters are not allowed");

        newCustomerPageObject.enterDataToPINField("123!@#");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("PIN"), "Special characters are not allowed");

        newCustomerPageObject.enterDataToPINField(" ");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("PIN"), "First character can not have space");

        newCustomerPageObject.enterDataToPINField("12 345");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("PIN"), "PIN cannot have space");
    }

    @Test
    public void Test_06_Verify_Mobile_Field(Method method) {
        ExtentTestManager.startTest(method.getName() + "Run on" + browserName.toUpperCase(), "Test_06_Verify_Mobile_Field");
        newCustomerPageObject.TabAndMoveToNextField("Mobile Number");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("Mobile Number"), "Mobile no must not be blank");

        newCustomerPageObject.enterDataToMobileField(" ");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("Mobile Number"), "First character can not have space");

        newCustomerPageObject.enterDataToMobileField("12 345");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("Mobile Number"), "Telephone cannot have space");

        newCustomerPageObject.enterDataToMobileField("!@#1234123");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("Mobile Number"), "Special characters are not allowed");

        newCustomerPageObject.enterDataToMobileField("1234123!@#");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("Mobile Number"), "Special characters are not allowed");

        newCustomerPageObject.enterDataToMobileField("123!@#1234");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("Mobile Number"), "Special characters are not allowed");
}

    @Test
    public void Test_07_Verify_Email_Field(Method method) {
        ExtentTestManager.startTest(method.getName() + "Run on" + browserName.toUpperCase(), "Test_07_Verify_Email_Field");
        newCustomerPageObject.TabAndMoveToNextField("E-mail");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("E-mail"), "Mobile no must not be blank");

        newCustomerPageObject.enterDataToMobileField(" ");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("E-mail"), "First character can not have space");

        newCustomerPageObject.enterDataToMobileField("guru99@gmail");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("E-mail"), "Email-ID is not valid");

        newCustomerPageObject.enterDataToMobileField("guru99");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("E-mail"), "Email-ID is not valid");

        newCustomerPageObject.enterDataToMobileField("Guru99@");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("E-mail"), "Email-ID is not valid");

        newCustomerPageObject.enterDataToMobileField("guru99@gmail.");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("E-mail"), "Email-ID is not valid");

        newCustomerPageObject.enterDataToMobileField("guru99gmail.com");
        Assert.assertEquals(newCustomerPageObject.getErrorMessage("E-mail"), "Email-ID is not valid");
    }

    @Test
    public void Test_08_Verify_Field_Label(Method method) {
        ExtentTestManager.startTest(method.getName() + "Run on" + browserName.toUpperCase(), "Test_08_Verify_Field_Label");
        Assert.assertEquals(newCustomerPageObject.getCustomerFieldName(),"Customer Name");
        Assert.assertEquals(newCustomerPageObject.getGenderFieldName(),"Gender");
        Assert.assertEquals(newCustomerPageObject.getDOBFieldName(),"Date of Birth");
        Assert.assertEquals(newCustomerPageObject.getAddressFieldName(),"Address");
        Assert.assertEquals(newCustomerPageObject.getCityFieldName(),"City");
        Assert.assertEquals(newCustomerPageObject.getStateFieldName(),"State");
        Assert.assertEquals(newCustomerPageObject.getPINFieldName(),"PIN");
        Assert.assertEquals(newCustomerPageObject.getMobileFieldName(),"Mobile Number");
        Assert.assertEquals(newCustomerPageObject.getEmailFieldName(),"E-mail");
        Assert.assertEquals(newCustomerPageObject.getPasswordFieldName(),"Password");
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
