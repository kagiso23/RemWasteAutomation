package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    private By itemInput = By.xpath("//input[@placeholder='Enter item']");
    private By actionButton = By.xpath("//button[contains(text(),'Add') or contains(text(),'Update')]");

    public void createItem(String itemName) {
        driver.findElement(itemInput).sendKeys(itemName);
        driver.findElement(actionButton).click();
    }

    public void editItem(String original, String updated) {
        driver.findElement(By.xpath("//li[contains(.,'" + original + "')]//button[text()='Edit']")).click();
        WebElement input = driver.findElement(itemInput);
        input.clear();
        input.sendKeys(updated);
        driver.findElement(actionButton).click();
    }

    public void deleteItem(String item) {
        driver.findElement(By.xpath("//li[contains(.,'" + item + "')]//button[text()='Delete']")).click();
    }

    public boolean isItemPresent(String itemText) {
        List<WebElement> list = driver.findElements(By.xpath("//li[contains(.,'" + itemText + "')]"));
        return !list.isEmpty();
    }
}