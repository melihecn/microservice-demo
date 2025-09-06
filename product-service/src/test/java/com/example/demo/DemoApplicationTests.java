package com.example.demo;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
// 8080de değil de başka bir portta calısması için, conflict yaratmıyor
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @ServiceConnection // spring otomatik olarak mongo db urlini koyuyor
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mongoDBContainer.start();

    }

    @Test
    void shouldCreateProduct() {
        String requestBody = """
                {
                    "name":"iphone",
                    "description":"good",
                    "price":100
                }
                """;
        // rest assured api için end to end integration testing kütüphanesi gerçek network trafiği.
        // junit + mockito genel unit ve db integration için.
        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .then()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.is("iphone"))
                .body("description", Matchers.is("good"))
                .body("price", Matchers.is(100));
    }

}
