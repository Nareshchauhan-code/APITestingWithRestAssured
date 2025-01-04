package com.apitesting;

import org.testng.annotations.Test;

public class GetRequestWithBuilderExample {

    @Test
    public void testGetWithBuilderPattern() {
        // Use the builder to create and execute the GET request
        new GetRequestBuilder()
                .withBaseUrl("https://reqres.in/")  // Set base URL
                .withEndpoint("api/users")                  // Set the endpoint
                .withQueryParam("page", "2")             // Set query parameter (e.g., filter users by age)
                .withQueryParam("", "")          // Another query parameter (e.g., filter by name)
                .withContentType("application/json")     // Set content type to JSON (optional for GET)
                .executeGet();  // Execute the GET request
    }
}
