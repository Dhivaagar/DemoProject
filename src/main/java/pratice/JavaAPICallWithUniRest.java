package pratice;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class JavaAPICallWithUniRest {

    public static void getMethod() throws UnirestException {

        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.get("https://reqres.in/api/users?page=2").asJson();
        System.out.println(jsonNodeHttpResponse.getStatus());
        System.out.println(jsonNodeHttpResponse.getStatusText());
        System.out.println(jsonNodeHttpResponse.getBody());
    }

    public static void postMethod() throws UnirestException {

        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.post("https://reqres.in/api/users")
                .body("\"{\\n\\\"name\\\": \\\"Dhivaagar\\\",\\n\\\"job\\\": \\\"Automation\\\"\\n}\"").asJson();
        System.out.println(jsonNodeHttpResponse.getStatus());
        System.out.println(jsonNodeHttpResponse.getStatusText());
        System.out.println(jsonNodeHttpResponse.getBody());
    }

    public static void putMethod() throws UnirestException {

        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.put("https://reqres.in/api/users/525")
                .body("{\n\"name\": \"Dhivaagar\",\n\"job\": \"Automation\"\n}").asJson();
        System.out.println(jsonNodeHttpResponse.getStatus());
        System.out.println(jsonNodeHttpResponse.getStatusText());
        System.out.println(jsonNodeHttpResponse.getBody());
    }

    public static void deleteMethod() throws UnirestException {

        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.delete("https://reqres.in/api/users/525").asJson();
        System.out.println(jsonNodeHttpResponse.getStatus());
        System.out.println(jsonNodeHttpResponse.getStatusText());
        System.out.println(jsonNodeHttpResponse.getBody());
    }

    public static void main(String[] args) throws UnirestException {
        JavaAPICallWithUniRest.getMethod();
//        JavaAPICallWithUniRest.postMethod(); //525
//        JavaAPICallWithUniRest.putMethod();
//        JavaAPICallWithUniRest.deleteMethod();
    }

}
