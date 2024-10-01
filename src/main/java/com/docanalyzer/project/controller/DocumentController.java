package com.docanalyzer.project.controller;

import com.docanalyzer.project.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/word-frequency/{documentId}")
    public ResponseEntity<Map<String, Long>> getWordFrequency(@PathVariable Long documentId) throws Throwable {
            Map<String, Long> wordFrequency = documentService.getWordFrequency(documentId);
            return new ResponseEntity<>(wordFrequency, HttpStatus.OK);
    }
}
