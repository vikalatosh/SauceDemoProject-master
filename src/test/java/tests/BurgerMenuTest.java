package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BurgerMenuTest extends BaseTest {

    @Test(description = "Logout should go to Login page")
    public void buttonLogoutShouldGoToLoginPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        burgerMenuPage.clickBurgerMenu();
        burgerMenuPage.clickLogoutBurgerMenu();
        boolean isOpened = loginPage.loginPageIsOpen();
        assertTrue(isOpened, "Login Page is not opened");
    }

    @Test(description = "SauceLabs link should be correct")
    public void linkAboutShouldBeCorrect() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        burgerMenuPage.clickBurgerMenu();
        assertEquals(burgerMenuPage.getLink(), "https://saucelabs.com/",
                "Saucelabs link is not correct");
    }
}
