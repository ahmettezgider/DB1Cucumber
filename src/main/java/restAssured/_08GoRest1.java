package restAssured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class _08GoRest1 {

    String authorization = "Bearer 935e64ef3f48d1b4d2967f9cf4890885fd3a7cd7c3105d1aa541572da7c32903";

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;


    @Before
    public void beforeClass(){
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";

        requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", authorization)
                .setContentType(ContentType.JSON)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(oneOf(200, 201, 204))
                .expectContentType(ContentType.JSON)
                .build();



    }

    @Test
    @Order(1)
    public void getAllUsers(){
        given()
                .spec(requestSpecification)
                .when()
                .get("/users")
                .then()
                .log().body()
                .spec(responseSpecification)
                .body(not(empty()))
        ;
    }


    int id;

    @Test
    @Order(2)
    public void createUser(){
        String email = getRandomEmail();
        String body = "" +
                "{\"name\":\"Ahmet T\",\n" +
                "   \"gender\":\"male\",\n" +
                "   \"email\":\"" + email + "\",\n" +
                "   \"status\":\"active\"\n" +
                "}";

        id = given()
                .spec(requestSpecification)
                .body(body)
                .when()
                .post("/users")
                .then()
                .log().body()
                .spec(responseSpecification)
                .body(not(empty()))
                .extract().jsonPath().getInt("id")
        ;

    }


    @Test
    @Order(3)
    public void updateUser(){
        String email = getRandomEmail();
        String body = "" +
                "{ \"name\":\"Ahmet TT\", " +
                "   \"email\":\"" + email + "\", " +
                "   \"status\":\"active\"" +
                "}";
        given()
                .header("Authorization", authorization)
                .header("Accept", "application/json")       // == .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .patch("/users/" + id)
                .then()
                .log().body()
                .statusCode(oneOf(200, 201, 204))
                .contentType(ContentType.JSON)
                .body(not(empty()))
                .body("email", equalTo(email))
        ;

    }


    @Test
    @Order(4)
    public void deleteUser(){
        given()
                .header("Authorization", authorization)
                .header("Accept", "application/json")       // == .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .delete("/users/" + id)
                .then()
                .log().body()
                .statusCode(oneOf(200, 201, 204))
        ;

    }



    public String getRandomEmail(){
        return RandomStringUtils.randomAlphabetic(10) +
                "@" +
                RandomStringUtils.randomAlphabetic(4).toLowerCase() +
                "." +
                RandomStringUtils.randomAlphabetic(3).toLowerCase();
    }


}
