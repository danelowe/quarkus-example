package com.example.web

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Test
import javax.ws.rs.core.MediaType

@QuarkusTest
class CustomersResourceTest {

    @Test
    fun testList() {
        given()
                .`when`()["/fruits"]
                .then()
                .statusCode(200)
                .body("$.size()", `is`(2),
                        "name", containsInAnyOrder("Apple", "Pineapple"),
                        "description", containsInAnyOrder("Winter fruit", "Tropical fruit"))
    }

    @Test
    fun testAdd() {
        given()
                .body("{\"name\": \"Pear\", \"description\": \"Winter fruit\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .`when`()
                .post("/fruits")
                .then()
                .statusCode(200)
                .body("$.size()", `is`(3),
                        "name", containsInAnyOrder("Apple", "Pineapple", "Pear"),
                        "description", containsInAnyOrder("Winter fruit", "Tropical fruit", "Winter fruit"))
        given()
                .body("{\"name\": \"Pear\", \"description\": \"Winter fruit\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .`when`()
                .delete("/fruits")
                .then()
                .statusCode(200)
                .body("$.size()", `is`(2),
                        "name", containsInAnyOrder("Apple", "Pineapple"),
                        "description", containsInAnyOrder("Winter fruit", "Tropical fruit"))
    }

}