package com.demo.cicdpipeline.demoservice1.it;

import com.demo.cicdpipeline.demoservice1.Demoservice1ApplicationTests;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demoservice1ApplicationTests.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoControllerTestIT {

    @Value("${local.server.port}")
    private String serverPort;

    @Before
    public void setUp(){

        RestAssured.port = Integer.valueOf(serverPort);
    }

    @Test
    public void testShouldGetSuccessRes(){

        ValidatableResponse auth = given().get(RestAssured.baseURI + "/get/test").then().
                defaultParser(Parser.JSON);

        auth.assertThat().statusCode(HttpStatus.OK.value()).
                body(matchesJsonSchemaInClasspath("schemafiles/gettestschema.json"));

        System.out.println("**********INTEGRATIONN TEST EXECUTED************");

//        when().get("/amazon/test")

    }
}
