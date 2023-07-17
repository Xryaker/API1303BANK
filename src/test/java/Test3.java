import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import objects.bankGo.Exchange;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.ApiRequest;

public class Test3 {
    static final String URL="https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    static Exchange[] exchange;
    static ObjectMapper om;
    @BeforeClass
    public static void bb() throws JsonProcessingException {
         om = new ObjectMapper();
        exchange=om.readValue(ApiRequest.getRest(URL),Exchange[].class);
    }
    @Test
    public void test1(){
        System.out.println(exchange[0].cc);
    }
    @Test
    public void tets2(){
        for (Exchange l : exchange) {
            System.out.println(l.cc);
            System.out.println(l.exchangedate + " = " + l.vasiliy);
        }
    }
}
