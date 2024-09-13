package commons;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public WebDriver getDriverInstance() {
        return this.driver;
   }

    protected WebDriver getBrowserDriver(String browserName, String appUrl) {
        switch (browserName) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "h_firefox": {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                options.addArguments("window-size=1920x1080");
                driver = new FirefoxDriver(options);
                break;
            }
            case "chrome":
//                Map<String, Object> prefs = new HashMap<String, Object>();
//                prefs.put("profile.default_content_setting_values.notifications", 2);
//                prefs.put("credentials_enable_service", false);
//                prefs.put("profile.password_manager_enabled", false);
//                prefs.put("autofill.profile_enabled", false);
//
//                prefs.put("profile.default_content_settings.popups", 0);
//                prefs.put("download.default_directory", GlobalConstants.getGlobalConstants().getDownloadFileFolder() + "\\downloadFiles");

                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("--disable-notifications"); // tắt thông báo
//                chromeOptions.addArguments("--disable-geolocation");  // hỏi vị trí
//                chromeOptions.addArguments("--incognito");// chạy chế độ ẩn danh
//                chromeOptions.setExperimentalOption("useAutomationExtension", false);
//                chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//                chromeOptions.setExperimentalOption("prefs", prefs);

                driver = new ChromeDriver(chromeOptions);
                break;
            case "h_chrome": {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("window-size=1920x1080");
                driver = new ChromeDriver(options);
                break;
            }
            case "edge":
                driver = new EdgeDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new RuntimeException("Browser name invalid");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.getGlobalConstants().getLongTimeout()));
        driver.get(appUrl);
        driver.manage().window().maximize();
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String osName, String ipAddress, String portNumber) {
        DesiredCapabilities capability = new DesiredCapabilities();
        Platform platform = null;

        if (osName.toLowerCase().contains("windows")) {
            platform = Platform.WINDOWS;
        } else {
            platform = Platform.MAC;
        }

        switch (browserName) {
            case "firefox":
                capability.setBrowserName("firefox");
                capability.setPlatform(platform);

                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.merge(capability);
                break;
            case "chrome":
                capability.setBrowserName("chrome");
                capability.setPlatform(platform);

                ChromeOptions cOptions = new ChromeOptions();
                cOptions.merge(capability);
                break;
            case "edge":
                capability.setBrowserName("MicrosoftEdge");
                capability.setPlatform(platform);

                EdgeOptions eOptions = new EdgeOptions();
                eOptions.merge(capability);
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        try {
            driver = new
                    RemoteWebDriver(new URL(String.format("http://%s:%s/", ipAddress, portNumber)), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.manage().window().maximize();
//        driver.get(url);
        return driver;
    }

    protected void closeBrowser() {
        if (!(null == driver)) {
            driver.quit();
        }

    }

//    protected boolean verifyTrue(boolean condition) {
//        boolean pass = true;
//        try {
//            Assert.assertTrue(condition);
//        } catch (Throwable e) {
//            pass = false;
//
//            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
//            Reporter.getCurrentTestResult().setThrowable(e);
//        }
//        return pass;
//    }
//
//    protected boolean verifyFalse(boolean condition) {
//        boolean pass = true;
//        try {
//            Assert.assertFalse(condition);
//        } catch (Throwable e) {
//            pass = false;
//            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
//            Reporter.getCurrentTestResult().setThrowable(e);
//        }
//        return pass;
//    }
//
//    protected boolean verifyEquals(Object actual, Object expected) {
//        boolean pass = true;
//        try {
//            Assert.assertEquals(actual, expected);
//        } catch (Throwable e) {
//            pass = false;
//            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
//            Reporter.getCurrentTestResult().setThrowable(e);
//        }
//        return pass;
//    }


    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;
}
