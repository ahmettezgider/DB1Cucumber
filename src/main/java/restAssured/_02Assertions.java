package restAssured;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class _02Assertions {

    @Test
    public void test01(){
        given()
                .when()
                .get("https://reqres.in/api/users/1")
                .then()
                .log().body()
                .body("data.id", equalTo(1))
                .body("data.first_name", equalTo("George"))
                .body(containsString("data"))
                .body("data", hasKey("id"))
                .body("data.id", lessThan(5))
                .body(not(empty()))
        ;
    }

    @Test
    public void test02(){
        given()
                .pathParam("page", 2)
                .when()
                .get("https://reqres.in/api/users?page={page}")
                .then()
                .contentType(ContentType.JSON)
                .log().body()
                .statusCode(200)

                // page==2 olmali
                .body("page", equalTo(2))
                // datanin ilk objesinin first_name== Michael olmali
                .body("data[0].first_name", equalTo("Michael"))
                // body nin "support" isimli keyi olmali
                .body("",hasKey("support"))
                .body("$",hasKey("support"))    // $ root json'i ifade eder
                // body "contributions" metni icermeli
                .body(containsString("contributions"))
                // data.first_name icinde "Michael" ve "Lindsay" olmali
                .body("data.first_name", hasItems("Michael", "Lindsay"))


        ;
    }


}
