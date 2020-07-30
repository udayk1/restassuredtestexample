package com.restassuredexample.dummytests;

import com.google.gson.Gson;
import com.restassuredexample.pojo.EmpData;
import com.restassuredexample.pojo.EmpPersonalData;
import com.restassuredexample.pojo.EmpProfessionalData;
import com.restassuredexample.util.PropertyLoader;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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

         Gson gson = new Gson();
         EmpData empData = gson.fromJson(response.asString(),EmpData.class);
         EmpPersonalData empPersonalData = empData.getEmpPersonalData();
         EmpProfessionalData empProfessionalData = empData.getEmpProfessionalData();
         assertThat(response.getStatusCode(),equalTo(200));
        assertThat(empData.getEmpPersonalData().getClass().getSimpleName(),equalTo("EmpPersonalData"));
        assertThat(empData.getEmpProfessionalData().getClass().getSimpleName(),equalTo("EmpProfessionalData"));
        assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("empdataschema.json"));
    }


}



