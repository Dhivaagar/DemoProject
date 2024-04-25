package pratice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.poi.ss.formula.functions.Na;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Base64;

public class TestRailIntegration {

    // Method to check if a test case is present in a TestRail test run
    public boolean isTestCasePresentInTestRun(int runId, int testCaseId) {
        try {
            // TestRail API URL for getting tests in a run
            String url = "https://sunpower.testrail.io/index.php?/api/v2/get_tests/" + runId;

            // Encode username and password for Basic Authentication
            String username = "automation-user@sunpower.com";
            String password = "sunpower123!";
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
            String authHeader = "Basic " + new String(encodedAuth);

            // Send request with Basic Authentication
            Response response = RestAssured.given()
                    .header("Authorization", authHeader)
                    .get(url);

            // Parse JSON response
            JSONParser parser = new JSONParser();
            JSONArray tests = (JSONArray) parser.parse(response.body().asString());

            // Check if the test case is present in the tests array
            for (Object obj : tests) {
                JSONObject test = (JSONObject) obj;
                int caseId = ((Long) test.get("case_id")).intValue();
                if (caseId == testCaseId) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        TestRailIntegration testRailIntegration = new TestRailIntegration();
        int runId = 53086; // Replace with the actual TestRail run ID
        int testCaseId = 287690; // Replace with the actual TestRail test case ID
        boolean testCasePresent = testRailIntegration.isTestCasePresentInTestRun(runId, testCaseId);
        System.out.println("Test Case Present in Test Run: " + testCasePresent);
    }
}
