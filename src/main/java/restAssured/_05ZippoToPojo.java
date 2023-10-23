package restAssured;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.get;

public class _05ZippoToPojo {


    @Test
    public void test1(){
        Root root = get("https://api.zippopotam.us/tr/34110").as(Root.class);

        System.out.println(root.getPostCode());
        System.out.println(root.getPlaces().get(0).getStateAbbreviation());

    }


    @Data
    static class Place{
        public String placeName;    // place name
        public String longitude;
        public String state;
        public String stateAbbreviation; // state abbreviation
        public String latitude;


        @JsonProperty("place name")
        public void setPlaceName(String placeName) {
            this.placeName = placeName;
        }

        @JsonProperty("state abbreviation")
        public void setStateAbbreviation(String stateAbbreviation) {
            this.stateAbbreviation = stateAbbreviation;
        }
    }

    @Data
    static class Root{
        public String postCode; // post code
        public String country;
        public String countryAbbreviation;  // country abbreviation
        public ArrayList<Place> places;

        @JsonProperty("post code")
        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        @JsonProperty("country abbreviation")
        public void setCountryAbbreviation(String countryAbbreviation) {
            this.countryAbbreviation = countryAbbreviation;
        }
    }
}
