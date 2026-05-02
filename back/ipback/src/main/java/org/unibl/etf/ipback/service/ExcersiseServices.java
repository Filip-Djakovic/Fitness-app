package org.unibl.etf.ipback.service;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.unibl.etf.ipback.entities.Excersise;

import java.util.List;

@Service
public class ExcersiseServices {
    private final String API_URL = "https://api.api-ninjas.com/v1/exercises?muscle=biceps";
    private final String API_KEY = "+93mSk/48ORKvUvYiWIFBA==HqEIQv0dhICLAv5Y";

    public List<Excersise> getExercises() {
        RestTemplate restTemplate = new RestTemplate();

        // Set up the headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", API_KEY);

        // Create the request entity
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Make the GET request
        ResponseEntity<String> response = restTemplate.exchange(API_URL,
                HttpMethod.GET,
                entity,
                String.class);

        // Convert the JSON response to a list of Exercise objects
        ObjectMapper mapper = new ObjectMapper();
        List<Excersise> exercises = null;
        try {
            exercises = mapper.readValue(response.getBody(), new TypeReference<List<Excersise>>() {});
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }

        return exercises;
    }
}
