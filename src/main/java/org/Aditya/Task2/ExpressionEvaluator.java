package org.Aditya.Task2;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ExpressionEvaluator {

    private static final String API_URL = "http://api.mathjs.org/v4/"; // Replace with the actual API URL

    public static String evaluateExpression(String expression) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost(API_URL);

            // Create the JSON object
            JSONObject requestBody = new JSONObject();
            JSONArray expressionsArray = new JSONArray();
            expressionsArray.put(expression);
            requestBody.put("expr", expressionsArray);
            requestBody.put("precision", 14);

            StringEntity requestEntity = new StringEntity(requestBody.toString(), "UTF-8");
            request.setEntity(requestEntity);
            request.setHeader("Content-Type", "application/json");

            HttpResponse response = httpClient.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());

            if (response.getStatusLine().getStatusCode() == 200) {
                JSONObject responseJson = new JSONObject(responseBody);
                JSONArray resultsArray = responseJson.getJSONArray("result");
                return resultsArray.getString(0); // Assuming one result per expression
            } else {
                return "Error: " + response.getStatusLine().getReasonPhrase();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Unable to fetch result";
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
