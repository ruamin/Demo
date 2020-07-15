package constants;
public class Endpoints {
    public static final String BASE_URI="https://reqres.in/api";
    public static final String API_POST=BASE_URI+"/users";
    public static final String API_GET=BASE_URI+"/users/{id}";
    public static final String API_PUT=BASE_URI+"/users";
    public static final String API_GETDATA = BASE_URI+"/unkown";
    public static final String API_DEL = BASE_URI+"/users/{id}";

    public static final String APP_ID = "2b1fd2d7f77ccf1b7de9b441571b39b8";
    public static final String API_GET_DES = "https://samples.openweathermap.org/data/2.5/weather?q={q}&appid="+ APP_ID;

}
