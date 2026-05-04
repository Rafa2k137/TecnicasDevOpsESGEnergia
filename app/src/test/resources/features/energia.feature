package br.com.energia.energia.steps;

import io.cucumber.java.pt.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EnergiaSteps {

    Response response;

    @Dado("que a API está disponível")
    public void apiDisponivel() {
        baseURI = "http://energia-api:8080";
    }

    @Quando("eu envio um GET para {string}")
    public void getRequisicao(String endpoint) {
        response = given()
                .when()
                .get(endpoint);
    }

    @Quando("eu envio um POST para {string} com dados válidos")
    public void postValido(String endpoint) {
        response = given()
                .contentType("application/json")
                .body("{\"consumo\": 100}")
                .when()
                .post(endpoint);
    }

    @Quando("eu envio um POST para {string} com dados inválidos")
    public void postInvalido(String endpoint) {
        response = given()
                .contentType("application/json")
                .body("{}")
                .when()
                .post(endpoint);
    }

    @Dado("que existe um consumo cadastrado")
    public void consumoCadastrado() {
        baseURI = "http://energia-api:8080";

        response = given()
                .contentType("application/json")
                .body("{\"consumo\": 100}")
                .when()
                .post("/energia");
    }

    @Então("o status da resposta deve ser {int}")
    public void validarStatus(int status) {
        response.then().statusCode(status);
    }

    @Então("o corpo da resposta deve conter o campo {string}")
    public void validarCampo(String campo) {
        response.then().body(campo, notNullValue());
    }
}
