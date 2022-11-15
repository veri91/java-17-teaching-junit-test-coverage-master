package com.comviva.exercise.utils;

import com.comviva.exercise.controller.request.AddBookRequest;
import com.comviva.exercise.controller.request.AddStudentRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.graalvm.polyglot.Value;

public class APICall extends BaseTest {

    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";

    public static Response addStudent(AddStudentRequest request) {
        RestAssured.baseURI = "http://localhost:40080/api/v1/student";
        RequestSpecification requestSpecification =
                RestAssured.given()
                        .header(CONTENT_TYPE, APPLICATION_JSON)
                        .body(JsonUtils.toJsonString(request));
        return requestSpecification.post();
    }

    public static Response getStudent(String studentId) {
        RestAssured.baseURI = "http://localhost:40080/api/v1/student/" + studentId;
        RequestSpecification requestSpecification =
                RestAssured.given().header(CONTENT_TYPE, APPLICATION_JSON);
        return requestSpecification.get();
    }

    public static Response addBook(AddBookRequest request) {
        RestAssured.baseURI = "http://localhost:40080/api/v1/book";
        RequestSpecification requestSpecification =
                RestAssured.given()
                        .header(CONTENT_TYPE, APPLICATION_JSON)
                        .body(JsonUtils.toJsonString(request));
        return requestSpecification.post();
    }

    public static Response getBook(String request) {
        RestAssured.baseURI = "http://localhost:40080/api/v1/book/" + request;
        RequestSpecification requestSpecification =
                RestAssured.given()
                        .header(CONTENT_TYPE, APPLICATION_JSON);
        return requestSpecification.get();
    }

}
