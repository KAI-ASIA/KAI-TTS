package generics.httpCommon;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class KaiHttpClient {


    public <T> T callRestApi(String url, String userName, Class<T> responseType){
       try{
           RestTemplate restTemplate = new RestTemplate();
           ObjectMapper mapper = new ObjectMapper();
           mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

           // Thiết lập headers
           HttpHeaders headers = new HttpHeaders();
           headers.set("x-rapidapi-key", "Key tự đăng ký rồi lấy nhé");
           headers.set("x-rapidapi-host", "Key tự đăng ký rồi lấy nhé");
           headers.setContentType(MediaType.APPLICATION_JSON);

           String requestBody = "{\"username\":\"" + userName + "\"}";


           HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

           ResponseEntity<String> response = restTemplate.exchange(
                   url,
                   HttpMethod.POST,
                   entity,
                   String.class
           );
//           System.out.println(response.getBody());
           JSONObject jsonpObject = new JSONObject(response.getBody());

           return mapper.readValue(jsonpObject.toString(), responseType);

       }catch (Exception e){
           return null;
       }
    }


}
