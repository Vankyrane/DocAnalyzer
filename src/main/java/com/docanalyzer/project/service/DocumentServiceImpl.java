package com.docanalyzer.project.service;

import com.docanalyzer.project.repository.DocumentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Service to find the word frequency based on business rules
@Service
public class DocumentServiceImpl implements  DocumentService {

    private Map<String, Long> wordFrequency = new HashMap<>();

    @Autowired
    private DocumentRepository documentRepository;

    //Set of strings to maintain commons words to be filtered.
    private static final Set<String> filterWords = Set.of("the", "me", "you", "i", "of", "and", "a", "we");
    @Override
    public Map<String, Long> getWordFrequency(Long documentId) throws Throwable {
        org.w3c.dom.Document document = (org.w3c.dom.Document) documentRepository.findById(documentId).orElseThrow(() -> new EntityNotFoundException("Document not found"));

        String content = document.getTextContent();

        String[] words = content.toLowerCase().split("\\W+");

        //Java streams implementation to filter and collect common words
        Map<String, Long> wordCountMap = Arrays.stream(words)
                .filter(word -> !filterWords.contains(word))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return wordCountMap.entrySet().stream()
                                  .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                                  .limit(10)
                                  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
