package com.apitesting;


import org.testng.annotations.Test;

public class PostRequestWithBuilderExample {

    @Test
    public void testPostWithBuilderPattern() {
        // JSON body to send in the POST request
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        // Use the builder to create and execute the POST request
        new PostRequestBuilder()
                .withBaseUrl("https://reqres.in/")  // Set base URL
                .withEndpoint("/api/users")  // Set API endpoint
                .withBody(requestBody)  // Set the request body
                .withContentType("application/json")  // Set content type to JSON
                .executePost();  // Execute the POST request
    }
}
