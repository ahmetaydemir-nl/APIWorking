package test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_GetRequest {

    @Test
            public void get01() {
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        JSONObject expBody = new JSONObject();

        expBody.put("userId",5);
        expBody.put("title","optio dolor molestias sit");

        // response'u kaydet
        Response response = given().when().get(url);
        //response.prettyPrint();

        //Assertion

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        JsonPath  actBody = response.jsonPath();

        Assert.assertEquals(expBody.get("userId"),actBody.get("userId"));
        Assert.assertEquals(expBody.get("title"),actBody.get("title"));

    }

}
