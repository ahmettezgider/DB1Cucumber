package restAssured.models;

import lombok.Data;

@Data
public class User {
    int id;
    String name;
    String username;
    String email;
    Address address;
    String phone;
    String website;
    Company company;
}
