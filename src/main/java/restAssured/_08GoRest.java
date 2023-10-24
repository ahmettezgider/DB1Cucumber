package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class _08GoRest {

    String accessToken = "935e64ef3f48d1b4d2967f9cf4890885fd3a7cd7c3105d1aa541572da7c32903";
    String authorization = "Bearer 935e64ef3f48d1b4d2967f9cf4890885fd3a7cd7c3105d1aa541572da7c32903";

    //List users
    //curl -i
    // -H "Accept:application/json"
    // -H "Content-Type:application/json"
    // -H "Authorization: Bearer ACCESS-TOKEN"
    // -XGET "https://gorest.co.in/public/v2/users"

    @BeforeClass
    public void beforeClass(){
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";
    }

    @Test(priority = 1)
    public void getAllUsers(){
        given()
                .header("Authorization", authorization)
                .accept(ContentType.JSON)
                .when()
                .get("/users")
                .then()
                .log().body()
                .statusCode(oneOf(200, 201))
                .contentType(ContentType.JSON)
                .body(not(empty()))
        ;
    }


    //Create user
    // -H "Accept:application/json"
    // -H "Content-Type:application/json"
    // -H "Authorization: Bearer ACCESS-TOKEN"
    // -XPOST "https://gorest.co.in/public/v2/users"
    // -d '{"name":"Tenali Ramakrishna",
    //      "gender":"male",
    //      "email":"tenali.ramakrishna@15ce.com",
    //      "status":"active"
    //    }'

    int id;

    @Test(priority = 2)
    public void createUser(){
        String email = getRandomEmail();
        String body = "" +
                "{\"name\":\"Ahmet T\",\n" +
                "   \"gender\":\"male\",\n" +
                "   \"email\":\"" + email + "\",\n" +
                "   \"status\":\"active\"\n" +
                "}";

        id = given()
                .header("Authorization", authorization)
                .header("Accept", "application/json")       // == .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/users")
                .then()
                .log().body()
                .statusCode(oneOf(200, 201))
                .body(not(empty()))
                .contentType(ContentType.JSON)
                .extract().jsonPath().getInt("id")
        ;

    }


    //Update user
    // -H "Accept:application/json"
    // -H "Content-Type:application/json"
    // -H "Authorization: Bearer ACCESS-TOKEN"
    // -XPATCH "https://gorest.co.in/public/v2/users/628347"
    // -d '{"name":"Allasani Peddana", "email":"allasani.peddana@15ce.com", "status":"active"}'

    @Test(priority = 3, dependsOnMethods = "createUser")
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


    //Delete user
    // -H "Accept:application/json"
    // -H "Content-Type:application/json"
    // -H "Authorization: Bearer ACCESS-TOKEN"
    // -XDELETE "https://gorest.co.in/public/v2/users/628347"

    @Test(priority = 4, dependsOnMethods = "createUser")
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
