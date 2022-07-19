package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    public static final String URL = utils.PropertyReader.getProperty("SAUCEDEMO_URL", "saucedemo.url");
    protected static final String USER = utils.PropertyReader.getProperty("SAUCEDEMO_USER", "saucedemo.user");
    protected static final String PASSWORD = utils.PropertyReader.getProperty("SAUCEDEMO_PASSWORD", "saucedemo.password");
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CheckoutPage checkoutPage;
    protected CartPage cartPage;
    protected BurgerMenuPage burgerMenuPage;
    WebDriver driver;
    protected static final String browser = System.getProperty("BROWSER");
//    public static final String USER = "standard_user";
//    public static final String PASSWORD = "secret_sauce";
//    public static final String URL = "https://www.saucedemo.com/";

    @Step("Open browser")
//    @Parameters({"browser"})
    @BeforeMethod(description = "Open browser")
    public void setUp(ITestContext testContext) {
        log.info("Open browser " + browser.toString());
        if (browser == "" || browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
            options.addArguments("--disable-notifications");
            log.info("Chrome");
            driver = new ChromeDriver(options);
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
            log.info("edge");
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
            log.info("firefox");
        }
        testContext.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
        burgerMenuPage = new BurgerMenuPage(driver);
    }

    @Step("Close browser")
    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        log.info("Close browser");
        driver.quit();
    }
}
