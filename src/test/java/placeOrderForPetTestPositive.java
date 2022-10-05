import jdk.internal.org.objectweb.asm.Handle;
import org.example.*;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.logging.*;

public class placeOrderForPetTestPositive {

    static Logger myLog;
    //static final Logger myLog = Logger.getLogger(placeOrderForPetTestPositive.class.getName());
    static {
        try(FileInputStream ins = new FileInputStream("log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            myLog = Logger.getLogger(placeOrderForPetTestPositive.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    private File placeOrderForPetJson;
    private Client client;
    private ValidatableResponse response;

    // переменные для проверки тела ответа
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    @Before
    public void setUp() {
        myLog.info("Сохраняю в переменную placeOrderForPetJson файл с телом запроса\n");
        placeOrderForPetJson = new File("src/test/resources/placeOrderForPetJson.json");
        myLog.info("Создаю объект класса Client\n");
        client = new Client();
        myLog.info("Дёргаю ручку с методом Post по URI \"store/order\"\n");
        response = client.placeOrderForPetPost(placeOrderForPetJson);
    }

    @Test
    public void setPlaceOrderForPetPostJsonBodyNotNull() throws Exception {

        try {
            myLog.log(Level.WARNING, "Здесь может быть NullPointerException");
            id = response.extract().path("id");
        } catch(NullPointerException npe) {
            npe.printStackTrace();
            myLog.log(Level.SEVERE, "Пойман NullPointerException, пришёл ответ в формате XML об ошибке\n");
            //System.out.println("XML instead of JSON is recieved, stopping tests");
            //System.exit(0);
        } finally {
            //assertNotNull("ID не должен быть пустым", id);
            myLog.log(Level.INFO, "id is: " + id + "\n");
            assertEquals(115, id);
        }

        try {
            myLog.log(Level.WARNING, "Здесь может быть NullPointerException");
            // извлекаем поле
            petId = response.extract().path("petId");
        } catch(NullPointerException npe) {
            npe.printStackTrace();
            myLog.log(Level.SEVERE, "Пойман NullPointerException, пришёл ответ в формате XML об ошибке\n");
        } finally {
            // assert
            //assertNotNull("petId не должен быть пустым", petId);
            myLog.log(Level.INFO, "petId is: " + petId + "\n");
            assertEquals(50, petId);
        }

        try {
            myLog.log(Level.WARNING, "Здесь может быть NullPointerException");
            // извлекаем поле
            quantity = response.extract().path("quantity");
        } catch(NullPointerException npe) {
            npe.printStackTrace();
            myLog.log(Level.SEVERE, "Пойман NullPointerException, пришёл ответ в формате XML об ошибке\n");
        } finally {
            // assert
            //assertNotNull("quantity не должен быть пустым", quantity);
            myLog.log(Level.INFO, "quantity is: " + quantity + "\n");
            assertEquals(400, quantity);
        }

        try {
            myLog.log(Level.WARNING, "Здесь может быть NullPointerException");
            // извлекаем поле
            shipDate = response.extract().path("shipDate");
        } catch(NullPointerException npe) {
            npe.printStackTrace();
            myLog.log(Level.SEVERE, "Пойман NullPointerException, пришёл ответ в формате XML об ошибке\n");
        } finally {
            myLog.log(Level.INFO, "shipDate is: " + shipDate + "\n");
            assertEquals("2022-10-03T22:16:45.217+0000", shipDate);
        }

        try {
            myLog.log(Level.WARNING, "Здесь может быть NullPointerException");
            // извлекаем поле
            status = response.extract().path("status");
        } catch(NullPointerException npe) {
            npe.printStackTrace();
            myLog.log(Level.SEVERE, "Пойман NullPointerException, пришёл ответ в формате XML об ошибке");
        } finally {
            // assert
            //assertNotNull("status не должен быть пустым", status);
            myLog.log(Level.INFO, "status is: " + status + "\n");
            assertEquals("placed", status);
        }

        try {
            myLog.log(Level.WARNING, "Здесь может быть NullPointerException");
            // извлекаем поле
            complete = response.extract().path("complete");
        } catch(NullPointerException npe) {
            npe.printStackTrace();
            myLog.log(Level.SEVERE, "Пойман NullPointerException, пришёл ответ в формате XML об ошибке");
        } finally {
            // assert
            myLog.log(Level.INFO, "complete is: " + complete + "\n");
            assertTrue("Аккаунт курьера не создан", complete);
        }
    }

    @Test
    public void placeOrderForPetPostJsonStatusCode() {
        int statusCode = response.extract().statusCode();
        assertEquals("Код состояния должен быть 200", 200, statusCode);
    }
}
