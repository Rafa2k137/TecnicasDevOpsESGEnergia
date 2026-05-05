package br.com.energia.energia.steps;

import io.cucumber.java.pt.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EnergiaSteps {

    Response response;

    @Dado("que a API está disponível")
    public void apiDisponivel() {
        // opcional health check
        given()
            .baseUri("http://energia-api:8080")
        .when()
            .get("/health")
        .then()
            .statusCode(anyOf(is(200), is(404)));
    }

    @Quando("eu envio um GET para {string}")
    public void getRequisicao(String endpoint) {
        response =
            given()
                .baseUri("http://energia-api:8080")
            .when()
                .get(endpoint);
    }

    @Quando("eu envio um POST para {string} com dados válidos")
    public void postValido(String endpoint) {
        response =
            given()
                .baseUri("http://energia-api:8080")
                .contentType("application/json")
                .body("{\"consumo\":100}")
            .when()
                .post(endpoint);
    }

    @Quando("eu envio um POST para {string} com dados inválidos")
    public void postInvalido(String endpoint) {
        response =
            given()
                .baseUri("http://energia-api:8080")
                .contentType("application/json")
                .body("{}")
            .when()
                .post(endpoint);
    }

    @Então("o status da resposta deve ser {int}")
    public void validarStatus(int status) {
        response.then().statusCode(status);
    }

    @Então("o corpo da resposta deve conter o campo {string}")
    public void validarCampo(String campo) {
        response.then().body("$", hasKey(campo));
    }

    @Dado("que existe um consumo cadastrado")
    public void consumoCadastrado() {
        response =
            given()
                .baseUri("http://energia-api:8080")
                .contentType("application/json")
                .body("{\"consumo\":50}")
            .when()
                .post("/energia");

         id = response.jsonPath().getInt("id");
    }
}
