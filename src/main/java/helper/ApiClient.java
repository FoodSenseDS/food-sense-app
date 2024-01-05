package helper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ApiClient {
    private static String BASE_URL = "https://foodsenseapi-demo.azuremicroservices.io/foodsense/api/v0.0.1/";
    
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();
    
    public static <T> T sendGetRequest(String path, Class<T> responseType) throws Exception {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + path))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
        return gson.fromJson(getResponse.body(), responseType);
    }
    public static <T> T sendPostRequest(String path, Object requestBody, Class<T> responseType) throws Exception {
        String jsonRequest = gson.toJson(requestBody);
        System.out.println(jsonRequest);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + path))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(jsonRequest))
                .build();

        HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
        
        if(postResponse.statusCode() == 200 || postResponse.statusCode() == 201){
            try {
                return gson.fromJson(postResponse.body(), responseType);
            }
            catch(JsonSyntaxException e){
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                return null;
            }
        }
        else {
            handleErrorResponse(postResponse);
            return null;
        }
    }
    
    private static void handleErrorResponse(HttpResponse<String> response) {
        System.out.println("Error Status Code: " + response.statusCode());
        System.out.println("Error Response Body: " + response.body());
    }
}


