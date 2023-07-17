import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static rest.ApiRequest.getRest;

public class Test2 {
    static JSONArray bank;

    @BeforeClass
    public static void bb() {
        bank = new JSONArray(getRest("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json"));
    }

    @Test
    public void test1() {
        for (int i = 0; i < bank.length(); i++) {
            JSONObject object= bank.getJSONObject(i);
            System.out.println(object.getString("cc")+" = "+object.getDouble("rate"));
        }
    }
    @Test
    public void test2(){
        for (Object o : bank) {
            JSONObject object=(JSONObject) o;
            System.out.println(object.getString("cc")+" = "+object.getDouble("rate"));
        }
    }
}
