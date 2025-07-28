package ui.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.BaseUITest;
import ui.pages.LoginPage;

public class NegativeLoginTest extends BaseUITest {

    @DataProvider(name = "invalidLogins")
    public Object[][] invalidLogins() {
        return new Object[][] {
            {"admin", "wrongpass"},
            {"wronguser", "admin"},
            {"", ""},
            {"admin", ""}
        };
    }

    @Test(dataProvider = "invalidLogins")
    public void testInvalidLogin(String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.usernameInput.clear();
        loginPage.passwordInput.clear();
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
        Thread.sleep(1000);

        boolean errorShown = driver.getPageSource().contains("Invalid credentials");
        Assert.assertTrue(errorShown, "Error message should appear for invalid login");
    }
}