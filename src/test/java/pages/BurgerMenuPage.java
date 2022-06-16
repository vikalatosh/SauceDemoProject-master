package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class BurgerMenuPage extends BasePage {
    public static final By BURGERMENU_BUTTON = By.id("react-burger-menu-btn");
    public static final By BURGER_LOGOUT_BUTTON = By.id("logout_sidebar_link");
    public static final By SAUCELABS_LINK = By.id("about_sidebar_link");

    public BurgerMenuPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click the button Logout")
    public void clickLogoutBurgerMenu() {
        log.info("Click button Logout");
        driver.findElement(BURGER_LOGOUT_BUTTON).click();
    }

    @Step("Open Burger menu")
    public void clickBurgerMenu() {
        log.info("Open Burger menu");
        driver.findElement(BURGERMENU_BUTTON).click();
    }

    @Step("Get link test")
    public String getLink() {
        log.info("Get link test");
        return driver.findElement(SAUCELABS_LINK).getAttribute("href");
    }
}
