package restAssured;

import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class _06JsonShema {

    String jsonSchema = "{\n" +
            "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
            "  \"type\": \"object\",\n" +
            "  \"properties\": {\n" +
            "    \"data\": {\n" +
            "      \"type\": \"object\",\n" +
            "      \"properties\": {\n" +
            "        \"id\": {\n" +
            "          \"type\": \"integer\"\n" +
            "        },\n" +
            "        \"email\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"first_name\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"last_name\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"avatar\": {\n" +
            "          \"type\": \"string\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"required\": [\n" +
            "        \"id\",\n" +
            "        \"email\",\n" +
            "        \"first_name\",\n" +
            "        \"last_name\",\n" +
            "        \"avatar\"\n" +
            "      ]\n" +
            "    },\n" +
            "    \"support\": {\n" +
            "      \"type\": \"object\",\n" +
            "      \"properties\": {\n" +
            "        \"url\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"text\": {\n" +
            "          \"type\": \"string\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"required\": [\n" +
            "        \"url\",\n" +
            "        \"text\"\n" +
            "      ]\n" +
            "    }\n" +
            "  },\n" +
            "  \"required\": [\n" +
            "    \"data\",\n" +
            "    \"support\"\n" +
            "  ]\n" +
            "}";

    @Test
    public void jsonShemaVaidator(){

        get("https://reqres.in/api/users/2")
                .then()
                .body(matchesJsonSchema(jsonSchema));

    }
}
