package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Info;

import static constants.Endpoints.*;
import static io.restassured.RestAssured.given;

public class RequestData {
    public static Response postInfo(Info f){
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .body(f)
                .post(API_POST);
        return res;
    }
    public static Response putInfo(Info f){
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .body(f)
                .put(API_PUT);
        return res;

    }
    public static Response test()
    {
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get(API_GETDATA);
        return res;
    }
    public static Response getTest(int id)
    {
        Response response = RestAssured.get(API_GET,id);
        return response;
    }
    public static Response del(int id)
    {
        Response response = RestAssured.delete(API_DEL,id);
        return response;
    }

}
