package api;

import constants.TestData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.DataWeather;
import models.Info;

import static constants.Endpoints.*;
import static io.restassured.RestAssured.given;

public class RequestData {
    public static Response postInfo(Info f) {
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .body(f)
                .post(API_POST);
        return res;
    }

    public static Response putInfo(Info f) {
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .body(f)
                .put(API_PUT);
        return res;

    }

    public static Response test() {
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get(API_GETDATA);
        return res;
    }

    public static Response getTest(int id) {
        Response response = RestAssured.get(API_GET, id);
        return response;
    }

    public static Response del(int id) {
        Response response = RestAssured.delete(API_DEL, id);
        return response;
    }
    public static Response getDes() {
        DataWeather data=new DataWeather();
        data.setQ(TestData.Q);
        data.setAppid(TestData.APP_ID);
        Response response = given()
                .queryParam("q",data.getQ())
                .queryParam("appid",data.getAppid())
                .get(API_GET_DES);
        return response;
    }

    public static Response getProfile() {
        Response res = given()
                .contentType(ContentType.JSON)
                .header("authority", "rc-api.onecard.fun")
                .header("accept", "application/json, text/plain, */*")
                .header("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cmFuZ3J1YS5uZ3V5ZW4ra3ljM0BnbWFpbC5jb20iLCJyb2xlcyI6InVzZXIiLCJpZCI6MTAwMDc2MCwiaWF0IjoxNTk0ODMwMDI5LCJleHAiOjE1OTQ4NDA4Mjl9.-ONHGeOhrPVLqG7GzQkV4RQX-uaCwVk6PXUiE42aiTA")
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36")
                .header("origin", "https://rc-user.onecard.fun")
                .header("sec-fetch-site", "same-site")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-dest", "empty")
                .header("referer", "https://rc-user.onecard.fun/")
                .header("accept-language", "vi-VN,vi;q=0.9,fr-FR;q=0.8,fr;q=0.7,en-US;q=0.6,en;q=0.5,ja;q=0.4")
                .when()
                .get("https://rc-api.onecard.fun/api/my/profile");
        return res;
    }
}
