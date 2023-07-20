import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import objects.rickAndMortyCharacters.CharacterAPI;
import objects.rickAndMortyCharacters.persons.Person;
import objects.rickAndMortyLocation.Location;
import objects.rickAndMortyLocation.Result;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.ApiRequest;

public class TestRickAndMortyAPI2 {

    static Location main;
    static ObjectMapper om=new ObjectMapper();
    @BeforeClass
    public static void bb() throws JsonProcessingException {

//        JSONObject mainApi = new JSONObject(ApiRequest.getRest(URL));
//        String locationsURL = mainApi.getString("locations");
//        ObjectMapper om = new ObjectMapper();
//        Location root = om.readValue(ApiRequest.getRest(locationsURL), Location.class);
//
         main=om.readValue(
                ApiRequest.getRest(
                        new JSONObject(
                                ApiRequest.getRest(TestRickAndMortyMAIN.URL)).getString("locations")), Location.class);
    }
    @Test
    public void test1() throws JsonProcessingException {
        for (Result result : main.results) {
            System.out.println(result.name+" - "+result.type+" :");
            for (String resident : result.residents) {
                Person person=om.readValue(ApiRequest.getRest(resident),Person.class);
                System.out.print(person.name+", ");
            }
            System.out.println("");
        }
    }

}
