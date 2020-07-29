package com.restassuredexample.dummytests;

import com.google.gson.Gson;
import com.restassuredexample.pojo.EmpData;
import com.restassuredexample.pojo.EmpPersonalData;
import com.restassuredexample.pojo.EmpProfessionalData;
import com.restassuredexample.util.*;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.*;
import org.testng.Assert;
import static org.hamcrest.MatcherAssert.assertThat;

public class Employeetest {
    String baseUrl;
    Response response;
    @BeforeClass
    public void setUp(){
           baseUrl = PropertyLoader.getUrl();
    }

    @Test
    public void getEmployees(){
         response = given().
                when().
                get(baseUrl+ "/users/2").then().contentType(ContentType.JSON).extract().response();

         String s = response.asString();
         Gson gson = new Gson();
         EmpData empData = gson.fromJson(s,EmpData.class);
         EmpPersonalData empPersonalData = empData.getEmpPersonalData();
         EmpProfessionalData empProfessionalData = empData.getEmpProfessionalData();
        Assert.assertEquals(empData.getEmpPersonalData().getClass().getSimpleName(),"EmpPersonalData");
        Assert.assertEquals(empData.getEmpProfessionalData().getClass().getSimpleName(),"EmpProfessionalData");
        assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("empdataschema.json"));
    }

}


