package com.docanalyzer.project.service;

import com.docanalyzer.project.repository.DocumentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Service Layer to filter the longest word to find the synonyms
@Service
public class GeminiServiceImpl implements GeminiService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private AIApiClient aiApiClient;
    @Override
    public List<String> getSynonymsForLongestWord(Long documentId) throws Throwable {

        Document document = (Document) documentRepository.findById(documentId)
                .orElseThrow(() -> new EntityNotFoundException("Document not found"));
        String content = document.getTextContent();

        String longestWord = Arrays.stream(content.split("\\W+"))
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        // Preparing prompt for suggestion from Google Gemini
        String prompt = "Suggest synonyms for the word: " + longestWord;
        return aiApiClient.getSynonyms(prompt);
    }
}
