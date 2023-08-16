package Test.API;

import com.shaft.driver.SHAFT;
import org.python.antlr.ast.Str;
import org.python.modules._json._json;
import org.testng.annotations.Test;

public class FirstApiWithSHAFT {
    String baseURL= "https://restful-booker.herokuapp.com";
    SHAFT.API api = new SHAFT.API(baseURL);
    String tokenValue;
    String userId;
    @Test
    public void createTokenTest(){
        String userBody = """
                {
                    "username" : "admin",
                    "password" : "password123"
                }
                """;
        api.post("/auth").
                setContentType("application/json").
                setRequestBody(userBody)
                .setTargetStatusCode(200)
                .perform();
        tokenValue = api.getResponseJSONValue("token");
    }
    @Test
    public void createUser(){
        String userDataBody = """
                {
                     "firstname" : "Jim",
                     "lastname" : "Brown",
                     "totalprice" : 111,
                     "depositpaid" : true,
                     "bookingdates" : {
                         "checkin" : "2018-01-01",
                         "checkout" : "2019-01-01"
                     },
                     "additionalneeds" : "Breakfast"
                 }
                """;
        api.post("/booking").
                setContentType("application/json").
                setRequestBody(userDataBody)
                .setTargetStatusCode(200)
                .perform();
        userId = api.getResponseJSONValue("bookingid");
        api.assertThatResponse().extractedJsonValue("booking.firstname").isEqualTo("Jim").perform();
    }
    @Test
    public void updateBookingTest(){
        String requestBody = """
                {
                    "firstname" : "A5oya El Team Lead AhmedKhaled14",
                    "lastname" : "Brown",
                    "totalprice" : 111,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2018-01-01",
                        "checkout" : "2019-01-01"
                    },
                    "additionalneeds" : "Breakfast"
                }
                """;
        api.put("/booking/"+userId).
                setContentType("application/json")
                .addHeader("Cookie","token="+tokenValue)
                .setRequestBody(requestBody)
                .setTargetStatusCode(200)
                .perform();
        api.assertThatResponse().extractedJsonValue("firstname").isEqualTo("A5oya El Team Lead AhmedKhaled14").perform();
    }
}

