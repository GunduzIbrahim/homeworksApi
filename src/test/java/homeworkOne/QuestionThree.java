package homeworkOne;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class QuestionThree {
    @Test
    public void bookingId() {
        Response response = RestAssured.given().contentType(ContentType.ANY).queryParam("key", "9324336").get("http://www.boredapi.com/api/activity");
        response.prettyPrint();
        String body = response.body().asString();
        System.out.println(body);
        String words[]=response.body().asString().split(":");

        for (String findWord : words) {
            String expected = "Clean out your refrigerator";
            if (Objects.equals(findWord, expected)) {
                Assert.assertEquals(body, expected);
            }
        }
    }
}
