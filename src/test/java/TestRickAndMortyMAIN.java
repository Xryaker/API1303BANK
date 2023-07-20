import org.junit.Assert;
import org.junit.Test;
import rest.ApiRequest;

public class TestRickAndMortyMAIN {
    public static final String URL = "https://rickandmortyapi.com/api";
    @Test
    public void test1(){
        Assert.assertEquals(200, ApiRequest.getSAtatus(URL));
    }
}
