package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}