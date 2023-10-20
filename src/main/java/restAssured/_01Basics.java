package restAssured;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class _01Basics {

    /*
        Rest assured -> backend testleri
        BDD mantiginda yazilir

        given() -> ön kosullar,
        when()  -> yapilan islem, method (GET, POST, ...)
        then()  -> assertions

     */


    @Test
    public void test01_BasicUsage(){
        given()
                .when()
                .then();

    }


    @Test
    public void test02_getAndLog(){
        given()
                //.log().headers()      // request'in header bilgilerini consola yazdirir
                .when()
                .get("https://reqres.in/api/users?page=1")
                .then()
                //.log().body()       // log, istenilen kismi consola yazdirir, body consola yazdirilacak
                //.log().all()
                .log().headers()      // respons'un header bilgilerini consola yazdirir
        ;
    }

    @Test
    public void test03_statusCode(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=1")
                .then()
                .log().status() // status consola yazdirilir
                .statusCode(200)   // response statusCode 200 olmali
                .contentType(ContentType.JSON) // response contentType JSON olmali
        ;
    }

    @Test
    public void test04_responseTime(){
        String url = "https://reqres.in/api/users?page=1";

        get(url)
                .then()
                .statusCode(200);

        long time = get(url)
                .timeIn(TimeUnit.MILLISECONDS);

        System.out.println(time);

    }

    @Test
    public void test05_prettyPrint(){
        String url = "https://reqres.in/api/users?page=1";

        Response response = get(url)
                .then()
                .extract()          // istenilen datayi ayirmak icin kullanilir
                .response();        // response extract edildi

        response.prettyPrint();     // response'u pretty print (beautify) yapti

        response
                .then()
                .statusCode(200);
    }

    @Test
    public void test06_pathParams() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=1")
                .then()
                .statusCode(200);


        given()
                .pathParam("page", "1")
                .pathParam("link", "api")
                .when()
                .get("https://reqres.in/{link}/users?page={page}")
                .then()
                .statusCode(200)
                .log().status();
    }


    // https://reqres.in/api/users/4
    // adresinde id'si 1,2,3,4,5 olan kullanici bilgilerini consola yazdirin

    @Test
    public void test07_getSingleUser(){
        for (int i = 1; i < 3; i++) {
            getSingleUser(i);
        }
    }

    public void getSingleUser(int id){
        String url = "https://reqres.in/api/users/{id}";
        given()
                .pathParam("id", id)
                .when()
                .get(url)
                .prettyPrint();
    }



    @Test
    public void test07_BaseUri(){
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";

        // path = baseURI + basePath + {endPoint}

        given()
                .when()
                .get("/users/1")
                .then()
                .log().body();

        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().body();
    }


}
