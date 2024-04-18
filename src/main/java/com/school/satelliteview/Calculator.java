package com.school.satelliteview;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.satelliteview.apiClasses.ApiConnector;
import com.school.satelliteview.apiClasses.Geodetic;

public class Calculator {
    ApiConnector apiConnector = new ApiConnector();
    ObjectMapper objectMapper = new ObjectMapper();
    public String[] getCoordinates(String searchedSatellite) throws JsonProcessingException{
        Geodetic geodetic = objectMapper.readValue(apiConnector.searchSatellite(searchedSatellite), Geodetic.class);
        double latitude = geodetic.getGeodeticCoords().getLatitude();
        double longitude = geodetic.getGeodeticCoords().getLongitude();

        // Umwandlung des Längengrads in den Bereich von -180° bis +180°
        if (longitude > 180) {
            longitude -= 360;
        }

        String[] coordinates = new String[2];
        coordinates[0] = String.valueOf(latitude);
        coordinates[1] = String.valueOf(longitude);
        return coordinates;
    }
}
