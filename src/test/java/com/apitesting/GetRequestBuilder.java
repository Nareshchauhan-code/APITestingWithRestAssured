package com.apitesting;

import java.util.HashMap;
import java.util.Map;

public class GetRequestBuilder {
    private String baseUrl;
    private String endpoint;
    private String contentType;
    private Map<String, String> queryParams; // Query parameters for GET request

    // Constructor
    public GetRequestBuilder() {
        this.baseUrl = "https://api.example.com";  // Default base URL
        this.contentType = "application/json";    // Default content type
        this.queryParams = new HashMap<>();        // Initialize query params map
    }

    // Method to set the base URL
    public GetRequestBuilder withBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    // Method to set the endpoint
    public GetRequestBuilder withEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    // Method to set query parameters (for GET request)
    public GetRequestBuilder withQueryParam(String key, String value) {
        this.queryParams.put(key, value);
        return this;
    }

    // Method to set content type (optional for GET)
    public GetRequestBuilder withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    // Method to execute the GET request
    public void executeGet() {
        // Use RestAssured to send a GET request with the provided configurations
        io.restassured.RestAssured
                .given()
                .baseUri(baseUrl).log().all()            // Set base URL
                .contentType(contentType)    // Set content type
                .queryParams(queryParams)    // Set query parameters
                .when()
                .get(endpoint)               // Perform GET request on the endpoint
                .then()
                .statusCode(200)             // Expected status code for a successful GET request
                .log().all();                // Log the response details for debugging
    }
}
