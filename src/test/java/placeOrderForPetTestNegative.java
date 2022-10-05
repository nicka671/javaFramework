import org.example.*;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import static org.junit.Assert.*;

public class placeOrderForPetTestNegative {

    private Client client;
    private ValidatableResponse response;
//getOrderByIdGet

    @Before
    public void setUp() {
        client = new Client();
        response = client.returnPetInventoriesByStatusGet();
    }

    @Test
    public void placeOrderForPetTestNegativeJsonBody() {
        String apiResponseMessage = response.extract().path("apiResponse.message");
        assertEquals("null for uri: http://petstore.swagger.io/v2/store/inventor", apiResponseMessage);
    }

    @Test
    public void placeOrderForPetTestNegativeStatusCode() {
        int statusCode = response.extract().statusCode();
        assertEquals("Код состояния должен быть 404", 404, statusCode);
    }
}