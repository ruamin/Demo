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
}