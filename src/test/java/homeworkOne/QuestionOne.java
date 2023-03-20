package homeworkOne;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class QuestionOne {

    @Test
    public void countryName(){
        Response response = RestAssured.given().contentType(ContentType.ANY).pathParam("countryname", "turkey").get("https://restcountries.com/v3.1/name/{countryname}");
        response.prettyPrint();
        String body= response.body().asString();
        System.out.println(body);
        String words[]=response.body().asString().split(":");

        for (String findWord : words) {
            String wantedWord = "Ankara";
            if (Objects.equals(findWord, wantedWord)) {
                Assert.assertTrue(body.toLowerCase().contains(findWord));
            }
        }
//        Assert.assertTrue(body.contains("Ankara"));
    }
}
