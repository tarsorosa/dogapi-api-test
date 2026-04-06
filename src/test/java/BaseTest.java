import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setup() {
        // URL base da Dog API
        RestAssured.baseURI = "https://dog.ceo/api";
    }

}