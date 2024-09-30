package com.docanalyzer.project.service;

import java.util.Map;

public interface DocumentService {

    public Map<String, Long> getWordFrequency(Long documentId);
}
