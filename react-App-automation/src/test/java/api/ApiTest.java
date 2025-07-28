
package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    private int createdId;

    @BeforeClass
    public void setup() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/env.json")));
        JSONObject env = new JSONObject(content);
        RestAssured.baseURI = env.getString("backendUrl");
    }

    @Test
    public void testLoginValid() {
        given()
            .contentType("application/json")
            .body("{ \"username\": \"admin\", \"password\": \"admin\" }")
        .when()
            .post("/login")
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
    }

    @Test
    public void testLoginInvalid() {
        given()
            .contentType("application/json")
            .body("{ \"username\": \"invalid\", \"password\": \"wrong\" }")
        .when()
            .post("/login")
        .then()
            .statusCode(401);
    }

      @Test(priority = 1)
    public void testCreateItem() {
        Response response = given()
                .contentType("application/json")
                .body("{ \"text\": \"Test Item\" }")
                .when()
                .post("/create")
                .then()
                .statusCode(201)
                .body("text", equalTo("Test Item"))
                .extract().response();

        createdId = response.jsonPath().getInt("id");
    }

    @Test(priority = 2, dependsOnMethods = "testCreateItem")
    public void testGetItem() {
        given()
                .when()
                .get("/items")
                .then()
                .statusCode(200)
                .body("text", hasItem("Test Item"));
    }

    @Test(priority = 3, dependsOnMethods = "testCreateItem")
    public void testEditItem() {
        given()
                .contentType("application/json")
                .body("{ \"text\": \"Updated Item\" }")
                .when()
                .put("/items/" + createdId)
                .then()
                .statusCode(200);
    }

    @Test(priority = 4, dependsOnMethods = "testCreateItem")
    public void testDeleteItem() {
        given()
                .when()
                .delete("/items/" + createdId)
                .then()
                .statusCode(200);
    }
}
