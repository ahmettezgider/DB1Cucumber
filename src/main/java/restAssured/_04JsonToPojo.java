package restAssured;

import lombok.Data;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.get;

public class _04JsonToPojo {




    @Test
    public void test1_JsonToPojo(){
        JsonBody user = get("https://reqres.in/api/users/1").as(JsonBody.class);
        System.out.println(user);
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

}
