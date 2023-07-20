import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import objects.rickAndMortyCharacters.CharacterAPI;
import objects.rickAndMortyCharacters.Result;
import objects.rickAndMortyLocation.Location;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.ApiRequest;
import util.IMAGE;

import java.io.IOException;

public class TestRickAndMortyIMG {
    static ObjectMapper om = new ObjectMapper();
    static CharacterAPI main;
    @BeforeClass
    public static void bb() throws JsonProcessingException {

//        JSONObject mainApi = new JSONObject(ApiRequest.getRest(URL));
//        String locationsURL = mainApi.getString("locations");
//        ObjectMapper om = new ObjectMapper();
//        Location root = om.readValue(ApiRequest.getRest(locationsURL), Location.class);
//
        main = om.readValue(
                ApiRequest.getRest(
                        new JSONObject(
                                ApiRequest.getRest(TestRickAndMortyMAIN.URL)).getString("characters")), CharacterAPI.class);
    }
    @Test
    public void test1() throws IOException {
        for (Result result : main.results) {
            IMAGE.download(result.image,result.name);
        }
    }
}
