package homeworkOne;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class QuestionTwo {
    @Test
    public void bookingId(){
        Response response = RestAssured.given().contentType(ContentType.ANY).pathParam("id", "175").get("https://restful-booker.herokuapp.com/booking/{id}");
        response.prettyPrint();
        String body= response.body().asString();
        System.out.println(body);
        String words[]=response.body().asString().split(":");

        for (String findWord : words) {
            String wantedWord = "Smith";
            if (Objects.equals(findWord, wantedWord)) {
                Assert.assertTrue(body.toLowerCase().contains(findWord));
            }
        }
//        Assert.assertTrue(body.contains("Smith"));
    }
}
