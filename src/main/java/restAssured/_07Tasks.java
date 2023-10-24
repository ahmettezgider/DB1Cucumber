package restAssured;

import io.restassured.http.ContentType;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import restAssured.models.User;

import java.util.List;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.containsString;

public class _07Tasks {


    /** Task 1
     * create a request to https://httpstat.us/203
     * expect status 203
     * expect content type TEXT
     */

    @Test
    public void task1(){
        get("https://httpstat.us/203")
                .then()
                .log().body()
                .statusCode(203)
                .contentType(ContentType.TEXT)
        ;
    }

    /** Task 2
     * create a request to https://httpstat.us/203
     * expect status 203
     * expect content type TEXT
     * expect BODY to be equal to "203 Non-Authoritative Information"
     */

    @Test
    public void task2(){
        get("https://httpstat.us/203")
                .then()
                .log().body()
                .statusCode(203)
                .contentType(ContentType.TEXT)
                .body(containsString("203 Non-Authoritative Information"))
        ;

        String body = get("https://httpstat.us/203").asString();
        Assert.assertTrue(body.contains("203 Non-Authoritative Information"));

    }


    /** Task 3
     *  create a request to https://jsonplaceholder.typicode.com/todos/2
     *  expect status 200
     *  expect content type JSON
     *  expect title in response body to be "quis ut nam facilis et officia qui"
     */


    /** Task 4
     * create a request to https://jsonplaceholder.typicode.com/todos/2
     *  expect status 200
     *  expect content type JSON
     *  expect response completed status to be false
     */

    /** Task 5
     * create a request to https://jsonplaceholder.typicode.com/todos
     * expect status 200
     * expect content type JSON
     * expect third item have:
     *      title = "fugiat veniam minus"
     *      userId = 1
     */

    /** Task 6
     * create a request to https://jsonplaceholder.typicode.com/todos/2
     * expect status 200
     * Converting Into POJO
     */

    @Test
    public void test6(){
        ToDo todo = get("https://jsonplaceholder.typicode.com/todos/2")
                .as(ToDo.class);

        System.out.println("todo.getId() = " + todo.getId());
        System.out.println("todo.getUserId() = " + todo.getUserId());
        System.out.println("todo.getTitle() = " + todo.getTitle());
        System.out.println("todo.isCompleted() = " + todo.isCompleted());
    }



    /*
      {
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
       }
     */
    @Data
    static class ToDo{
        int userId;
        int id;
        String title;
        boolean completed;
    }

    /** Task 7
     * create a request to https://jsonplaceholder.typicode.com/todos
     * expect status 200
     * Converting Array Into Array of POJOs
     */

    @Test
    @Order(1)
    public void test7(){
        List<ToDo> todos = get("https://jsonplaceholder.typicode.com/todos")
                .then()
                //.log().body()
                .extract().jsonPath().getList("", ToDo.class);
        System.out.println(todos.size());

        // completed true olanlarin title'larini consol'a yazdirin
        int count = 0;
        for (ToDo todo : todos) {
            if (todo.isCompleted()) {
                count++;
                System.out.println(count + ". " + todo.getTitle());
            }
        }
        System.out.println(" True Sayisi : " + count);
    }

    @Test
    public void test71(){
        List<ToDo> todos = get("https://jsonplaceholder.typicode.com/todos")
                .then()
                .extract().jsonPath().getList("findAll{it.completed==true}", ToDo.class);
        System.out.println(todos.size());
    }

    @Test
    public void test72(){
        List<String> titles = get("https://jsonplaceholder.typicode.com/todos")
                .then()
                .extract().jsonPath().getList("findAll{it.completed==true}.title");
        System.out.println(titles.size());
        System.out.println(titles);
    }


    /** Task 8
     * https://jsonplaceholder.typicode.com/users
     * adresindeki kullanicilari POJO'ya aktariniz
     */

    @Test
    public void test8(){
        User user = get("https://jsonplaceholder.typicode.com/users/1").as(User.class);
        System.out.println(user);
    }



    /** Task 9
     * https://jsonplaceholder.typicode.com/users
     * https://jsonplaceholder.typicode.com/albums
     * name'i Ervin Howell olan user'in album isimlerini ve sayisini bulunuz
     */



}


/*
{
    "id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
        "street": "Kulas Light",
        "suite": "Apt. 556",
        "city": "Gwenborough",
        "zipcode": "92998-3874",
        "geo": {
            "lat": "-37.3159",
            "lng": "81.1496"
        }
    },
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
        "name": "Romaguera-Crona",
        "catchPhrase": "Multi-layered client-server neural-net",
        "bs": "harness real-time e-markets"
    }
}


 */