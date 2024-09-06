
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Selenium_Basic {
    private WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void Test_01() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Login or Create an Account')]")));
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Create an Account')]")));
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
    }

    @Test
    public void Test_02() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.manage().timeouts().getPageLoadTimeout();
        Assert.assertEquals(driver.getTitle(), "Customer Login");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        driver.manage().timeouts().getPageLoadTimeout();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
    }

    @Test
    public void Test_03() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.manage().timeouts().getPageLoadTimeout();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        driver.manage().timeouts().getPageLoadTimeout();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");

        driver.navigate().back();
        driver.manage().timeouts().getPageLoadTimeout();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");

        driver.navigate().forward();
        driver.manage().timeouts().getPageLoadTimeout();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
    }

    @Test
    public void Test_04() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.manage().timeouts().getPageLoadTimeout();
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        driver.manage().timeouts().getPageLoadTimeout();
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
    }

    @Test
    public void Test_05_Displayed() {
        driver.get(url);
        if (driver.findElement(By.cssSelector("input#mail")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#mail")).sendKeys("Auto");
            System.out.println("Email Textbox is displayed");
        }
        else {
            System.out.println("Email Textbox is not displayed");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("Under 18 Radio is displayed");
        }
        else {
            System.out.println("Under 18 Radio is not displayed");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()) {
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Auto");
            System.out.println("Education TextArea is displayed");
        }
        else {
            System.out.println("Education TextArea is not displayed");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            System.out.println("Name User5 is displayed");
        }
        else {
            System.out.println("Name User5 is not displayed");
        }
    }

    @Test
    public void Test_06_Enable() {
        driver.get(url);

        if (driver.findElement(By.cssSelector("input#mail")).isEnabled()) {
            System.out.println("Email Textbox is enable");
        }
        else {
            System.out.println("Email Textbox is not enable");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isEnabled()) {
            System.out.println("Under 18 Radio is enable");
        }
        else {
            System.out.println("Under 18 Radio is not enable");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isEnabled()) {
            System.out.println("Education TextArea is enable");
        }
        else {
            System.out.println("Education TextArea is not enable");
        }

        if (driver.findElement(By.cssSelector("select#job1")).isEnabled()) {
            System.out.println("Select Job Role 01 is enable");
        }
        else {
            System.out.println("Select Job Role 01 is disable");
        }

        if (driver.findElement(By.cssSelector("input#development")).isEnabled()) {
            System.out.println("Development checkbox is enable");
        }
        else {
            System.out.println("Development checkbox is disable");
        }

        if (driver.findElement(By.cssSelector("input#slider-1")).isEnabled()) {
            System.out.println("Slide 01 is enable");
        }
        else {
            System.out.println("Slide 01 is disable");
        }

        if (driver.findElement(By.cssSelector("input#disable_password")).isEnabled()) {
            System.out.println("Slide 01 is enable");
        }
        else {
            System.out.println("Slide 01 is disable");
        }
    }

    @Test
    public void Test_07_Selected() {
        driver.get(url);

        driver.findElement(By.cssSelector("input#under_18")).click();
        if (driver.findElement(By.cssSelector("input#under_18")).isSelected()) {
            System.out.println("Radio box Under 18 is selected");
        } else {
            System.out.println("Radio box Under 18 is unselected");
        }

        if (driver.findElement(By.cssSelector("input#java")).isSelected()) {
            System.out.println("Checkbox Language Java is selected");
        } else {
            System.out.println("Checkbox Language Java is unselected");
        }
    }

//    @Test
//    public void Test_08() {
//        driver.get("https://login.mailchimp.com/signup/");
//        driver.findElement(By.cssSelector("input#mail")).sendKeys("auto@gmail.com");
//
////        case1 - Number
//        driver.findElement(By.cssSelector("input#password")).sendKeys("1234");
//
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
//
//
////        case2 - lower
//        driver.findElement(By.cssSelector("input#password")).clear();
//        driver.findElement(By.cssSelector("input#password")).sendKeys("auto");
//
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
//
////        case3 - upper
//        driver.findElement(By.cssSelector("input#password")).clear();
//        driver.findElement(By.cssSelector("input#password")).sendKeys("AUTO");
//
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
//
//
////        case4 - Special chars
//        driver.findElement(By.cssSelector("input#password")).clear();
//        driver.findElement(By.cssSelector("input#password")).sendKeys("$%^^^^");
//
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
//
////        case5 - Max length
//        driver.findElement(By.cssSelector("input#password")).clear();
//        driver.findElement(By.cssSelector("input#password")).sendKeys("$%^^^^");
//
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
//
////        case6 - Valid
//        driver.findElement(By.cssSelector("input#password")).clear();
//        driver.findElement(By.cssSelector("input#password")).sendKeys("Auto123@$");
//
//        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='lowercase-char completed']")).isDisplayed());
//        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='uppercase-char completed']")).isDisplayed());
//        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='number-char completed']")).isDisplayed());
//        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='special-char completed']")).isDisplayed());
//        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
//    }
//
//    @Test
//    public void Test_09() {
//        driver.get("http://live.techpanda.org/");
//
//        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
//        driver.manage().timeouts().getPageLoadTimeout();
//
//        driver.findElement(By.cssSelector("button#send2")).click();
//
//        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(), "This is a required field.");
//        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass'")).getText(), "This is a required field.");
//    }

    @Test
    public void Test_10() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.manage().timeouts().getPageLoadTimeout();

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement emailBox = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='pass']"));

        explicitWait.until(ExpectedConditions.visibilityOf(emailBox));
        emailBox.sendKeys("123456@1344.1234");

        explicitWait.until(ExpectedConditions.visibilityOf(passwordBox));
        passwordBox.sendKeys("123456");

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test
    public void Test_11() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.manage().timeouts().getPageLoadTimeout();

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement emailBox = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='pass']"));

        explicitWait.until(ExpectedConditions.visibilityOf(emailBox));
        emailBox.sendKeys("auto@gmail.com");

        explicitWait.until(ExpectedConditions.visibilityOf(passwordBox));
        passwordBox.sendKeys("123");

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void Test_12() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.manage().timeouts().getPageLoadTimeout();

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement emailBox = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='pass']"));

        explicitWait.until(ExpectedConditions.visibilityOf(emailBox));
        emailBox.sendKeys("auto@gmail.com");

        explicitWait.until(ExpectedConditions.visibilityOf(passwordBox));
        passwordBox.sendKeys("123123123");

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText(), "Invalid login or password.");

    }

    @Test
    public void Test_14() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Login or Create an Account')]")));

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        String firstName = "auto";
        String lastName = "mation";
        String fullname = firstName + " " + lastName;
        String email = "automation" + random() + "@gmail.com";

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#firstname")));
        driver.findElement(By.cssSelector("#firstname")).sendKeys(firstName);

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#lastname")));
        driver.findElement(By.cssSelector("#lastname")).sendKeys(lastName);

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email_address")));
        driver.findElement(By.cssSelector("#email_address")).sendKeys(email);

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
        driver.findElement(By.cssSelector("#password")).sendKeys("123456@");

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#confirmation")));
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456@");

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[title='Register']")));
        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText(), "Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(), "Hello, " + fullname + "!");

        String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullname));
        Assert.assertTrue(contactInfo.contains(email));

