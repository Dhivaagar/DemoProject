import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class TestRailApiExample {

    private static final String TESTRAIL_URL = "https://your-testrail-instance.com";
    private static final String TESTRAIL_USERNAME = "your-username";
    private static final String TESTRAIL_API_KEY = "your-api-key";
    private static final int PROJECT_ID = 1; // Replace with your project ID
    private static final int TEST_RUN_ID = 123; // Replace with your test run ID

    public static void main(String[] args) {
        String resultsJson = "{\"results\": [{\"case_id\": 1, \"status_id\": 1}, {\"case_id\": 2, \"status_id\": 5}]}";

        try {
            pushTestResults(resultsJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void pushTestResults(String resultsJson) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String url = TESTRAIL_URL + "/index.php?/api/v2/add_results_for_cases/" + TEST_RUN_ID;

        String auth = TESTRAIL_USERNAME + ":" + TESTRAIL_API_KEY;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + encodedAuth)
                .POST(HttpRequest.BodyPublishers.ofString(resultsJson))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println("Test results successfully pushed to TestRail.");
        } else {
            System.out.println("Failed to push test results. Status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());
        }
    }
}
