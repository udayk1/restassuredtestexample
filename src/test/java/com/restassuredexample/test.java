package com.restassuredexample;


import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.testng.annotations.*;
import static org.hamcrest.Matchers.*;

public class test {

    @Test
    public void getEmployees(){
        given().
                when().
                get("http://dummy.restapiexample.com/api/v1/employees").
                then().contentType(ContentType.JSON).statusCode(200);

    }

}
