package TestApi;

import Base.BaseTest;
import api.RequestData;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestGet extends BaseTest {
    @Test
    public void test_1() {
        Response res = RequestData.getTest(2);
        softAssertion.assertEquals(200,res.getStatusCode());
        softAssertion.assertEquals("janet.weaver@reqres.in", res.jsonPath().get("data.email"));
        softAssertion.assertAll();
    }
    @Test
    public void test_05() {
        Response response = RequestData.test();
        List<Map<String, String>> jsonResponse = response.jsonPath().getList("data");
        Boolean check =false;
        for (Map<String, String> s: jsonResponse)
        {
            if (s.get("name").contains("tigerlily"))
            {
                check=true;
            }
        }
        softAssertion.assertTrue(check);
    }
    //@Description("Hello")
    @Test
    public void test_06(){
        Response response=RequestData.getDes("London,uk");
        softAssertion.assertEquals(200,response.getStatusCode());
        List<Map<String, String>> jsonResponse = response.jsonPath().getList("weather");
        boolean check =false;
        for (Map<String, String> s: jsonResponse) {
            if (s.get("description").contains("light intensity drizzle")) {
                check = true;
            }
        }
        softAssertion.assertTrue(check);
        softAssertion.assertEquals(response.jsonPath().get("name"),"London");
        softAssertion.assertAll();
    }
//    @Test
//    public void test_getProfile(){
//        Response response = RequestData.getProfile();
//        softAssertion.assertEquals(200,response.getStatusCode());
//        softAssertion.assertEquals(response.jsonPath().get("data.kycStatus"),"rejected_temporarily");
//        softAssertion.assertAll();
//    }
}