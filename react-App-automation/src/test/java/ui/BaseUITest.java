package ui;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseUITest {
    protected WebDriver driver;
    protected String frontendUrl;

    @BeforeClass
    public void setUp() throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/env.json")));
        JSONObject env = new JSONObject(content);
        frontendUrl = env.getString("frontendUrl");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(frontendUrl);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}