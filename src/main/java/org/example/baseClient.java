package org.example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class baseClient {
    private static String BASE_URL = "https://petstore.swagger.io/v2/";

    public static RequestSpecification getBaseSpec()
    {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .build();
    }
}
