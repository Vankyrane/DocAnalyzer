package com.docanalyzer.project.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DocumentServiceImpl implements  DocumentService {

    private Map<String, Long> wordFrequency = new HashMap<>();

    @Override
    public Map<String, Long> getWordFrequency(Long documentId) {
        return wordFrequency;
    }
}
