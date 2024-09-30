package com.docanalyzer.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AIApiClient {

    @Value("${google.gemini.api.key}")
    private String apiKey;

    @Value("${google.gemini.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<String> getSynonyms(String prompt) {

        //return List.of("synonym1", "synonym2", "synonym3");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        // Build request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("prompt", prompt);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // Make the API call
        ResponseEntity<Map> response = restTemplate.postForEntity(apiUrl, entity, Map.class);

        // Process the response and extract the synonyms (assuming the structure contains 'choices')
        Map<String, Object> result = response.getBody();
        List<String> synonyms = new ArrayList<>();

        if (result != null && result.containsKey("choices")) {
            // Example response processing: you might need to adjust this based on actual API response
            List<Map<String, Object>> choices = (List<Map<String, Object>>) result.get("choices");
            for (Map<String, Object> choice : choices) {
                String text = (String) choice.get("text");
                synonyms.add(text.trim());
            }
        }

        return synonyms;
    }
}
