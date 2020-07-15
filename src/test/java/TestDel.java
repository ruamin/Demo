import Base.BaseTest;
import api.RequestData;
import io.restassured.response.Response;
import org.junit.Test;

public class TestDel extends BaseTest {

    @Test
    public void test_04(){
        Response res= RequestData.del(2);
        softAssertion.assertEquals(204,res.getStatusCode());
    }
}
