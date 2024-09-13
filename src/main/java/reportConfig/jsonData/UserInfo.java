package reportConfig.jsonData;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class UserInfo {
    public static UserInfo get(String filename) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(filename), UserInfo.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("firstname")
    String firstname;

    @JsonProperty("lastname")
    String lastname;

    @JsonProperty("email")
    String email;

    @JsonProperty("password")
    String password;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getpassword() {
        return password;
    }

    public Checkout getCheckout() {
        return checkout;
    }

    @JsonProperty("checkout")
    Checkout checkout;

    static class Checkout {
        @JsonProperty("discount")
        String discount;
    }
    public String getDiscount() {
        return checkout.discount;
    }
}
