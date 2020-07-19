package com.restassuredexample.dummytests;

import com.restassuredexample.util.*;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.testng.annotations.*;
import static org.hamcrest.Matchers.*;

public class test {
    String baseUrl;
    @BeforeClass
    public void setUp(){
           baseUrl =propertyLoader.getUrl();
    }

    @Test
    public void getEmployees(){
        given().
                when().
                get(baseUrl+"/employees").
                then().contentType(ContentType.JSON).statusCode(200);

    }

}
