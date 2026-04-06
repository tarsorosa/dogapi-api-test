import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PositiveBreedsTest extends BaseTest {

    @Tag("positivo")
    @Test
    public void shouldListAllBreeds() {
        given().log().all()
                .when().get("/breeds/list/all")
                .then().log().body()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", instanceOf(Map.class))
                .body("message.size()", greaterThan(0))
                .contentType("application/json")
                .time(lessThan(3000L));
    }

    @Tag("positivo")
    @Test
    public void shouldReturnBreedImages() {
        given().log().all()
                .when().get("/breed/hound/images")
                .then().log().body()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message.size()", greaterThan(0))
                .body("message", everyItem(matchesRegex("https://images\\.dog\\.ceo/.+\\.jpg")))
                .contentType("application/json")
                .time(lessThan(3000L));
    }

    @Tag("positivo")
    @Test
    public void shouldReturnRandomImage() {
        given().log().all()
                .when().get("/breeds/image/random")
                .then().log().body()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", matchesRegex("https://images\\.dog\\.ceo/.+\\.jpg"))
                .contentType("application/json")
                .time(lessThan(3000L));

    }
}