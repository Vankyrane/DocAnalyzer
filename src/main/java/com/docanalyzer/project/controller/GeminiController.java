package com.docanalyzer.project.controller;

import com.docanalyzer.project.service.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeminiController {

    @Autowired
    private GeminiService geminiService;

    public List<String> getSynonyms(@PathVariable Long documentId) throws Throwable {
        return geminiService.getSynonymsForLongestWord(documentId);
    }

}
