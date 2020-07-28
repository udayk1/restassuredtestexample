package com.restassuredexample.dummytests;

import com.google.gson.Gson;
import com.restassuredexample.pojo.EmpData;
import com.restassuredexample.pojo.EmpPersonalData;
import com.restassuredexample.pojo.EmpProfessionalData;
import com.restassuredexample.util.*;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.*;
import org.testng.Assert;


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
                get("https://reqres.in/api/users/2").then().contentType(ContentType.JSON).extract().response();

         String s = response.asString();
         Gson gson = new Gson();
         EmpData empData = gson.fromJson(s,EmpData.class);
         EmpPersonalData empPersonalData = empData.getEmpPersonalData();
         EmpProfessionalData empProfessionalData = empData.getEmpProfessionalData();
        Assert.assertEquals(empData.getEmpPersonalData().getClass().getSimpleName(),"EmpPersonalData");
        Assert.assertEquals(empData.getEmpProfessionalData().getClass().getSimpleName(),"EmpProfessionalData");
        //Assert.assertEquals(response.body(matches));

    }

}


