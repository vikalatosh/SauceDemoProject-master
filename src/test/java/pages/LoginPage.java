package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static tests.base.BaseTest.URL;

@Log4j2
public class LoginPage extends BasePage {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Login page")
    public void open() {
        log.info("Open Login page");
        driver.get(URL);
    }

    @Step("Login by user: {user}, {pass}")
    public void login(String user, String pass) {
        log.info("Login by user: " + user + ", " + pass);
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(pass);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Get error message Login page")
    public String getError() {
        log.info("Get error message Login page");
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Check that page is opened")
    public boolean loginPageIsOpen() {
        log.info("Check that page is opened");
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }
}
