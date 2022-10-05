package org.example;

import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileReader;

public class Client extends baseClient {
    private static final String PLACE_ORDER_FOR_PET = "store/order";
    private static final String RETURN_PET_INVENTORIES_BY_STATUS = "/store/inventor";
    public ValidatableResponse placeOrderForPetPost(File jsonBody) {
        return given()
                .spec(getBaseSpec())
                .body(jsonBody)
                .when()
                .post(PLACE_ORDER_FOR_PET)
                .then();
    }

    public ValidatableResponse returnPetInventoriesByStatusGet() {
        return given()
                .spec(getBaseSpec())
                //.headers("accept", "application/xml")
                //.headers("accept", "application/json")
                .when()
                .get(RETURN_PET_INVENTORIES_BY_STATUS)
                .then();
    }
}
