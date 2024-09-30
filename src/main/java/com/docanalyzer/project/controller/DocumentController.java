package com.docanalyzer.project.controller;

import com.docanalyzer.project.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/word-frequency/{documentId}")
    public Map<String, Long> getWordFrequency(@PathVariable Long documentId) {
        return documentService.getWordFrequency(documentId);
    }
}
