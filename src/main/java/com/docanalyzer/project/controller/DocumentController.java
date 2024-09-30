package com.docanalyzer.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DocumentController {

    private Map<String, Long>  wordFrequency = new HashMap<>();

    @GetMapping("/word-frequency/{documentId}")
    public Map<String, Long> getWordFrequency(@PathVariable Long documentId) {
        return wordFrequency;
    }
}
