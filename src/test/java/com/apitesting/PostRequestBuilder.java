package com.apitesting;

public class PostRequestBuilder {
    private String baseUrl;
    private String endpoint;
    private String body;
    private String contentType;

    // Constructor
    public PostRequestBuilder() {
        // Default values
        this.baseUrl = "https://api.example.com";  // Default API base URL
        this.contentType = "application/json";    // Default content type
    }

    // Method to set the base URL
    public PostRequestBuilder withBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    // Method to set the endpoint
    public PostRequestBuilder withEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    // Method to set the body of the POST request
    public PostRequestBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    // Method to set the content type (e.g., JSON, XML, etc.)
    public PostRequestBuilder withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    // Method to execute the POST request
    public void executePost() {
        // Use RestAssured to send a POST request with the provided configurations
        io.restassured.RestAssured
                .given()
                .baseUri(baseUrl)
                .contentType(contentType)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .statusCode(201)  // Expected status code for successful creation
                .log().all();  // Log the response details
    }
}
