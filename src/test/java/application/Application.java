package application;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import entities.AddRequestBody;
import entities.DeleteRequestBody;
import entities.Item;
import entities.ViewRequestBody;
import io.restassured.response.Response;
import services.Specifications;

import java.util.List;

import static io.restassured.RestAssured.given;
import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static services.EndPoints.*;
import static utils.RandomGenerators.getItemId;

public class Application {

    private static final Specifications spec = new Specifications();

    public static int getMaxId() {
        Response getEntries = given()
                .spec(spec.requestGetSpec)
                .get(entries)
                .then()
                .spec(spec.responseSpecOk)
                .extract()
                .response();
        return Integer.parseInt(getEntries.jsonPath().get("LastEvaluatedKey.id"));
    }

    public static void addToCart(String requestId, String cookie, int itemId) {
        AddRequestBody requestBody = new AddRequestBody(requestId, cookie, valueOf(itemId), false);

        given()
                .spec(spec.requestPostSpec)
                .body(requestBody)
                .post(addToCart)
                .then()
                .spec(spec.responseSpecOk);
    }

    public static Response viewCart(String cookie) {
        ViewRequestBody requestBody = new ViewRequestBody(cookie, false);

        return given()
                .spec(spec.requestPostSpec)
                .body(requestBody)
                .post(viewCart)
                .then()
                .spec(spec.responseSpecOk)
                .extract()
                .response();
    }

    public static List<Item> getCartContext(String cookie) {
        String json = viewCart(cookie).getBody().asString();
        JsonElement parsed = JsonParser.parseString(json);
        JsonElement items = parsed.getAsJsonObject().get("Items");
        return new Gson().fromJson(items, new TypeToken<List<Item>>(){}.getType());
    }

    public static Item getCartItem(String cookie, String requestId) {
        return getCartContext(cookie).stream()
                .filter((item) -> item.getId().equals(requestId)).findFirst().get();
    }

    public static void deleteItem(String requestId) {
        DeleteRequestBody requestBody = new DeleteRequestBody(requestId);

        given()
                .spec(spec.requestPostSpec)
                .body(requestBody)
                .post(deleteItem)
                .then()
                .spec(spec.responseSpecDel);
    }

    public static void testPrepareAction(String cookie, String requestId){
        int itemId = getItemId();
        addToCart(requestId, cookie, itemId);

        assertTrue(getCartContext(cookie).size() > 0);
    }
}
