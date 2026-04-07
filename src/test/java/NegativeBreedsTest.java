import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class NegativeBreedsTest extends BaseTest {

// -------------------------- /breeds/list/all -----------------------------

    // Cenário 1: endpoint inválido (http 404)
    @Test
    public void shouldReturn404ForInvalidEndpointListAll() {
        given().log().all()
                .when().get("/breeds/list/invalid") // endpoint errado
                .then().log().body()
                .statusCode(404)
                .body("status", not(equalTo("success"))); // valida que não é sucesso
    }

    // Cenário 2: método HTTP incorreto  (http 405)
    @Test
    public void shouldReturn405ForPostOnGetEndpointListAll() {
        given().log().all()
                .when().post("/breeds/list/all") // POST não permitido
                .then().log().body()
                .statusCode(405)
                .body("status", not(equalTo("success")));
    }

    // Cenário 3: URL mal formada (http 404)
    @Test
    public void shouldReturn404ForMalformedUrlEndpointListAll() {
        given().log().all()
                .when().get("/breeds/list/all%%") // caracteres inválidos na URL
                .then().log().body()
                .statusCode(404)
                .body("status", not(equalTo("success")));
    }

    // Cenário 4: tempo de resposta abaixo de limite (teste proposital de falha)
    @Test
    public void shouldFailIfResponseTooSlowEndepointListAll() {
        given().log().all()
                .when().get("/breeds/list/all")
                .then()
                .time(lessThan(300L)); // propositalmente impossível para gerar falha
    }

// ------------------------ /breed/hound/images ---------------------------

    // Cenário 1: endpoint inválido (http 404)
    @Test
    public void shouldReturn404ForInvalidEndpointHoundImages() {
        given().log().all()
                .when().get("/breed/hound/invalid") // endpoint errado
                .then().log().body()
                .statusCode(404)
                .body("status", not(equalTo("success"))); // valida que não é sucesso
    }

    // Cenário 2: método HTTP incorreto (http 405)
    @Test
    public void shouldReturn405ForPostOnGetEndpointHoundImages() {
        given().log().all()
                .when().post("/breed/hound/images") // POST não permitido
                .then().log().body()
                .statusCode(405)
                .body("status", not(equalTo("success")));
    }

    // Cenário 3: raça inválida informada (http 404)
    @Test
    public void shouldReturn404ForInvalidBreedEndpointHoundImages() {
        given().log().all()
                .when().get("/breed/invalidbreed/images") // raça que não existe
                .then().log().body()
                .statusCode(404)
                .body("status", not(equalTo("success")));
    }

    // Cenário 4: URL mal formada (http 404)
    @Test
    public void shouldReturn404ForMalformedUrlEndpointHoundImages() {
        given().log().all()
                .when().get("/breed/hound/images%%") // caracteres inválidos
                .then().log().body()
                .statusCode(404)
                .body("status", not(equalTo("success")));
    }

    // Cenário 5: tempo de resposta abaixo de limite (teste proposital de falha)
    @Test
    public void shouldFailIfResponseTooSlowEndpointHoundImages() {
        given().log().all()
                .when().get("/breed/hound/images")
                .then()
                .time(lessThan(300L)); // propositalmente impossível para gerar falha
    }

// ------------------------ /breeds/image/random ---------------------------

    // Cenário 1: endpoint inválido (http 404)
    @Test
    public void shouldReturn404ForInvalidEndpointImageRandom() {
        given().log().all()
                .when().get("/breeds/image/invalid") // endpoint errado
                .then().log().body()
                .statusCode(404)
                .body("status", not(equalTo("success"))); // valida que não é sucesso
    }

    // Cenário 2: método HTTP incorreto (http 405)
    @Test
    public void shouldReturn405ForPostOnGetEndpointImageRandom() {
        given().log().all()
                .when().post("/breeds/image/random") // POST não permitido
                .then().log().body()
                .statusCode(405)
                .body("status", not(equalTo("success")));
    }

    // Cenário 3: URL mal formada (http 404)
    @Test
    public void shouldReturn404ForMalformedUrlImageRandom() {
        given().log().all()
                .when().get("/breeds/image/random%%") // caracteres inválidos
                .then().log().body()
                .statusCode(404)
                .body("status", not(equalTo("success")));
    }

    // Cenário 4: tempo de resposta abaixo de limite (teste proposital de falha)
    @Test
    public void shouldFailIfResponseTooSlowImageRandom() {
        given().log().all()
                .when().get("/breeds/image/random")
                .then()
                .time(lessThan(300L)); // propositalmente impossível para gerar falha
    }

}