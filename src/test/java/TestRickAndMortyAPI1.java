import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.ApiRequest;

import java.util.List;

public class TestRickAndMortyAPI1 {

    static JSONObject character;

    @BeforeClass
    public static void bb() {
        JSONObject mainApi = new JSONObject(ApiRequest.getRest(TestRickAndMortyMAIN.URL));
        String characterURL = mainApi.getString("characters");
        character = new JSONObject(ApiRequest.getRest(characterURL));
//        character=new JSONObject(ApiRequest.getRest(
//                new JSONObject(ApiRequest.getRest(URL))
//                        .getString("characters")));
    }

    @Test
    public void test1() {
        System.out.println(character.toString());
    }

    @Test
    public void test2() {
        JSONObject info = character.getJSONObject("info");
        System.out.println(info.getString("next"));
        System.out.println(info.getInt("count"));
        Assert.assertFalse(info.isNull("prev"));//isNull(<fieldName>) return boolean 'true' if field == null
        System.out.println(info.getString("prev"));
    }

    @Test
    public void test3() {
        JSONArray results = character.getJSONArray("results");
        JSONObject character = results.getJSONObject(0);
        System.out.println(character.getString("name"));
        JSONObject origin = character.getJSONObject("origin");
        System.out.println(origin.getString("name"));
        JSONObject location = character.getJSONObject("location");
        System.out.println(location.getString("name"));
        JSONArray episodes = character.getJSONArray("episode");
        System.out.println(episodes.get(0).toString());
    }

    @Test
    public void test4() {
        for (Object l : character.getJSONArray("results")) {
            JSONObject charact = (JSONObject) l;
            System.out.println(charact.getString("name"));
            System.out.println(charact.getJSONObject("origin").getString("name"));
            System.out.println(charact.getJSONObject("location").getString("name"));
            System.out.println(charact.getJSONArray("episode").get(0).toString());
        }

    }

    @Test
    public void test54() {
        JSONArray charactersFROMresults = character.getJSONArray("results");
        for (int i = 0; i < charactersFROMresults.length(); i++) {
            JSONObject charact = charactersFROMresults.getJSONObject(i);
            System.out.println(charact.getString("name"));
            System.out.println(charact.getJSONObject("origin").getString("name"));
            System.out.println(charact.getJSONObject("location").getString("name"));
            System.out.println(charact.getJSONArray("episode").get(0).toString());
        }
    }

}
