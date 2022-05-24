package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.containsString;

public class Specifications {

    private static final String BASE_URI = "https://api.neverland.com";
    public RequestSpecification requestGetSpec = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .log(ALL)
            .build();

    public RequestSpecification requestPostSpec = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(JSON)
            .log(ALL)
            .build();

    public ResponseSpecification responseSpecOk = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();

    public ResponseSpecification responseSpecDel = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(containsString("Item deleted"))
            .expectContentType(JSON)
            .log(ALL)
            .build();
}
