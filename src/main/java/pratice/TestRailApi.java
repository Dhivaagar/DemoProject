package pratice;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class TestRailApi {

//    -DtestrailHost="sunpower.testrail.io"
//     -DtestrailPassword=sunpower123!
//     -DtestrailUserName=automation-user@sunpower.com
    // TestRail API base URL
    private static final String TESTRAIL_BASE_URL = "https://sunpower.testrail.io/";
    // TestRail API username and password (or API token)
    private static final String TESTRAIL_USERNAME = "automation-user@sunpower.com";
    private static final String TESTRAIL_PASSWORD = "sunpower123!";

    // Method to check if a case ID is in a TestRail plan
    public static boolean isCaseInPlan(int caseId, int planId) throws IOException {
        String url = TESTRAIL_BASE_URL + "index.php?/api/v2/get_plan/" + planId;

        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-Type", "application/json");
        httpGet.setHeader("Authorization", "Basic " + getAuthString(TESTRAIL_USERNAME, TESTRAIL_PASSWORD));

        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            String responseBody = EntityUtils.toString(entity);
            JSONObject jsonObject = new JSONObject(responseBody);

            // Check if the response contains the entries key (which contains the test runs)
            if (jsonObject.has("entries")) {
                JSONArray entries = jsonObject.getJSONArray("entries");
                for (int i = 0; i < entries.length(); i++) {
                    JSONObject entry = entries.getJSONObject(i);
                    JSONArray runs = entry.getJSONArray("runs");
                    for (int j = 0; j < runs.length(); j++) {
                        JSONObject run = runs.getJSONObject(j);
                        JSONArray caseIds = run.getJSONArray("case_ids");
                        for (int k = 0; k < caseIds.length(); k++) {
                            if (caseIds.getInt(k) == caseId) {
                                return true; // Case ID found in plan
                            }
                        }
                    }
                }
            }
        }

        return false; // Case ID not found in plan
    }

    // Helper method to get the Base64 encoded authentication string
    private static String getAuthString(String username, String password) {
        String auth = username + ":" + password;
        return java.util.Base64.getEncoder().encodeToString(auth.getBytes());
    }

    // Example usage
    public static void main(String[] args) {
        int caseId = 296207;
        int planId = 52511;
        try {
            boolean isInPlan = isCaseInPlan(caseId, planId);
            System.out.println("Is case ID " + caseId + " in plan ID " + planId + ": " + isInPlan);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
