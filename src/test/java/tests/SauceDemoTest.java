package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SauceDemoTest {

    @Test(description = "locators", enabled = false)
    public void login() {
        //locators
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("password"));
        driver.findElement(By.className("submit-button"));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        String a = driver.findElement(By.xpath("//*[@class='login_password']/h4")).getText();
        String password = driver.findElement(By.xpath("//*[@class='login_password']")).getText();
        driver.findElement(By.name("password")).sendKeys(password.replace(a, ""));
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.linkText("Twitter"));
        driver.findElement(By.partialLinkText("Face"));
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bolt-t-shirt']"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
        driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Fleece')]"));
        driver.findElement(By.xpath("//a[contains(@id,'item_0_img')]"));
        driver.findElement(By.xpath("//*[text()='Twitter']//ancestor::li"));
        driver.findElement(By.xpath("//ul[class='social']//descendant::a]"));
        driver.findElement(By.xpath("//ul[class='social']//descendant::a]"));
        driver.findElement(By.cssSelector(".inventory_item_name"));
        driver.findElement(By.cssSelector(".btn.btn_primary"));
        driver.findElement(By.cssSelector(".inventory_item_description .inventory_item_name"));
        driver.findElement(By.cssSelector("#item_4_title_link"));
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("div.inventory_item_name"));
        driver.findElement(By.cssSelector("[class='inventory_item_name']"));
        driver.findElement(By.cssSelector("[id|='add-to-cart-sauce']"));
        driver.findElement(By.cssSelector("a[href^='#']"));
        driver.findElement(By.cssSelector("img[src$='.jpg']"));
        driver.findElement(By.cssSelector("img[alt*='Sauce']"));
    }
}

