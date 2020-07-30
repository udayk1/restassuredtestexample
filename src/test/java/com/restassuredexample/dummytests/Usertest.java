package com.restassuredexample.dummytests;

import com.google.gson.Gson;
import com.restassuredexample.util.PropertyLoader;
import com.restassuredexample.pojo.CreateUser;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Usertest {

    String baseUrl;
    Response response;
    public  Gson gson;
    CreateUser createUser;


    @BeforeClass
    public void setUp(){
        baseUrl = PropertyLoader.getUrl();
        gson = new Gson();
    }

    @Test
    public void createUser(){

        CreateUser createUser = new CreateUser();
        createUser.setName("User1");
        createUser.setJob("Software Engineer");
        String requestbody = gson.toJson(createUser).toString();
        response = given().contentType(ContentType.JSON).body(requestbody).when().post( baseUrl+"/users").then().extract().response();
        assertThat(response.getStatusCode(),equalTo(201));

    }

    @Test
    public void updateUser(){
        CreateUser createUser = new CreateUser();
        createUser.setName("UserUpdated");
        createUser.setJob("TitleUpdated");
        String requestbody = gson.toJson(createUser).toString();
        response = given().contentType(ContentType.JSON).body(requestbody).when().put(baseUrl+"/users/2").then().extract().response();
        assertThat(response.getStatusCode(),equalTo(200));

    }

    @Test
    public void deleteUser(){
        response = given().when().delete(baseUrl+"/users/2").then().extract().response();
        assertThat(response.getStatusCode(),equalTo(204));
    }


}
