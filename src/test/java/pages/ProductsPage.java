package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductsPage extends BasePage {
    String addToCartButton = "//*[contains(text(), '%s')]//ancestor::div[@class='inventory_item']//button";
    String getPrice = "//*[contains(text(), '%s')]//ancestor::*[@class='inventory_item']//*[@class='inventory_item_price']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add product {name} into cart")
    public void addToCart(String name) {
        log.info("Add product {name} into cart");
        driver.findElement(By.xpath(String.format(addToCartButton, name))).click();
    }

    @Step("Get product {name} Price")
    public String getPrice(String name) {
        log.info("Get product {name} Price");
        return driver.findElement(By.xpath(String.format(getPrice, name))).getText();
    }
}
