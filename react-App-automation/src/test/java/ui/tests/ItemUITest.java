package ui.tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.BaseUITest;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ItemUITest extends BaseUITest {

    private JSONArray testCases;

    @BeforeClass
    public void loadTestData() throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/testdata.json")));
        testCases = new JSONArray(content);
    }

    @DataProvider(name = "itemData")
    public Object[][] itemData() {
        Object[][] data = new Object[testCases.length()][3];
        for (int i = 0; i < testCases.length(); i++) {
            JSONObject obj = testCases.getJSONObject(i);
            data[i][0] = obj.getString("originalItem");
            data[i][1] = obj.getString("updatedItem");
            data[i][2] = obj;
        }
        return data;
    }

    @Test(dataProvider = "itemData")
    public void testCreateEditDeleteItem(String original, String updated, JSONObject fullObj) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(fullObj.getString("username"), fullObj.getString("password"));
        Thread.sleep(1000);

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.createItem(original);
        Thread.sleep(1000);
        Assert.assertTrue(dashboard.isItemPresent(original), "Item should appear after adding");

        dashboard.editItem(original, updated);
        Thread.sleep(1000);
        Assert.assertTrue(dashboard.isItemPresent(updated), "Item should appear after editing");

        dashboard.deleteItem(updated);
        Thread.sleep(1000);
        Assert.assertFalse(dashboard.isItemPresent(updated), "Item should be deleted");
    }
}