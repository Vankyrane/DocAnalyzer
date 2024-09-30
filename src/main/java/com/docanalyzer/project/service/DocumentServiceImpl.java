package com.docanalyzer.project.service;

import com.docanalyzer.project.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DocumentServiceImpl implements  DocumentService {

    private Map<String, Long> wordFrequency = new HashMap<>();

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Map<String, Long> getWordFrequency(Long documentId) {
        return wordFrequency;
    }
}
