package com.parasoft.parabank.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginAPITest {

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "https://parabank.parasoft.com";
    }

    @Test
    public void testHomePageIsReachable() {
        Response response = RestAssured
                .given()
                .when()
                .get("/parabank/index.htm")
                .then()
                .extract().response();

        assertThat(response.getStatusCode(), is(200));
        assertThat(response.asString(), containsString("ParaBank"));
    }
}
