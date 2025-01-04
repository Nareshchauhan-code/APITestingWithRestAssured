package com.apitesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRequest {

    @Test
    public void TC01() {

        RequestSpecification requestSpecification = given().baseUri("https://reqres.in");
        Response res = requestSpecification.get("/api/users/2");

        // System.out.println(res.asString());
        //System.out.println(res.prettyPrint());
        //System.out.println(res.statusCode());

        ResponseBody responseBody = res.getBody();
        System.out.println(responseBody.print());

        int expectedStatusCode = 200;
        int statusCode = res.getStatusCode();

        Assert.assertEquals(statusCode, expectedStatusCode);
    }

    @Test
    public void TC02() {

        Response res = given().baseUri("https://reqres.in").log().headers().
                when().get("/api/users/2").
                then().extract().response();

        System.out.println("Response Body Print : "+res.getBody().prettyPrint());
        System.out.println("Response Headers Print : "+res.getHeaders());
        System.out.println("Status Code Print : "+res.getStatusCode());
    }
}
