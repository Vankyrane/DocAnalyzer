package com.docanalyzer.project.controller;

import com.docanalyzer.project.service.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//API to get Synonyms for the words
@RestController
public class GeminiController {

    @Autowired
    private GeminiService geminiService;

    public ResponseEntity<List<String>> getSynonyms(@PathVariable Long documentId) throws Throwable {
        List<String> synonymsWord = geminiService.getSynonymsForLongestWord(documentId);
        return new ResponseEntity<>(synonymsWord, HttpStatus.OK);
    }
}
