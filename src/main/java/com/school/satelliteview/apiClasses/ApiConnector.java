package com.school.satelliteview.apiClasses;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConnector {
    public String searchSatellite(String wantedSatelliteID) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://tle.ivanstanojevic.me/api/tle/" + wantedSatelliteID + "/propagate"))
                    .GET().build();
            HttpResponse<String> response = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        return null;
    }
}
