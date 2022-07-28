package test;

import TestData.JsonPlaceHolderTestData;
import baseURLStorage.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class API_BaseURL_TestDataKullanimi extends JsonPlaceHolderBaseURL {


    @Test
        public void test01(){

        specJsonPlace.pathParam("pp1",22);

        JsonPlaceHolderTestData JsonPlaceHolder = new JsonPlaceHolderTestData();

        JSONObject expBody = JsonPlaceHolder.expectedData();


        Response response =given().spec(specJsonPlace).when().get("{pp1}");

        JsonPath respJSPath = response.jsonPath();
        assertEquals(JsonPlaceHolder.StatusCode, response.getStatusCode());
        assertEquals(expBody.getInt("userId"), respJSPath.getInt("userId"));
        assertEquals(expBody.getInt("id"), respJSPath.getInt("id"));
        assertEquals(expBody.getString("title"), respJSPath.getString("title"));
        assertEquals(expBody.getString("body"), respJSPath.getString("body"));

    }
}
