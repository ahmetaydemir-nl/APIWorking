package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_PostRequest {
    @Test
    public void  post01(){


        String url = "https://jsonplaceholder.typicode.com/posts";
        JSONObject reqBody = new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);


        JSONObject expBody = new JSONObject();
        expBody.put("title","API");
        expBody.put("body","API ogrenmek ne guzel");
        expBody.put("userId",10);

        Response response = given().contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                post(url);

        JsonPath actBody = response.jsonPath();


        response.then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(201);

        Assert.assertEquals(expBody.get("title"),actBody.get("title"));
        Assert.assertEquals(expBody.get("body"),actBody.get("body"));
        Assert.assertEquals(expBody.get("userId"),actBody.get("userId"));


    }
}
