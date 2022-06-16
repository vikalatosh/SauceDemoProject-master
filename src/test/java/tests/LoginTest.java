package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "Product should be added into cart")
    public void loginTest() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        String expectedPrice = productsPage.getPrice("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCart();
        String actualPrice = cartPage.getPriceOnCartPage();
        String actualName = cartPage.getNameOnCartPage();
        assertEquals(actualPrice, expectedPrice, "the price doesn't match the selected product");
        assertEquals(actualName, "Test.allTheThings() T-Shirt (Red)",
                "the name doesn't match the selected product");
    }

    @DataProvider(name = "Login Data")
    public Object[][] loginData() {
        return new Object[][]{
                {"", PASSWORD, "Epic sadface: Username is required"},
                {USER, "", "Epic sadface: Password is required"},
                {USER, "aaaa", "Epic sadface: Username and password do not match any user in this service"},
                {"aasd", PASSWORD, "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(description = "Negative tests for login", dataProvider = "Login Data")
    public void negativeTestsForLogin(String user, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(user, password);
        String error = loginPage.getError();
        assertEquals(error, errorMessage, "Error message is not correct");
    }
}
