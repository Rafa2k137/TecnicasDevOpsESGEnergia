package br.com.energia.steps;

import io.cucumber.java.pt.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EnergiaSteps {

    Response response;

    @Dado("que a API está disponível")
    public void apiDisponivel() {
        // opcional health check
    }

    @Quando("eu envio um GET para {string}")
    public void getRequisicao(String endpoint) {
        response =
            given()
                .baseUri("http://energia-api:8080")
            .when()
                .get(endpoint);
    }

    @Então("o status da resposta deve ser {int}")
    public void validarStatus(int status) {
        response.then().statusCode(status);
    }
}