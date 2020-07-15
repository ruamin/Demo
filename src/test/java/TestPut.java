import Base.BaseTest;
import api.RequestData;
import constants.TestData;
import models.Info;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPut extends BaseTest {
    Info f = new Info();
    Response res;
    @Before
    public void init() {
        f.setName(TestData.NAME);
        f.setJob(TestData.JOB);
        res = RequestData.postInfo(f);
    }

    @Test
    public void test_3() {
        f.setName(res.jsonPath().get("name") + "sotatek");
        f.setJob(TestData.JOB);
        Response response = RequestData.putInfo(f);
        softAssertion.assertEquals(200, response.getStatusCode());
        softAssertion.assertEquals(f.getName(), response.jsonPath().getString("name"));
        softAssertion.assertAll();
    }
}
