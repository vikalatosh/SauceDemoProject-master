package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutPage extends BasePage {
    public static final String FIRSTNAME = "vika";
    public static final String LASTNAME = "latosh";
    public static final String POSTALCODE = "1111111";
    public static final By FIRSTNAME_INPUT = By.id("first-name");
    public static final By LASTNAME_INPUT = By.id("last-name");
    public static final By POSTALCODE_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By CANCEL_BUTTON = By.id("cancel");
    public static final By CHECKOUT_ERROR_MESSAGE = By.cssSelector("[data-test=error]");
    public static final By PAGE_TITLE = By.cssSelector("[class='title']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input information {firstName}, {lastName}, {postalCode}")
    public void inputYourInformation(String firstName, String lastName, String postalCode) {
        log.info("Input information: " + firstName + ", " + lastName + ", " + postalCode);
        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstName);
        driver.findElement(LASTNAME_INPUT).sendKeys(lastName);
        driver.findElement(POSTALCODE_INPUT).sendKeys(postalCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Get error message Checkout page")
    public String getCheckoutErrorMessage() {
        log.info("Get error message Checkout page by locator " + CHECKOUT_ERROR_MESSAGE);
        return driver.findElement(CHECKOUT_ERROR_MESSAGE).getText();
    }

    @Step("Click the button Cancel")
    public void clickButtonCancel() {
        log.info("Click button Cancel");
        driver.findElement(CANCEL_BUTTON).click();
    }

    @Step("Check that Checkout page is opened")
    public String pageIsOpened() {
        log.info("Check that Checkout page is opened");
        return driver.findElement(PAGE_TITLE).getText();
    }
}
