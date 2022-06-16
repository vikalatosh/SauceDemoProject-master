package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static pages.CheckoutPage.*;

public class CheckoutTest extends BaseTest {

    @DataProvider(name = "Checkout Data")
    public Object[][] checkoutData() {
        return new Object[][]{
                {"", LASTNAME, POSTALCODE, "Error: First Name is required"},
                {FIRSTNAME, "", POSTALCODE, "Error: Last Name is required"},
                {FIRSTNAME, LASTNAME, "", "Error: Postal Code is required"},
        };
    }

    @Test(description = "Negative tests for Checkout page", dataProvider = "Checkout Data")
    public void inputInvalidDataIntoCheckoutForm(String firstName, String lastName, String postalCode, String errorMessage) {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        cartPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.inputYourInformation(firstName, lastName, postalCode);
        String errorCheckoutPage = checkoutPage.getCheckoutErrorMessage();
        assertEquals(errorCheckoutPage, errorMessage, "Error message is not correct");
    }

    @Test(description = "Positive test for Checkout form")
    public void inputValidDataIntoCheckoutForm() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        cartPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.inputYourInformation(FIRSTNAME, LASTNAME, POSTALCODE);
        String title = checkoutPage.pageIsOpened();
        assertEquals(title, "CHECKOUT: OVERVIEW", "Page was not opened");
    }

    @Test(description = "Button Cancel should go to Products page")
    public void buttonCancelShouldGoToProductsPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        cartPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.clickButtonCancel();
        String title = checkoutPage.pageIsOpened();
        assertEquals(title, "YOUR CART", "Page was not opened");
    }
}
