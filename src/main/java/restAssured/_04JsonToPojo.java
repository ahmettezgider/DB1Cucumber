package restAssured;

import lombok.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.get;

public class _04JsonToPojo {



    // get All Body to pojo
    @Test
    public void test1_JsonToPojo(){
        JsonBody user = get("https://reqres.in/api/users/1").as(JsonBody.class);
        System.out.println(user);
    }


    // if the json object is an array
    @Test
    public void test2_JsonToPojo(){
        User1[] users = get("https://gorest.co.in/public/v2/users").as(User1[].class);
        for (User1 user : users) {
            System.out.println(user);
            System.out.println("--------");
        }
        System.out.println("################");
        Arrays.stream(users)
                .filter(user->user.id % 2 == 0)
                .forEach(System.out::println);
    }

    // if the json object is an array
    @Test
    public void test2_JsonToPojo2(){
        List<User1> users = get("https://gorest.co.in/public/v2/users")
                .jsonPath().getList("", User1.class)
                ;
        for (User1 user : users) {
            System.out.println(user);
            System.out.println("--------");
        }
    }

    // with jsonPath
    @Test
    public void test3_JsonToPojo(){
        List<UserData> list = get("https://reqres.in/api/users")
                .jsonPath().getList("data", UserData.class)
        ;

        for (UserData userData : list) {
            System.out.println(userData);
            System.out.println("--------");
        }

    }





    @Data
    static class JsonBody{
        public UserData data;
        public Support support;
    }

    @Data
    static class UserData{
        public int id;
        public String email;
        public String first_name;
        public String last_name;
        public String avatar;


    }

    @Data
    static class Support{
        public String url;
        public String text;

        @Override
        public String toString() {
            return "\n\nSupport{" +
                    "url='" + url + '\'' +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    /*
        "id": 5463934,
        "name": "Chidaatma Shah",
        "email": "chidaatma_shah@lowe.example",
        "gender": "female",
        "status": "inactive"
     */
    @Data
    static class User1{
        int id;
        String name;
        String email;
        String gender;
        String status;
    }

}
