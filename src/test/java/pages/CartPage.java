package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static tests.base.BaseTest.URL;

@Log4j2
public class CartPage extends BasePage {
    public static final By PRICE_DIV = By.cssSelector(".inventory_item_price");
    public static final By NAME_DIV = By.cssSelector(".inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Cart page")
    public void openCart() {
        log.info("Open Cart page");
        driver.get(URL + "cart.html");
    }

    @Step("Click the button Checkout")
    public void clickCheckout() {
        log.info("Click button Checkout");
        driver.findElement(By.id("checkout")).click();
    }

    @Step("Get product name")
    public String getNameOnCartPage() {
        log.info("Get product name");
        return driver.findElement(NAME_DIV).getText();
    }

    @Step("Get product price")
    public String getPriceOnCartPage() {
        log.info("Get product price");
        return driver.findElement(PRICE_DIV).getText();
    }
}