//Logout
        driver.findElement(By.cssSelector("a.skip-account")).click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Log Out']")));
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='footer']//a[@title='My Account']")));
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));
        driver.findElement(By.cssSelector("#email")).sendKeys(email);

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pass")));
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456@");

        driver.findElement(By.cssSelector("#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(), "Hello, " + fullname + "!");

        contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullname));
        Assert.assertTrue(contactInfo.contains(email));

        // Verify account
        driver.findElement(By.xpath("//a[text()='Account Information']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getAttribute("value"), email);


    }

//    @Test
//    public void Test_15() {
//        driver.get("http://localhost/orangehrm-5.7/web/index.php/auth/login");
//        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='username']")));
//        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
//
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='password']")));
//        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Bestcat124@");
//
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".orangehrm-login-button")));
//        driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
//
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='oxd-main-menu-item']/span[text()='PIM']")));
//        driver.findElement(By.xpath("//a[@class='oxd-main-menu-item']/span[text()='PIM']")).click();
//
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='oxd-topbar-body-nav-tab']/a[text()='Add Employee']")));
//        driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab']/a[text()='Add Employee']")).click();
//
//
//    }

//    @Test
//    public void Test_016_DropdownList() {
//        driver.get("https://demo.nopcommerce.com/register");
//        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ico-register")));
//        driver.findElement(By.cssSelector(".ico-register")).click();
//
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gender-female")));
//        driver.findElement(By.cssSelector("#gender-female")).click();
//
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#FirstName")));
//        driver.findElement(By.cssSelector("#FirstName")).sendKeys("auto");
//
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#LastName")));
//        driver.findElement(By.cssSelector("#LastName")).sendKeys("mation");
//
//        Select selectDay = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
//        selectDay.selectByVisibleText("20");
//
//        Select selectMonth = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
//        selectMonth.selectByVisibleText("February");
//
//        Select selectYear = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
//        selectYear.selectByVisibleText("1990");
//
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Email")));
//        driver.findElement(By.cssSelector("#Email")).sendKeys("mation@gmail.com");
//
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Password")));
//        driver.findElement(By.cssSelector("#Password")).sendKeys("mation12345@");
//
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ConfirmPassword")));
//        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("mation12345@");
//
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#register-button")));
//        driver.findElement(By.cssSelector("#register-button")).sendKeys("mation12345@");
//
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".result")));
//
//        Assert.assertEquals(driver.findElement(By.cssSelector(".result")).getText(), "Your registration completed");
//
//
//    }

    @Test
    public void Test_017() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#speed-button")));
        driver.findElement(By.cssSelector("#speed-button")).click();

        List<WebElement> listItems = explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#speed-menu .ui-menu-item div")));
        for (WebElement item:listItems) {
            if (item.getText().equals("Slow")) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                item.click();
                break;
            }
        }

        Assert.assertEquals(driver.findElement(By.cssSelector("#speed-button .ui-selectmenu-text")).getText(), "Slow");

    }

    @Test
    public void Test_018_Select_React() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui.fluid.selection.dropdown")));
        driver.findElement(By.cssSelector(".ui.fluid.selection.dropdown")).click();

        List<WebElement> listItems = explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".menu .item span")));
        for (WebElement item:listItems) {
            if (item.getText().equals("Matt")) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                item.click();
                break;
            }
        }

        Assert.assertEquals(driver.findElement(By.cssSelector(".divider.text")).getText(), "Matt");

    }

    @Test
    public void Test_019_Select_Editable() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui.fluid.selection.dropdown")));
        driver.findElement(By.cssSelector(".ui.fluid.selection.dropdown .text")).click();
        driver.findElement(By.cssSelector(".ui.fluid.selection.dropdown input")).sendKeys("Al");

        List<WebElement> listItems = explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".menu .item span")));
        for (WebElement item:listItems) {
            if (item.getText().equals("Algeria")) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                item.click();
                break;
            }
        }

        Assert.assertEquals(driver.findElement(By.cssSelector(".divider.text")).getText(), "Algeria");

    }

    public String random() {
        Random random = new Random();
        return String.valueOf(random.nextInt(9999));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private final String url = "https://automationfc.github.io/basic-form/index.html";
}
