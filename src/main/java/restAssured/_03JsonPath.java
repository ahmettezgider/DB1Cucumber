package restAssured;

import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class _03JsonPath {


    @Test
    public void test1(){
        get("https://jsonplaceholder.typicode.com/comments")
                .prettyPrint();
    }

    @Test
    public void test2(){
        String json = get("https://jsonplaceholder.typicode.com/comments").asString();
        System.out.println(json);
    }

    @Test
    public void test3(){
        Response response = get("https://jsonplaceholder.typicode.com/comments");
        //Response response = get("https://jsonplaceholder.typicode.com/comments").then().extract().response();
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void test4() {
        Response response = get("https://jsonplaceholder.typicode.com/comments");

        response.then()
                .log().body()
                .body("[0].id", equalTo(1))
                .body("email",hasSize(500))     // email'leri list olarak secer
        ;

    }

    @Test
    public void test5_JsonPath() {
        Response response = get("https://reqres.in/api/users/1");

        String email = response.then()
                .log().body()
                .extract().jsonPath().get("data.email")
        ;

        int id = response.then()
                        .extract().jsonPath().getInt("data.id");

        System.out.println(id + " - " + email);
    }

    @Test
    public void test6_JsonPath() {
        Response response = get("https://reqres.in/api/users");

        List<String> list = response.then()
                .log().body()
                .extract().jsonPath().getList("data.email")
        ;

        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void test7_JsonPath() {
        Response response = get("https://reqres.in/api/users");

        //List<String> list = response.jsonPath().getList("data.email");
        List<String> list = response.then()
                .log().body()
                .extract().jsonPath().getList("data.findAll{it.id<3}.email");

        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void test8_JsonPath() {
        Response response = get("https://reqres.in/api/users");

        String chr = response.jsonPath()
                .get("data.find{it.first_name=='Charles'}.email");
        System.out.println(chr);
    }

    @Test
    public void test9_JsonPath_ObjectToMap() {
        Response response = get("https://reqres.in/api/users");

        String chr = response.jsonPath()
                .get("data.find{it.first_name=='Charles'}").toString();
        System.out.println(chr);

        System.out.println("---------------");

        Map<String, ?> map = response.jsonPath()
                .getMap("data.find{it.first_name=='Charles'}");

        System.out.println(map);
        map.forEach((k,v)-> System.out.println(k + " : " + v));
    }

    @Test
    public void test10_JsonPath_ObjectsToMaps() {
        Response response = get("https://reqres.in/api/users");

        String chr = response.jsonPath().get("data").toString();
        System.out.println(chr);

        System.out.println("---------------");

        //ArrayList<Map<String, ?>> maps = response.jsonPath().get("data.findAll{it.id>2}");
        ArrayList<Map<String, ?>> maps = response.jsonPath().get("data");

        for (Map<String, ?> map : maps) {
            map.forEach((k,v)-> System.out.println(k + " : " + v));
            System.out.println("---");
        }

    }


    @Test
    public void test11_JsonPath_ObjectsToMaps() {
        Response response = get("https://jsonplaceholder.typicode.com/comments");

        ArrayList<Map<String, ?>> maps = response.jsonPath().get();
        System.out.println(maps.size());
    }

}
