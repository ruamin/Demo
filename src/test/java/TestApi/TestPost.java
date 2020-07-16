package TestApi;

import Base.BaseTest;
import api.RequestData;
import constants.TestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Info;
import org.junit.Before;
import org.junit.Test;
public class TestPost extends BaseTest {
    Info f = new Info();
    @Before
    public void init() {
        f.setName(TestData.NAME);
        f.setJob(TestData.JOB);
    }
    @Test
    public void test_2() {
        Response res = RequestData.postInfo(f);
        JsonPath js = new JsonPath(RequestData.postInfo(f).asString());
        softAssertion.assertEquals(201, res.getStatusCode());
        softAssertion.assertEquals(f.getName(), js.get("name"));
        softAssertion.assertEquals(f.getJob(), js.get("job"));
        softAssertion.assertAll();
    }
    }
