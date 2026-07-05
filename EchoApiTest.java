import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class EchoApiTest {

    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testGetRequest() {
        given()
                .log().all()
                .when()
                .get(BASE_URL + "/get")
                .then()
                .log().all()
                .statusCode(200)
                .body("url", equalTo(BASE_URL + "/get"))
                .body("headers", notNullValue())
                .body("args", notNullValue());
    }

    @Test
    public void testPostRequest() {
        String requestBody = "{\"name\":\"Test\",\"age\":30}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .log().all()
                .when()
                .post(BASE_URL + "/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("json.name", equalTo("Test"))
                .body("json.age", equalTo(30))
                .body("url", equalTo(BASE_URL + "/post"));
    }

    @Test
    public void testPutRequest() {
        String requestBody = "{\"product\":\"Laptop\",\"price\":1500}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .log().all()
                .when()
                .put(BASE_URL + "/put")
                .then()
                .log().all()
                .statusCode(200)
                .body("json.product", equalTo("Laptop"))
                .body("json.price", equalTo(1500))
                .body("url", equalTo(BASE_URL + "/put"));
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "{\"status\":\"updated\",\"id\":123}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .log().all()
                .when()
                .patch(BASE_URL + "/patch")
                .then()
                .log().all()
                .statusCode(200)
                .body("json.status", equalTo("updated"))
                .body("json.id", equalTo(123))
                .body("url", equalTo(BASE_URL + "/patch"));
    }

    @Test
    public void testDeleteRequest() {
        given()
                .log().all()
                .when()
                .delete(BASE_URL + "/delete")
                .then()
                .log().all()
                .statusCode(200)
                .body("url", equalTo(BASE_URL + "/delete"))
                .body("headers", notNullValue());
    }
}