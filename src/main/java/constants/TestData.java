package constants;

import java.io.InputStream;
import java.util.Properties;

public class TestData {
    private static final Properties data;
    public static final String NAME;
    public static final String JOB;
    public static final String Q;
    public static final String APP_ID;

    static {
        data = new Properties();
        InputStream is = TestData.class.getResourceAsStream("/data.properties");
        try {
            data.load(is);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        NAME = data.getProperty("name");
        JOB = data.getProperty("job");
        Q=data.getProperty("q");
        APP_ID=data.getProperty("appid");
    }
}
